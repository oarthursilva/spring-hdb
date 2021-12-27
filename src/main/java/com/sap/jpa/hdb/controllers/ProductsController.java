package com.sap.jpa.hdb.controllers;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sap.jpa.hdb.constants.ProductsConstants;
import com.sap.jpa.hdb.model.dto.ProductDTO;
import com.sap.jpa.hdb.model.dto.ProductsResponse;
import com.sap.jpa.hdb.services.ProductsService;

@RestController
@Validated
@RequestMapping(ProductsConstants.PATH)
public class ProductsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

  private final ProductsService productsService;

  @Autowired
  public ProductsController(ProductsService productsService) {
    this.productsService = productsService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductsResponse> getAllProducts() {
    LOGGER.info("Starting of retrieving products");
    ProductsResponse response = productsService.handleRetrieveProducts();
    LOGGER.info("End of retrieving products");
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
    LOGGER.info("Starting of creating product");

    productDTO = productsService.handleCreateProduct(productDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{uuid}").buildAndExpand(productDTO.getUuid()).toUri();

    LOGGER.info("End of product creation");
    return ResponseEntity.created(uri).body(productDTO);
  }
}