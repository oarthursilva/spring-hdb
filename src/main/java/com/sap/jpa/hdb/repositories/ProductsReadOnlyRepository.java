package com.sap.jpa.hdb.repositories;

import com.sap.jpa.hdb.model.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsReadOnlyRepository extends ReadOnlyRepository<Product, String> {

  //@Query(value = "SELECT * FROM \"com.sap.jpa.hana.tables::products\"", nativeQuery = true)
  @Query(value = "SELECT * FROM product", nativeQuery = true)
  List<Product> findAll();


}
