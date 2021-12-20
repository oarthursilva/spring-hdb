package com.sap.jpa.hdb.repositories;

import com.sap.jpa.hdb.model.entities.Products;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsReadOnlyRepository extends ReadOnlyRepository<Products, String> {
}
