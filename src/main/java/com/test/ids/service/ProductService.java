package com.test.ids.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ids.dto.ProductResponseDTO;
import com.test.ids.dto.request.AddProductRequest;
import com.test.ids.model.Product;
import com.test.ids.repository.ProductDb;
import com.test.ids.repository.StatusDb;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
  @Autowired
  private ProductDb productDb;

  @Autowired
  private StatusDb statusDb;

  public List<ProductResponseDTO> getAllProduct(){
    List<Product> products = productDb.findAll();
    
    List<ProductResponseDTO> productResponse = new ArrayList<>();
    for (Product product : products) {
      productResponse.add(productToProductResponseDTO(product));
    }

    return productResponse;
  }

  public void addProduct(AddProductRequest productDTO) {
    System.out.println(productDTO);

    Product product = new Product();
    product.setProductID(productDTO.getProductID());
    product.setProductName(productDTO.getProductName());
    product.setAmount(productDTO.getAmount());
    product.setCustomerName(productDTO.getCustomerName());
    product.setTransactionDate(productDTO.getTransactionDate());
    product.setCreateBy(productDTO.getCreateBy());
    product.setCreateOn(productDTO.getCreateOn());

    product.setStatus(statusDb.findById(productDTO.getStatus()).orElse(null));

    productDb.save(product);
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
