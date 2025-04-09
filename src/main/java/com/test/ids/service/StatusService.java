package com.test.ids.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ids.model.Status;
import com.test.ids.repository.StatusDb;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusService {
  @Autowired
  private StatusDb statusDb;

  public void addStatus(Status status) {
    statusDb.save(status);
  }

  public void addListStatus(List<Status> status) {
    statusDb.saveAll(status);
  }
}
