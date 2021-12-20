package com.sap.jpa.hdb.model.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sap.jpa.hdb.model.entities.Products;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@JsonPropertyOrder({"data"})
public class ProductsResponse {

  private final List<Products> data;

}
