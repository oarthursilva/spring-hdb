package com.sap.jpa.hdb.services;

import com.sap.jpa.hdb.model.dto.ProductsResponse;
import com.sap.jpa.hdb.model.entities.Products;
import com.sap.jpa.hdb.storages.ProductsStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

  private final ProductsStorage productsStorage;

  @Autowired
  public ProductsService(ProductsStorage productsStorage) {
    this.productsStorage = productsStorage;
  }

  public ProductsResponse handleRetrieveProducts() {
    List<Products> productsList = productsStorage.getAllProducts();
    return new ProductsResponse(productsList);
  }

}
