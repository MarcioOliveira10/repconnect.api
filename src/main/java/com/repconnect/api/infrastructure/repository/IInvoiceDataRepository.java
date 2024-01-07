package com.repconnect.api.infrastructure.repository;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IInvoiceDataRepository extends JpaRepository<InvoiceDataEntity, Integer> {
    Optional<InvoiceDataEntity> findByCode(String code);
   @Transactional
   @Modifying
   @Query("DELETE FROM InvoiceDataEntity i WHERE i.code = :code")
    void deleteByCode(@Param("code") String code);


//    @Transactional
//    @Modifying
//    @Query("UPDATE InvoiceDataEntity i SET i.pdfLink = :pdfLink, i.excelLink = :excelLink WHERE i.code = :code")
//    void updateByCode(@Param("code") String code, @Param("pdfLink") String pdfLink, @Param("excelLink") String excelLink);
}
