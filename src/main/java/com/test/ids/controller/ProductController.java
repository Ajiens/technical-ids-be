package com.test.ids.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ids.dto.BaseResponseDTO;
import com.test.ids.dto.ProductResponseDTO;
import com.test.ids.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/viewall")
  public ResponseEntity<BaseResponseDTO<?>> getAllProduct() {
    var baseResponseDTO = new BaseResponseDTO<List<ProductResponseDTO>>();

    List<ProductResponseDTO> productResponse = productService.getAllProduct();

    baseResponseDTO.setStatus(200);
    baseResponseDTO.setData(productResponse);
    baseResponseDTO.setMessage("Success retreive all product data");
    baseResponseDTO.setTimestamp(new Date());

    return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
  }
}
