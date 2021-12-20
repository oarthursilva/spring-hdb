package com.sap.jpa.hdb.controllers;

import com.sap.jpa.hdb.constants.ProductsConstants;
import com.sap.jpa.hdb.model.dto.ProductsResponse;
import com.sap.jpa.hdb.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(ProductsConstants.PATH)
public class ProductsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

  private final ProductsService productsService;

  @Autowired
  private ProductsController(ProductsService productsService) {
    this.productsService = productsService;
  }

  @ResponseBody
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductsResponse> getAllProducts() {
    LOGGER.info("Starting of retrieving products");
    ProductsResponse response = productsService.handleRetrieveProducts();
    LOGGER.info("End of retrieving products");
    return ResponseEntity.ok(response);
  }
}