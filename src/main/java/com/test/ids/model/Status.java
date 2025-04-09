package com.test.ids.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "status")
public class Status {
  @Id
  private Integer id;
  
  @NotNull
  @Column(name = "name")
  private String name;
}
