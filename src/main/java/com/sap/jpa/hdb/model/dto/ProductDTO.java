package com.sap.jpa.hdb.model.dto;

import java.util.Date;
import java.util.UUID;

import com.sap.jpa.hdb.model.entities.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {

  private UUID uuid;

  private String name;

  private String status;

  private double price;

  private Integer satisfactionRate;

  private Date createDate;

  public ProductDTO(Product productEntity) {
    uuid = UUID.fromString(productEntity.getProductUuid());
    name = productEntity.getProductName();
    status = productEntity.getStatus();
    price = productEntity.getPrice();
    satisfactionRate = productEntity.getSatisfactionRate();
    createDate = productEntity.getCreateDate();
  }

  public Product toEntity(ProductDTO productDTO) {
    Product product = new Product();
    product.setProductUuid(String.valueOf(productDTO.getUuid()));
    product.setProductName(productDTO.getName());
    product.setStatus(productDTO.getStatus());
    product.setPrice(productDTO.getPrice());
    product.setSatisfactionRate(productDTO.getSatisfactionRate());
    product.setCreateDate(productDTO.getCreateDate());
    return product;
  }

}
