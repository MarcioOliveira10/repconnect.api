package com.repconnect.api.infrastructure.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name="invoice_data")
public class InvoiceDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String pdfLink;
    private String excelLink;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InvoiceDataEntity(Integer id,String code, String pdfLink, String excelLink, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code= code;
        this.pdfLink = pdfLink;
        this.excelLink = excelLink;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public InvoiceDataEntity(String code, String pdfLink, String excelLink, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.code = code;
        this.pdfLink = pdfLink;
        this.excelLink = excelLink;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public InvoiceDataEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public String getExcelLink() {
        return excelLink;
    }

    public void setExcelLink(String excelLink) {
        this.excelLink = excelLink;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "InvoiceDataEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", pdfLink='" + pdfLink + '\'' +
                ", excelLink='" + excelLink + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceDataEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCode(), that.getCode()) && Objects.equals(getPdfLink(), that.getPdfLink()) && Objects.equals(getExcelLink(), that.getExcelLink()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getPdfLink(), getExcelLink(), getCreatedAt(), getUpdatedAt());
    }
}
