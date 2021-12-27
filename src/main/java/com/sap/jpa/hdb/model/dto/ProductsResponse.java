package com.sap.jpa.hdb.model.dto;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sap.jpa.hdb.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"data"})
public class ProductsResponse {

  @Builder.Default
  private List<Product> data = new ArrayList<>();

}
