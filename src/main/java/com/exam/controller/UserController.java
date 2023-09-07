package com.exam.controller;

import com.exam.entity.User;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

  @Autowired UserService userService;
  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {

    // encoding password
    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
    User newUser = userService.createUser(user);

    return ResponseEntity.status(HttpStatus.OK).body(newUser);
  }

  @GetMapping("/user")
  public ResponseEntity<List<User>> getUser() {

    return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
  }
}
