package com.demo.user.controller;

import com.demo.user.model.api.User;
import com.demo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
  }

  @GetMapping("/")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @PatchMapping("/")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.updateUser(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<User> deleteUser(@PathVariable UUID id) {
    userService.deleteUserById(id);
    return ResponseEntity.noContent().build();
  }
}
