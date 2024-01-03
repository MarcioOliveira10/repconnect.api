package com.repconnect.api.infrastructure.dto.invoiceData;

import java.time.LocalDateTime;

public record InvoiceDataResponse(
        String code,
        String pdfLink,
        String excelLink,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
