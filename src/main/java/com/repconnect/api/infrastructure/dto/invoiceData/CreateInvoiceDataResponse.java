package com.repconnect.api.infrastructure.dto.invoiceData;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record CreateInvoiceDataResponse(
        String code,
        String pdfLink,
        String excelLink,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}