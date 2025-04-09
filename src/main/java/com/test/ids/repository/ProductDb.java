package com.test.ids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ids.model.Product;

@Repository
public interface ProductDb extends JpaRepository<Product, Long> {

}