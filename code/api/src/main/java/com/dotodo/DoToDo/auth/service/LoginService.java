package com.dotodo.DoToDo.auth.service;

import com.dotodo.DoToDo.auth.dao.UserTokenRepository;
import com.dotodo.DoToDo.auth.model.entity.UserToken;
import com.dotodo.DoToDo.dao.UserRepository;
import com.dotodo.DoToDo.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
      Optional<User> optionalUserDetails = userRepository.findByEmail(user.getEmail());
      if (optionalUserDetails.isPresent()
          && user.getPassword().equals(optionalUserDetails.get().getPassword())) {
        Optional<UserToken> optionalUserTokenDetails =
            userTokenRepository.findByEmail(user.getEmail());
        if (optionalUserTokenDetails.isPresent()) {
          return optionalUserTokenDetails.get().getToken();
        }
      }
    }
    return null;
  }
}
