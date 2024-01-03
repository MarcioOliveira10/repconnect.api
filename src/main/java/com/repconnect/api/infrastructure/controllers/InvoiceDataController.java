package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.*;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataRequest;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataResponse;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("invoiceData")
public class InvoiceDataController {

    private final CreateInvoiceDataUseCase createInvoiceDataUseCase;
    private final InvoiceDataDTOMapper invoiceDataDTOMapper;
    private final GetAllInvoiceDataUseCase getAllInvoiceDataUseCase;
    private final FindInvoiceDataByCodeUseCase findInvoiceDataByCodeUseCase;
    private final UpdateInvoiceDataUseCase updateInvoiceDataUseCase;
    private final DeleteInvoiceDataUseCase deleteInvoiceDataUseCase;

    public InvoiceDataController(CreateInvoiceDataUseCase createInvoiceDataUseCase, InvoiceDataDTOMapper invoiceDataDTOMapper, GetAllInvoiceDataUseCase getAllInvoiceDataUseCase, FindInvoiceDataByCodeUseCase findInvoiceDataByCodeUseCase, UpdateInvoiceDataUseCase updateInvoiceDataUseCase, DeleteInvoiceDataUseCase deleteInvoiceDataUseCase) {
        this.createInvoiceDataUseCase = createInvoiceDataUseCase;
        this.invoiceDataDTOMapper = invoiceDataDTOMapper;
        this.getAllInvoiceDataUseCase = getAllInvoiceDataUseCase;
        this.findInvoiceDataByCodeUseCase = findInvoiceDataByCodeUseCase;
        this.updateInvoiceDataUseCase = updateInvoiceDataUseCase;
        this.deleteInvoiceDataUseCase = deleteInvoiceDataUseCase;
    }

    @PostMapping
    public InvoiceDataResponse create(@RequestBody InvoiceDataRequest invoiceDataRequest){
        InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
        InvoiceData invoiceData = createInvoiceDataUseCase.createInvoiceData(invoiceDataBusinessObj);
        return invoiceDataDTOMapper.toResponse(invoiceData);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDataResponse>> getAllInvoiceData(){
        List<InvoiceData> invoiceDataList = getAllInvoiceDataUseCase.getAllInvoiceData();
        List<InvoiceDataResponse> invoiceDataResponseList = invoiceDataList.stream()
                .map(invoiceDataDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(invoiceDataResponseList);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Object> getInvoiceDataByCode(@PathVariable String code){
            InvoiceData invoiceData = findInvoiceDataByCodeUseCase.findByCode(code);
            InvoiceDataResponse invoiceDataResponse = invoiceDataDTOMapper.toResponse(invoiceData);
            return new ResponseEntity<>(invoiceDataResponse,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<InvoiceDataResponse> updateInvoiceData(@RequestBody InvoiceDataRequest invoiceDataRequest){
        InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
        InvoiceData invoiceData = updateInvoiceDataUseCase.updateInvoiceData(invoiceDataBusinessObj);
        InvoiceDataResponse invoiceDataResponse = invoiceDataDTOMapper.toResponse(invoiceData);
        return new ResponseEntity<>(invoiceDataResponse,HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteInvoiceData(@PathVariable String code){
        deleteInvoiceDataUseCase.deleteInvoiceData(code);
        return ResponseEntity.status(HttpStatus.OK).body("InvoiceData deleted successfully.");
    }

}
