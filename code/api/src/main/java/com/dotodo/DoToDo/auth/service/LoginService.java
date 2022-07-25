package com.dotodo.DoToDo.auth.service;

import com.dotodo.DoToDo.auth.dao.UserTokenRepository;
import com.dotodo.DoToDo.dao.UserRepository;
import com.dotodo.DoToDo.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private final Logger logger = LoggerFactory.getLogger(LoginService.class);

  private final UserTokenRepository userTokenRepository;

  private final UserRepository userRepository;

  @Autowired
  public LoginService(UserTokenRepository userTokenRepository, UserRepository userRepository) {
    this.userTokenRepository = userTokenRepository;
    this.userRepository = userRepository;
  }

  public String login(User user) {
    if (user.getEmail() == null
        || user.getEmail().isBlank()
        || user.getPassword() == null
        || user.getPassword().isEmpty()) {
      logger.error("Email or password incorrect");
      return null;
    } else {
      String password = userRepository.findPasswordByEmail(user.getEmail());
      if (!password.equals(user.getPassword())) {
        logger.error("Email or password incorrect");
        return null;
      } else {
        String token = userTokenRepository.findTokenByEmail(user.getEmail());
        return token;
      }
    }
  }
}
