package com.repconnect.api.infrastructure.dto.invoiceData;

import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.infrastructure.dto.invoiceData.CreateInvoiceDataRequest;
import com.repconnect.api.infrastructure.dto.invoiceData.CreateInvoiceDataResponse;


public class InvoiceDataDTOMapper {

    public CreateInvoiceDataResponse toResponse(InvoiceData invoiceData){ //pega uma obejeto de dominio e converte em uma resposta.
        return  new CreateInvoiceDataResponse(
                invoiceData.code(),
                invoiceData.pdfLink(),
                invoiceData.excelLink(),
                invoiceData.createdAt(),
                invoiceData.updatedAt());
    }

    public InvoiceData toInvoiceData(CreateInvoiceDataRequest request){ // pega uma request e converte em um objeto de dominio.
        return new InvoiceData(
                request.id(),
                request.code(),
                request.pdfLink(),
                request.excelLink(),
                request.createdAt(),
                request.updatedAt());
    }
}
