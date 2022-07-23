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

  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Email not valid", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
  private String email;

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 8, max = 16, message = "Password size must be between 8 and 16 characters")
  private String password;

  @NotBlank(message = "Phone cannot be blank")
  private String phone;
}
