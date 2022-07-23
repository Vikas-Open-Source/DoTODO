package com.dotodo.DoToDo.service;

import com.dotodo.DoToDo.model.dto.UserDTO;
import com.dotodo.DoToDo.model.entity.User;
import com.dotodo.DoToDo.dao.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final Logger logger = LoggerFactory.getLogger(UserService.class);
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public UserService(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  public UserDTO getUser(String email) {
    User user = new User();
    Optional<User> optionalUserDetails = userRepository.findByEmail(email);
    optionalUserDetails.ifPresentOrElse(
        optionalUser -> {
          user.setEmail(optionalUser.getEmail());
          user.setPhone(optionalUser.getPhone());
          user.setName(optionalUser.getName());
        },
        () -> logger.error("User with email " +  email + " does not exist."));
    return modelMapper.map(user, UserDTO.class);
  }

  public UserDTO createUser(UserDTO userDto) {
    User user = modelMapper.map(userDto, User.class);
    if(userRepository.existsByEmail(user.getEmail())) {
      logger.error("User with email " +  user.getEmail() + " already exists.");
      return modelMapper.map(new User(), UserDTO.class);
    }
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setPhone(userDto.getPhone());
    User savedUser = userRepository.save(user);
    return modelMapper.map(savedUser, UserDTO.class);
  }

  public UserDTO updateUser(UserDTO userDto) {
    User user = modelMapper.map(userDto, User.class);
    if (userRepository.existsByEmail(user.getEmail())) {
      user.setName(userDto.getName());
      user.setPassword(userDto.getPassword());
      user.setPhone(userDto.getPhone());
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
