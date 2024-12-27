package com.demo.user.repository;

import com.demo.user.model.entity.UserEntity;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
  List<UserEntity> findByEmail(String email);
}
