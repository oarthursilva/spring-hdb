package com.sap.jpa.hdb.config.db.workers;

import org.hibernate.dialect.HANAColumnStoreDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.jpa.hdb.config.db.models.dto.DataSourceProperties;
import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfService;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;

public class HanaDBWorker implements DBWorker {

  private static final String HANA_TAG = "hana";
  private static final String HANA_DRIVER = com.sap.db.jdbc.Driver.class.getName();

  private static final Logger LOGGER = LoggerFactory.getLogger(HanaDBWorker.class.getName());

  private final CfJdbcEnv cfJdbcEnv;

  public HanaDBWorker() {
    this.cfJdbcEnv = new CfJdbcEnv();
  }

  @Override
  public Class<?> getDialect() {
    return HANAColumnStoreDialect.class;
  }

  @Override
  public DataSourceProperties buildDataSourceProperties() {
    CfService cfService = cfJdbcEnv.findAllServices().get(0);
    CfCredentials credentials = cfService.getCredentials();

    String url = credentials.getUriInfo().getUriString();
    String username = credentials.getUsername();
    String password = credentials.getPassword();

    LOGGER.info("HANA url: {}", url);
    LOGGER.info("HANA username: {}", username);
    LOGGER.info("HANA password: {}", password);

    return new DataSourceProperties(url, username, password, HANA_DRIVER);
  }
}
