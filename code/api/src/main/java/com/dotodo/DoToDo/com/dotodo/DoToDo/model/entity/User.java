package com.dotodo.DoToDo.com.dotodo.DoToDo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {

  private String name;
  private String password;

  @Id private String email;
  private String phone;
}
