package com.dotodo.DoToDo.com.dotodo.DoToDo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotBlank(message = "Username cannot be blank")
  private String username;

  @NotBlank(message = "Password cannot be blank")
  private String password;

  @NotBlank(message = "Email cannot be blank")
  private String email;

  @NotBlank(message = "Phone cannot be blank")
  private String phone;
}
