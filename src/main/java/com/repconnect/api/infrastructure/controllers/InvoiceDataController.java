package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.CreateInvoiceDataUseCase;
import com.repconnect.api.applicationn.useCase.FindInvoiceDataByCode;
import com.repconnect.api.applicationn.useCase.GetAllInvoiceDataUseCase;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.exception.EntityNotFoundExceptions;
import com.repconnect.api.infrastructure.dto.invoiceData.CreateInvoiceDataRequest;
import com.repconnect.api.infrastructure.dto.invoiceData.CreateInvoiceDataResponse;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataDTOMapper;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("invoiceData")
public class InvoiceDataController {

    private final CreateInvoiceDataUseCase createInvoiceDataUseCase;
    private final InvoiceDataDTOMapper invoiceDataDTOMapper;
    private final GetAllInvoiceDataUseCase getAllInvoiceDataUseCase;
    private final FindInvoiceDataByCode findInvoiceDataByCode;

    public InvoiceDataController(CreateInvoiceDataUseCase createInvoiceDataUseCase, InvoiceDataDTOMapper invoiceDataDTOMapper, GetAllInvoiceDataUseCase getAllInvoiceDataUseCase, FindInvoiceDataByCode findInvoiceDataByCode) {
        this.createInvoiceDataUseCase = createInvoiceDataUseCase;
        this.invoiceDataDTOMapper = invoiceDataDTOMapper;
        this.getAllInvoiceDataUseCase = getAllInvoiceDataUseCase;
        this.findInvoiceDataByCode = findInvoiceDataByCode;
    }

    @PostMapping
    public CreateInvoiceDataResponse create(@RequestBody CreateInvoiceDataRequest invoiceDataRequest){
        InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
        InvoiceData invoiceData = createInvoiceDataUseCase.createInvoiceData(invoiceDataBusinessObj);
        return invoiceDataDTOMapper.toResponse(invoiceData);
    }

    @GetMapping
    public ResponseEntity<List<CreateInvoiceDataResponse>> getAllInvoiceData(){
        List<InvoiceData> invoiceDataList = getAllInvoiceDataUseCase.getAllInvoiceData();
        List<CreateInvoiceDataResponse> invoiceDataResponseList = invoiceDataList.stream()
                .map(invoiceDataDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(invoiceDataResponseList);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Object> getInvoiceDataByCode(@PathVariable String code){
            InvoiceData invoiceData = findInvoiceDataByCode.findByCode(code);
            CreateInvoiceDataResponse invoiceDataResponse = invoiceDataDTOMapper.toResponse(invoiceData);
            return new ResponseEntity<>(invoiceDataResponse,HttpStatus.OK);

    }







}
