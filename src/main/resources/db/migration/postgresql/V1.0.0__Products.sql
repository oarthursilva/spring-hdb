DROP TABLE IF EXISTS "com.sap.jpa.hana.tables::products";
--DROP TABLE IF EXISTS product;

CREATE TABLE "com.sap.jpa.hana.tables::products" (
--CREATE TABLE product (
    PRODUCT_UUID            varchar(100) UNIQUE NOT NULL,
    PRODUCT_NAME            varchar(500),
    STATUS                  varchar(50),
    PRICE                   double precision,
    SATISFACTION_RATE       double precision,
    CREATEDATE              date,
    PRIMARY KEY (PRODUCT_UUID)
);

COMMIT;
