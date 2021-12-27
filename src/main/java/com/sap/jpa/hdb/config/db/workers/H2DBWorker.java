package com.sap.jpa.hdb.config.db.workers;

import org.hibernate.dialect.H2Dialect;

import com.sap.jpa.hdb.config.db.models.dto.DataSourceProperties;

public class H2DBWorker implements DBWorker {

  private static final String DEFAULT_SCHEMA = "INFORMATION_SCHEMA";

  private static final String H2_URL = "jdbc:h2:mem:testdb";

  private static final String H2_USERNAME = "sa";

  private static final String H2_PASSWORD = "";

  private static final String H2_DRIVER = "org.h2.Driver";

  @Override
  public Class<?> getDialect() {
    return H2Dialect.class;
  }

  @Override
  public DataSourceProperties buildDataSourceProperties() {
    return new DataSourceProperties(H2_URL, H2_USERNAME, H2_PASSWORD, H2_DRIVER);
  }

}
