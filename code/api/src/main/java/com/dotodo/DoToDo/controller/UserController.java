package com.dotodo.DoToDo.controller;

import com.dotodo.DoToDo.com.dotodo.DoToDo.model.dto.UserDTO;
import com.dotodo.DoToDo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{email}")
  public ResponseEntity<UserDTO> getUser(@PathVariable String email) {
    return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
    return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
    return new ResponseEntity<>(userService.updateUser(userDTO), HttpStatus.OK);
  }

  @DeleteMapping("/{email}")
  public ResponseEntity<UserDTO> deleteUser(@PathVariable String email) {
    return new ResponseEntity<>(userService.deleteUser(email), HttpStatus.NOT_FOUND);
  }
}
