package com.repconnect.api.infrastructure.repository;


import com.repconnect.api.infrastructure.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<AddressEntity, Integer> {
}
