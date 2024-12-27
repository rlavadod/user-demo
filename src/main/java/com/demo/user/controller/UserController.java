package com.demo.user.controller;

import com.demo.user.model.api.ErrorBody;
import com.demo.user.model.api.User;
import com.demo.user.service.UserService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/")
  public ResponseEntity<?> saveUser(@RequestBody @Valid User user) {
    try {
      if (!userService.getUserByEmail(user.getEmail())) {
        throw new Exception("El correo ya registrado");
      }
      return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorBody(e.getMessage()));
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable UUID id) {
    User user = userService.getUserById(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorBody("Usuario no encontrado"));
    }
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @PatchMapping("/")
  public ResponseEntity<?> updateUser(@RequestBody @Valid User user) {
    User validUser = userService.getUserById(user.getId());
    if (validUser == null) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorBody("Usuario no encontrado"));
    }
    return ResponseEntity.ok(userService.updateUser(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
    User user = userService.getUserById(id);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorBody("Usuario no encontrado"));
    }
    userService.deleteUserById(id);
    return ResponseEntity.noContent().build();
  }
}
