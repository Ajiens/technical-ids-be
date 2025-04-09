package com.test.ids.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponseDTO {
  
  private Long id;
  private String productID;
  private String productName;
  private Integer amount;
  private String customerName;
  private String status;
  private Date transactionDate;
  private String createBy;
  private Date createOn;
}
