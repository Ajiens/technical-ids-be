package com.test.ids.model;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "productID")
  private String productID;

  @NotNull
  @Column(name = "productName")
  private String productName;

  @NotNull
  @Column(name = "amount")
  private Integer amount;

  @NotNull
  @Column(name = "customerName")
  private String customerName;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "status", referencedColumnName = "id") // FK dari Product ke Status
  private Status status;
  
  @NotNull
  @Column(name = "transactionDate")
  private Date transactionDate;

  @NotNull
  @Column(name = "createBy")
  private String createBy;

  @NotNull
  @Column(name = "createOn")
  private Date createOn;
}
