package com.repconnect.api.infrastructure.repository;

import com.repconnect.api.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
