package com.sap.jpa.hdb.repositories;

import org.springframework.stereotype.Repository;

import com.sap.jpa.hdb.model.entities.Product;

@Repository
public interface ProductsReadOnlyRepository extends ReadOnlyRepository<Product, String> {
}
