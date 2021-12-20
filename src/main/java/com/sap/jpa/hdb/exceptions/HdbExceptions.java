package com.sap.jpa.hdb.exceptions;

public class HdbExceptions extends RuntimeException {

  public static final String NO_DATA = "No products found";

  public HdbExceptions(String message) {
    super(message);
  }

}
