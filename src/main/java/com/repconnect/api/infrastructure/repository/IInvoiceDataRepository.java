package com.repconnect.api.infrastructure.repository;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IInvoiceDataRepository extends JpaRepository<InvoiceDataEntity, Integer> {
    Optional<InvoiceDataEntity> findByCode(String code);
}
