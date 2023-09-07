package com.exam.service;

import com.exam.Repository.UserRepository;
import com.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class userDetailsService implements UserDetailsService {

  @Autowired private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = this.userRepository.findByUsername(username);

    if (Objects.isNull(user)) {
      System.out.println(user);
      throw new UsernameNotFoundException("Enter Valid Credentials");
    }

    return user;
  }
}
