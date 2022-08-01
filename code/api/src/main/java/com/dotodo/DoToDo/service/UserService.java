package com.dotodo.DoToDo.service;

import com.dotodo.DoToDo.auth.dao.UserTokenRepository;
import com.dotodo.DoToDo.auth.model.entity.UserToken;
import com.dotodo.DoToDo.model.dto.UserDTO;
import com.dotodo.DoToDo.model.entity.User;
import com.dotodo.DoToDo.dao.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

  private final Logger logger = LoggerFactory.getLogger(UserService.class);
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
  private final UserTokenRepository userTokenRepository;

  @Autowired
  public UserService(
      UserRepository userRepository,
      ModelMapper modelMapper,
      UserTokenRepository userTokenRepository) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.userTokenRepository = userTokenRepository;
  }

  public UserDTO getUser(String email) {
    User user = new User();
    Optional<User> optionalUserDetails = userRepository.findByEmail(email);
    optionalUserDetails.ifPresentOrElse(
        optionalUser -> {
          user.setEmail(optionalUser.getEmail());
          user.setFirstName(optionalUser.getFirstName());
          user.setLastName(optionalUser.getLastName());
        },
        () -> logger.error("User with email " + email + " does not exist."));
    return modelMapper.map(user, UserDTO.class);
  }

  public UserDTO createUser(UserDTO userDto) {
    User user = modelMapper.map(userDto, User.class);
    UserToken userToken = new UserToken();
    if (userRepository.existsByEmail(user.getEmail())) {
      logger.error("User with email " + user.getEmail() + " already exists.");
      return modelMapper.map(new User(), UserDTO.class);
    }
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    User savedUser = userRepository.save(user);
    userToken.setEmail(userDto.getEmail());
    userToken.setToken(UUID.randomUUID().toString());
    userToken.setLastUpdatedTimestamp(new Date());
    userTokenRepository.save(userToken);
    return modelMapper.map(savedUser, UserDTO.class);
  }

  public UserDTO updateUser(UserDTO userDto) {
    User user = modelMapper.map(userDto, User.class);
    if (userRepository.existsByEmail(user.getEmail())) {
      user.setFirstName(userDto.getFirstName());
      user.setLastName(userDto.getLastName());
      user.setPassword(userDto.getPassword());
      User savedUser = userRepository.save(user);
      return modelMapper.map(savedUser, UserDTO.class);
    } else {
      logger.error("User by email " + user.getEmail() + "does not exist.");
      return modelMapper.map(new User(), UserDTO.class);
    }
  }

  public UserDTO deleteUser(String email) {
    if (userRepository.existsByEmail(email)) {
      userRepository.deleteByEmail(email);
      logger.info("Deleted user by email " + email);
    } else {
      logger.error("User by email " + email + "does not exist.");
    }
    return modelMapper.map(new User(), UserDTO.class);
  }
}
