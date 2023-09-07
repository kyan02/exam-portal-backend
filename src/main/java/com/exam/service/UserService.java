package com.exam.service;

import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private RoleRepository roleRepository;

  public User createUser(User user) throws Exception {

    User userByEmailExist = userRepository.findOneByEmail(user.getEmail());

    if (Objects.nonNull(userByEmailExist)) throw new Exception("User by this Email already Exist");

    return userRepository.save(user);
  }

  public List<User> getAllUser() {

    return userRepository.findAll();
  }
}
