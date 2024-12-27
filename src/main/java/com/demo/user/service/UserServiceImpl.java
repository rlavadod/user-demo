package com.demo.user.service;

import com.demo.user.mapper.UserMapper;
import com.demo.user.model.api.User;
import com.demo.user.model.entity.UserEntity;
import com.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private JwtServiceImpl jwtService;

  public User saveUser(User user) {
    UserEntity entity = userMapper.userToUserEntity(user);
    entity.setCreated(new Date());
    entity.setToken(jwtService.generateToken(user));
    UserEntity response = repository.save(entity);
    return userMapper.entityToUser(response);
  }

  @Override
  public List<User> getAllUsers() {
    return repository.findAll()
        .stream()
        .map(userMapper::entityToUser)
        .toList();
  }

  @Override
  public User getUserById(UUID id) {
    Optional<UserEntity> userEntity = repository.findById(id);
    User user = null;
    if (userEntity.isPresent()) {
      user = userMapper.entityToUser(userEntity.get());
    }
    return user;
  }

  @Override
  public void deleteUserById(UUID id) {
    repository.deleteById(id);
  }

  @Override
  public User updateUser(User user) {
    user.setModified(new Date());
    UserEntity userUpdated = repository.save(userMapper.userToUserEntity(user));
    return userMapper.entityToUser(userUpdated);
  }

  @Override
  public Boolean getUserByEmail(String email) {
    return repository.findByEmail(email).isEmpty();
  }
}
