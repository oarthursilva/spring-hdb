package com.sap.jpa.hdb.config.db.annotations;

import com.sap.jpa.hdb.config.db.enums.DatabaseEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Database {

  DatabaseEnum database() default DatabaseEnum.HANA;

}
