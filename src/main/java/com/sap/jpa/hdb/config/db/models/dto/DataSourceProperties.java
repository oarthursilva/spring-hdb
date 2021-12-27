package com.sap.jpa.hdb.config.db.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataSourceProperties {

  private String url;

  private String username;

  private String password;

  private String driver;

}
