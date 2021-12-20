package com.sap.jpa.hdb.storages;

import com.sap.jpa.hdb.exceptions.HdbExceptions;
import com.sap.jpa.hdb.exceptions.NoProductsException;
import com.sap.jpa.hdb.model.entities.Products;
import com.sap.jpa.hdb.repositories.ProductsReadOnlyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsStorage {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductsStorage.class);

  private final ProductsReadOnlyRepository repository;

  @Autowired
  public ProductsStorage(ProductsReadOnlyRepository repository) {
    this.repository = repository;
  }

  public List<Products> getAllProducts() throws NoProductsException {
    List<Products> productsList = repository.findAll();

    if (productsList.isEmpty()) {
      LOGGER.info("No products found");
      throw new NoProductsException(HdbExceptions.NO_DATA);
    }

    LOGGER.info("Total of products retrieved {}", productsList.size());
    return productsList;
  }

}
