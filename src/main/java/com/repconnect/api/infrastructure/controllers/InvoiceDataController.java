package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.CreateInvoiceDataUseCase;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.infrastructure.dto.invoiceData.CreateInvoiceDataRequest;
import com.repconnect.api.infrastructure.dto.invoiceData.CreateInvoiceDataResponse;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataDTOMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoiceData")
public class InvoiceDataController {

    private final CreateInvoiceDataUseCase createInvoiceDataUseCase;
    private final InvoiceDataDTOMapper invoiceDataDTOMapper;

    public InvoiceDataController(CreateInvoiceDataUseCase createInvoiceDataUseCase, InvoiceDataDTOMapper invoiceDataDTOMapper) {
        this.createInvoiceDataUseCase = createInvoiceDataUseCase;
        this.invoiceDataDTOMapper = invoiceDataDTOMapper;
    }

    @PostMapping
    CreateInvoiceDataResponse create(@RequestBody CreateInvoiceDataRequest invoiceDataRequest){
        InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
        InvoiceData invoiceData = createInvoiceDataUseCase.createInvoiceData(invoiceDataBusinessObj);
        return invoiceDataDTOMapper.toResponse(invoiceData);
    }


}
