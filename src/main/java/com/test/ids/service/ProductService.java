package com.test.ids.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ids.dto.ProductResponseDTO;
import com.test.ids.model.Product;
import com.test.ids.repository.ProductDb;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
  @Autowired
  private ProductDb productDb;

  public List<ProductResponseDTO> getAllProduct(){
    List<Product> products = productDb.findAll();
    
    List<ProductResponseDTO> productResponse = new ArrayList<>();
    for (Product product : products) {
      productResponse.add(productToProductResponseDTO(product));
    }

    return productResponse;
  }

  public void addListProduct(List<Product> product) {
    productDb.saveAll(product);
  }

  private ProductResponseDTO productToProductResponseDTO(Product product) {
    ProductResponseDTO productResponse = new ProductResponseDTO();
    productResponse.setId(product.getId());
    productResponse.setProductID(product.getProductID());
    productResponse.setProductName(product.getProductName());
    productResponse.setAmount(product.getAmount());
    productResponse.setCustomerName(product.getCustomerName());
    productResponse.setTransactionDate(product.getTransactionDate());
    productResponse.setCreateBy(product.getCreateBy());
    productResponse.setCreateOn(product.getCreateOn());

    if (product.getStatus() != null) {
      productResponse.setStatus(product.getStatus().getName());
    }

    return productResponse;
  }
}
