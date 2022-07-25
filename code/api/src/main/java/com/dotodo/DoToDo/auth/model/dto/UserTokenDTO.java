package com.dotodo.DoToDo.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTokenDTO {

  @NotBlank(message = "Email cannot be blank")
  private String email;

  @NotBlank(message = "User token cannot be blank")
  private String userToken;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z")
  private Date lastUpdatedTimestamp;
}
