package com.test.ids.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductRequest {

  @NotNull (message = "Product ID cannot be empty")
  private Long id;

  @NotEmpty (message = "Product ID cannot be empty")
  private String productID;

  @NotEmpty (message = "Product Name cannot be empty")
  private String productName;

  @NotNull (message = "Amount cannot be null")
  private Integer amount;

  @NotEmpty (message = "Customer Name cannot be empty")
  private String customerName;

  @NotNull (message = "Status cannot be empty")
  private Integer status;

  @NotNull (message = "Transaction Date cannot be null")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
  private Date transactionDate;

  @NotEmpty (message = "Create By cannot be empty")
  private String createBy;

  @NotNull (message = "Transaction Date cannot be null")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
  private Date createOn;
}
