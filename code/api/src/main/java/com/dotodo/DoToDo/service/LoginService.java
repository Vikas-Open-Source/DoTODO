package com.dotodo.DoToDo.service;

import com.dotodo.DoToDo.com.dotodo.DoToDo.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  public String login(User user) {
    if ("email".equalsIgnoreCase("email") && "password".equalsIgnoreCase("password")) {
      return "token";
    } else {
      return null;
    }
  }
}
