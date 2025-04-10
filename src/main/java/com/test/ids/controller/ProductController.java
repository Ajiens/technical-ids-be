package com.test.ids.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ids.dto.BaseResponseDTO;
import com.test.ids.dto.ProductResponseDTO;
import com.test.ids.dto.request.AddProductRequest;
import com.test.ids.service.ProductService;

import jakarta.validation.Valid;

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

  @PostMapping("/add")
  public ResponseEntity<BaseResponseDTO<?>> addProduct(
    @Valid @RequestBody AddProductRequest addProductRequest,
    BindingResult bindingResult
  ) {
    var baseResponseDTO = new BaseResponseDTO<>();

    if (bindingResult.hasErrors()){
      String errorMessages = "";
      List<FieldError> errors = bindingResult.getFieldErrors();
      for (FieldError error : errors) {
          errorMessages += error.getDefaultMessage() + "; ";
      }
      baseResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
      baseResponseDTO.setMessage(errorMessages);
      baseResponseDTO.setTimestamp(new Date());
      return new ResponseEntity<>(baseResponseDTO, HttpStatus.BAD_REQUEST);
    }

    productService.addProduct(addProductRequest);

    baseResponseDTO.setStatus(200);
    baseResponseDTO.setMessage("Success add product data");
    baseResponseDTO.setTimestamp(new Date());

    return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
  }
}
