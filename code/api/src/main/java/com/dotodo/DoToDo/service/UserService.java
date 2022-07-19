package com.dotodo.DoToDo.service;

import com.dotodo.DoToDo.com.dotodo.DoToDo.model.dto.UserDTO;
import com.dotodo.DoToDo.com.dotodo.DoToDo.model.entity.User;
import com.dotodo.DoToDo.dao.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final Logger logger = LoggerFactory.getLogger(UserService.class);
  @Autowired private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  public UserService(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  public UserDTO createUser(UserDTO userDto) {
    User user = modelMapper.map(userDto, User.class);
    user.setName(userDto.getName());
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setPhone(userDto.getPhone());
    return modelMapper.map(user, UserDTO.class);
  }

  public UserDTO updateUser(UserDTO userDto) {

  }


}
