package com.repconnect.api.core.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public record InvoiceData(
        Integer id,
        String code,
        String pdfLink,
        String excelLink,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
