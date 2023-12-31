package com.repconnect.api.infrastructure.repository;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IInvoiceDataRepository extends JpaRepository<InvoiceDataEntity, Integer> {
}
