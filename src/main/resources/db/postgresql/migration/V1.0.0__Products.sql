DROP TABLE IF EXISTS "com.sap.jpa.hana.tables::products";

CREATE TABLE "com.sap.jpa.hana.tables::products" (
    "PRODUCT_GUID"            varchar(100) UNIQUE NOT NULL,
    "PRODUCT_NAME"            varchar(500),
    "STATUS"                  varchar(50),
    "PRICE"                   double precision,
    "SATISFACTION_RATE"       double precision,
    "CREATEDATE"              date,
    PRIMARY KEY ("PRODUCT_GUID")
);

COMMIT;
