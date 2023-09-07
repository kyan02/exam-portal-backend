package com.exam.Repository;

import com.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

  User findOneByEmail(String email);

  User findByUsername(String username);

  List<User> findAll();
}
