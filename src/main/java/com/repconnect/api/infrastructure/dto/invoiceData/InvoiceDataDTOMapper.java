package com.repconnect.api.infrastructure.dto.invoiceData;

import com.repconnect.api.core.domain.InvoiceData;


public class InvoiceDataDTOMapper {

    public InvoiceDataResponse toResponse(InvoiceData invoiceData){ //pega uma obejeto de dominio e converte em uma resposta.
        return  new InvoiceDataResponse(
                invoiceData.id(),
                invoiceData.code(),
                invoiceData.pdfLink(),
                invoiceData.excelLink(),
                invoiceData.createdAt(),
                invoiceData.updatedAt());
    }

    public InvoiceData toInvoiceData(InvoiceDataRequest request){ // pega uma request e converte em um objeto de dominio.
        return new InvoiceData(
                request.id(),
                request.code(),
                request.pdfLink(),
                request.excelLink(),
                request.createdAt(),
                request.updatedAt());
    }
}
