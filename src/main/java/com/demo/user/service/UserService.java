package com.demo.user.service;

import com.demo.user.model.api.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
  User saveUser(User user);
  List<User> getAllUsers();
  User getUserById(UUID id);
  void deleteUserById(UUID id);
  User updateUser(User user);
  Boolean getUserByEmail(String email);
}
