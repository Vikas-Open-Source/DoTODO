package com.dotodo.DoToDo.com.dotodo.DoToDo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cities")
public class User {

  private String name;
  private String username;
  private String password;
  private String email;
  private String phone;
}
