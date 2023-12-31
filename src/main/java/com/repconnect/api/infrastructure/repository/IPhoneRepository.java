package com.repconnect.api.infrastructure.repository;


import com.repconnect.api.infrastructure.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<PhoneEntity, Integer> {
}
