package com.sap.jpa.hdb.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@Table(name = "com.sap.jpa.hana.calcviews.products")
public class Products implements SerializableEntity {

  @Id
  @Column(name = "PRODUCT_GUID", insertable = false)
  private String productGuid;

  @Column(name = "PRODUCT_NAME", insertable = false)
  private String productName;

  @Column(name = "STATUS", insertable = false)
  private String status;

  @Column(name = "PRICE", insertable = false)
  private Double price;

  @Column(name = "SATISFACTION_RATE", insertable = false)
  private Integer satisfactionRate;

  @Column(name = "CREATEDATE", insertable = false)
  private Date createDate;

}
