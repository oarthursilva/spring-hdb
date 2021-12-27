package com.sap.jpa.hdb.config.db.models.builder;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import com.sap.jpa.hdb.config.db.models.dto.DataSourceProperties;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class DataSourceCreator {

  public DataSource create(DataSourceProperties props) {
    String url = props.getUrl();
    String username = props.getUsername();
    String password = props.getPassword();
    String driver = props.getDriver();

    return DataSourceBuilder.create()
            .type(HikariDataSource.class)
            .url(url)
            .username(username)
            .password(password)
            .driverClassName(driver)
            .build();
  }

}
