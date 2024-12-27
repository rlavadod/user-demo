package com.demo.user.service;

import com.demo.user.mapper.UserMapper;
import com.demo.user.mapper.UserMapperImpl;
import com.demo.user.model.api.User;
import com.demo.user.model.entity.UserEntity;
import com.demo.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserMapper userMapper;
  @Mock
  private JwtServiceImpl jwtService;
  @Mock
  private UserRepository repository;
  @InjectMocks
  private UserServiceImpl userService;

  @BeforeEach
  void setUp() {
  }

  @Test
  void testSaveUserWhenIsSuccessful() {
    //Arrange
    User user = new User();
    user.setEmail("user@dominio.cl");
    UserEntity entity = new UserEntity();
    entity.setEmail("user@dominio.cl");
    Mockito.when(repository.save(Mockito.any(UserEntity.class)))
        .thenReturn(entity);
    Mockito.when(userMapper.userToUserEntity(Mockito.any(User.class)))
        .thenReturn(entity);
    Mockito.when(userMapper.entityToUser(Mockito.any(UserEntity.class)))
        .thenReturn(user);
    Mockito.when(jwtService.generateToken(Mockito.any(User.class)))
        .thenReturn("sadfasdfasdfasdfasdf");
    //Act
    User response = userService.saveUser(user);
    //Assert
    Assertions.assertEquals(user.getEmail(), response.getEmail());
  }

  @Test
  void testGetAllUsersWhenExistUsers() {
    //Arrange
    UserEntity userE1 = new UserEntity();
    UserEntity userE2 = new UserEntity();
    User user = new User();

    Mockito.when(repository.findAll())
        .thenReturn(Arrays.asList(userE1, userE2));
    Mockito.when(userMapper.entityToUser(Mockito.any(UserEntity.class)))
        .thenReturn(user);
    //Act
    List<User> users = userService.getAllUsers();
    //Assert
    Assertions.assertFalse(users.isEmpty());
  }

  @Test
  void testGetUserByIdWhenUserNotExist() {
    //Arrange
    UUID id = UUID.randomUUID();
    Optional<UserEntity> userEntity = Optional.empty();
    Mockito.when(repository.findById(Mockito.any()))
        .thenReturn(userEntity);
    //Act
    User response = userService.getUserById(id);
    //Assert
    Assertions.assertNull(response);
  }

  @Test
  void testGetUserByIdWhenUserExist() {
    //Arrange
    UUID id = UUID.randomUUID();
    UserEntity entity = new UserEntity();
    entity.setEmail("user@dominio.cl");
    Optional<UserEntity> userEntity = Optional.of(entity);
    User user = new User();
    user.setEmail("user@dominio.cl");
    Mockito.when(repository.findById(Mockito.any()))
        .thenReturn(userEntity);
    Mockito.when(userMapper.entityToUser(Mockito.any(UserEntity.class)))
        .thenReturn(user);
    //Act
    User response = userService.getUserById(id);
    //Assert
    Assertions.assertEquals(user.getEmail(), response.getEmail());
  }

  @Test
  void testDeleteUserByIdWhenTheDeleteIsSuccessful() {
    //Arrange
    UUID id = UUID.randomUUID();
    //Act
    userService.deleteUserById(id);
    //Assert
    Mockito.verify(repository, Mockito.times(1))
        .deleteById(id);
  }

  @Test
  void testUpdateUserWhenTheUserExist() {
    //Arrange
    UserEntity entity = new UserEntity();
    entity.setEmail("user@dominio.cl");
    User user = new User();
    user.setEmail("user@dominio.cl");
    Mockito.when(repository.save(Mockito.any(UserEntity.class)))
        .thenReturn(entity);
    Mockito.when(userMapper.userToUserEntity(Mockito.any(User.class)))
        .thenReturn(entity);
    Mockito.when(userMapper.entityToUser(Mockito.any(UserEntity.class)))
        .thenReturn(user);
    //Act
    User response = userService.updateUser(user);
    //Assert
    Assertions.assertEquals(entity.getEmail(), response.getEmail());
  }

  @Test
  void testGetUserByEmailWhenTheUserNotFound() {
    //Arrange
    String email = "email@dominio.cl";
    Mockito.when(repository.findByEmail(Mockito.anyString()))
        .thenReturn(new ArrayList<>());
    //Act
    Boolean flag = userService.getUserByEmail(email);
    //Assert
    Assertions.assertTrue(flag);
  }
}