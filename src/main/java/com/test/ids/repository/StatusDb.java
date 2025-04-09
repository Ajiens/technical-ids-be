package com.test.ids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ids.model.Status;

@Repository
public interface StatusDb extends JpaRepository<Status, Integer> {
  
}