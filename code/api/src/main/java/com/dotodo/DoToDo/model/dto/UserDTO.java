package com.dotodo.DoToDo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 8, max = 16)
  private String password;

  @NotBlank(message = "Email cannot be blank")
  @Email
  private String email;

  @NotBlank(message = "Phone cannot be blank")
  private String phone;
}
