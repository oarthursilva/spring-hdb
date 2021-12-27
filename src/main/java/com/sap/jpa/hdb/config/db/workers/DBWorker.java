package com.sap.jpa.hdb.config.db.workers;

import com.sap.jpa.hdb.config.db.models.dto.DataSourceProperties;
import org.springframework.stereotype.Component;

@Component
public interface DBWorker {

  Class<?> getDialect();

  DataSourceProperties buildDataSourceProperties();
}
