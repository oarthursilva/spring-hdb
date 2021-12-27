package com.sap.jpa.hdb.services;

import com.sap.jpa.hdb.exceptions.NoProductsException;
import com.sap.jpa.hdb.model.dto.ProductDTO;
import com.sap.jpa.hdb.model.dto.ProductsResponse;
import com.sap.jpa.hdb.model.entities.Product;
import com.sap.jpa.hdb.storages.ProductsStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

  private final ProductsStorage productsStorage;

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductsService.class.getName());

  @Autowired
  public ProductsService(ProductsStorage productsStorage) {
    this.productsStorage = productsStorage;
  }

  public ProductsResponse handleRetrieveProducts() {
    try {
      List<Product> productList = productsStorage.getAll();
      return new ProductsResponse(productList);

    } catch (NoProductsException e) {
      return new ProductsResponse(new ArrayList<>());
    }
  }

  public ProductDTO handleCreateProduct(ProductDTO productDTO) {
    Product entity = productDTO.toEntity(productDTO);
    LOGGER.info(entity.toString());
    return productsStorage.save(entity);
  }
}
