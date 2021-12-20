package com.sap.jpa.hdb.config;

import org.springframework.stereotype.Component;

@Component
public class DBConfig {

}

/**
 * @Configuration
 * @Profile("cloud") public class DBConfig extends AbstractCloudConfig {
 * @Bean
 * @Primary public DataSourceProperties dataSourceProperties() {
 * CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
 * DataSourceProperties properties = new DataSourceProperties();
 * <p>
 * CfCredentials credentials = cfJdbcEnv.findCredentialsByTag("hana");
 * <p>
 * if (Objects.nonNull(credentials)) {
 * String uri = credentials.getUri("hana");
 * properties.setUrl(uri);
 * properties.setUsername(credentials.getUsername());
 * properties.setPassword(credentials.getPassword());
 * }
 * return properties;
 * }
 * <p>
 * }
 **/