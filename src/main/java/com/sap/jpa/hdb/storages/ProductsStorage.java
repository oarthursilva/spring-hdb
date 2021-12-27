package com.sap.jpa.hdb.storages;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.jpa.hdb.exceptions.HdbExceptions;
import com.sap.jpa.hdb.exceptions.NoProductsException;
import com.sap.jpa.hdb.model.dto.ProductDTO;
import com.sap.jpa.hdb.model.entities.Product;
import com.sap.jpa.hdb.repositories.ProductsReadOnlyRepository;

@Component
public class ProductsStorage {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductsStorage.class.getName());

  private final ProductsReadOnlyRepository repository;

  @Autowired
  public ProductsStorage(ProductsReadOnlyRepository repository) {
    this.repository = repository;
  }

  public List<Product> getAll() throws NoProductsException {
    List<Product> productList = repository.findAll();

    if (productList.isEmpty()) {
      LOGGER.info("No products found");
      throw new NoProductsException(HdbExceptions.NO_DATA);
    }

    LOGGER.info("Total of products retrieved {}", productList.size());
    return productList;
  }

  @Transactional
  public ProductDTO save(Product entity) {
    entity = repository.save(entity);
    return new ProductDTO(entity);
  }

}
