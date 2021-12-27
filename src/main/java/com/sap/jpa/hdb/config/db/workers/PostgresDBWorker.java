package com.sap.jpa.hdb.config.db.workers;

import java.util.Objects;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.jpa.hdb.config.db.models.dto.DataSourceProperties;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;
import io.pivotal.cfenv.jdbc.CfJdbcService;

public class PostgresDBWorker implements DBWorker {

  public static final Logger LOGGER = LoggerFactory.getLogger(PostgresDBWorker.class.getName());
  private final CfJdbcEnv cfJdbcEnv;

  public PostgresDBWorker() {
    this.cfJdbcEnv = new CfJdbcEnv();
  }

  @Override
  public Class<?> getDialect() {
    return PostgreSQL94Dialect.class;
  }

  @Override
  public DataSourceProperties buildDataSourceProperties() {
    CfJdbcService cfJdbcService = cfJdbcEnv.findJdbcService();

    if (Objects.isNull(cfJdbcService)) {
      LOGGER.info("'cfJdbcService' is null");
      return new H2DBWorker().buildDataSourceProperties();
    }

    String url = cfJdbcService.getJdbcUrl();
    String username = cfJdbcService.getUsername();
    String password = cfJdbcService.getPassword();
    String postgresDriver = cfJdbcService.getDriverClassName();

    LOGGER.info("Postgres driver info: {}, {}, {}, {}", url, username, password, postgresDriver);

    return new DataSourceProperties(url, username, password, postgresDriver);
  }
}
