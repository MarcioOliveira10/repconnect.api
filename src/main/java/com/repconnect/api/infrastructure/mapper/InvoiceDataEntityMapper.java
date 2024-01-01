package com.repconnect.api.infrastructure.mapper;

import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;

public class InvoiceDataEntityMapper {
    public InvoiceDataEntity toEntity(InvoiceData invoiceDataDomainObj) {
        return new InvoiceDataEntity(
                invoiceDataDomainObj.code(),
                invoiceDataDomainObj.pdfLink(),
                invoiceDataDomainObj.excelLink(),
                invoiceDataDomainObj.createdAt(),
                invoiceDataDomainObj.updatedAt());
    }

    public InvoiceData toInvoiceData(InvoiceDataEntity invoiceDataEntity) {
        return new InvoiceData(
                invoiceDataEntity.getId(),
                invoiceDataEntity.getCode(),
                invoiceDataEntity.getPdfLink(),
                invoiceDataEntity.getExcelLink(),
                invoiceDataEntity.getCreatedAt(),
                invoiceDataEntity.getUpdatedAt());
    }
}
