package com.sap.jpa.hdb.model.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "\"com.sap.jpa.hana.tables::products\"")
public class Product implements SerializableEntity {

  @Id
  @Column(name = "PRODUCT_UUID")
  public String productUuid;

  @Column(name = "PRODUCT_NAME")
  public String productName;

  @Column(name = "STATUS")
  public String status;

  @Column(name = "PRICE")
  public Double price;

  @Column(name = "SATISFACTION_RATE")
  public Integer satisfactionRate;

  @Column(name = "CREATEDATE")
  public Date createDate;

}

