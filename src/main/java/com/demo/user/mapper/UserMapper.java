package com.demo.user.mapper;

import com.demo.user.model.api.User;
import com.demo.user.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

  UserEntity userToUserEntity(User user);
  User entityToUser(UserEntity entity);
}
