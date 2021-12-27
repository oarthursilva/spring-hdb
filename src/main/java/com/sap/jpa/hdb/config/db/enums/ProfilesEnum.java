package com.sap.jpa.hdb.config.db.enums;

public enum ProfilesEnum {
  TEST("test"), DEV("dev"), CF("cf");

  private final String profile;

  ProfilesEnum(String profile) {
    this.profile = profile;
  }

  public String getCode() {
    return profile;
  }
}
