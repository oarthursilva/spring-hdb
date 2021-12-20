FROM postgres:14.1-alpine

RUN mkdir -p /docker-entrypoint-initdb.d
ADD db-init.sql /docker-entrypoint-initdb.d
