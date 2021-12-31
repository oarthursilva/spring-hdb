package com.sap.jpa.hdb.config.db.beans;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.sap.jpa.hdb.config.db.constants.DatabaseConstants;
import com.sap.jpa.hdb.config.db.enums.ProfilesEnum;
import com.sap.jpa.hdb.config.db.exceptions.ProfileNotSupportedException;
import com.sap.jpa.hdb.config.db.models.builder.DataSourceCreator;
import com.sap.jpa.hdb.config.db.models.dto.DataSourceProperties;
import com.sap.jpa.hdb.config.db.workers.DBWorker;
import com.sap.jpa.hdb.config.db.workers.H2DBWorker;
import com.sap.jpa.hdb.config.db.workers.HanaDBWorker;
import com.sap.jpa.hdb.config.db.workers.PostgresDBWorker;
import io.pivotal.cfenv.core.CfEnv;

@Configuration
public class DatabaseBean {

  private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseBean.class.getName());
  private final ApplicationContext applicationContext;
  private final Environment environment;

  private final CfEnv cfEnv = new CfEnv();

  @Autowired
  public DatabaseBean(ApplicationContext applicationContext, Environment environment) {
    this.applicationContext = applicationContext;
    this.environment = environment;
  }

  @Bean(name = DatabaseConstants.BEAN_DB_WORKER)
  public DBWorker defineDBWorker() {
    boolean isTestProfile = environment.acceptsProfiles(Profiles.of(ProfilesEnum.TEST.getCode()));
    boolean isDevProfile = environment.acceptsProfiles(Profiles.of(ProfilesEnum.DEV.getCode()));
    boolean isCfProfile = environment.acceptsProfiles(Profiles.of(ProfilesEnum.CF.getCode()));

    if (isTestProfile) {
      return new H2DBWorker();
    } else if (isDevProfile) {
      return new PostgresDBWorker();
    } else if (isCfProfile && cfEnv.isInCf()) {
      return new HanaDBWorker();
    } else if (isCfProfile && !cfEnv.isInCf()) {
      return new H2DBWorker();
    } else {
      throw new ProfileNotSupportedException("Profile not supported. Use one of: test, dev, cf");
    }
  }

  @Bean(name = DatabaseConstants.BEAN_DATA_SOURCE)
  public DataSource createDataSource() {
    DBWorker dbWorker = (DBWorker) applicationContext.getBean(DatabaseConstants.BEAN_DB_WORKER);
    LOGGER.info("JPA DBWorker instanceof: {}", dbWorker.getClass().getName());
    DataSourceProperties dataSourceProperties = dbWorker.buildDataSourceProperties();

    return new DataSourceCreator().create(dataSourceProperties);
  }

  @DependsOn(DatabaseConstants.BEAN_DATA_SOURCE)
  @Bean(name = DatabaseConstants.BEAN_ENTITY_MANAGER_FACTORY)
  public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(DataSource dataSource, DBWorker jpaConfigurationCreator) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
    entityManagerFactoryBean.setPackagesToScan("com.sap.jpa.hdb.model", "com.sap.jpa.hdb.repositories");

    Map<String, Object> jpaPropertiesMap = new HashMap<>();
    jpaPropertiesMap.put(org.hibernate.cfg.Environment.DIALECT, jpaConfigurationCreator.getDialect().getName());
    jpaPropertiesMap.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
    entityManagerFactoryBean.setJpaPropertyMap(jpaPropertiesMap);

    return entityManagerFactoryBean;
  }
}
