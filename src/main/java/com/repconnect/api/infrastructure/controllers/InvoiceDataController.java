package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.invoiceData.*;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataRequest;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataResponse;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataDTOMapper;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import com.repconnect.api.infrastructure.repository.IInvoiceDataRepository;
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
    private final FindInvoiceDataByCodeUseCase findInvoiceDataByCodeUseCase;
    private final UpdateInvoiceDataUseCase updateInvoiceDataUseCase;
    private final DeleteInvoiceDataUseCase deleteInvoiceDataUseCase;
    private final IInvoiceDataRepository iInvoiceDataRepository;
    private final UpdateInvoiceDataByIdUseCase updateInvoiceDataByIdUseCase;

    public InvoiceDataController(CreateInvoiceDataUseCase createInvoiceDataUseCase, InvoiceDataDTOMapper invoiceDataDTOMapper, GetAllInvoiceDataUseCase getAllInvoiceDataUseCase, FindInvoiceDataByCodeUseCase findInvoiceDataByCodeUseCase, UpdateInvoiceDataUseCase updateInvoiceDataUseCase, DeleteInvoiceDataUseCase deleteInvoiceDataUseCase, IInvoiceDataRepository iInvoiceDataRepository, UpdateInvoiceDataByIdUseCase updateInvoiceDataByIdUseCase) {
        this.createInvoiceDataUseCase = createInvoiceDataUseCase;
        this.invoiceDataDTOMapper = invoiceDataDTOMapper;
        this.getAllInvoiceDataUseCase = getAllInvoiceDataUseCase;
        this.findInvoiceDataByCodeUseCase = findInvoiceDataByCodeUseCase;
        this.updateInvoiceDataUseCase = updateInvoiceDataUseCase;
        this.deleteInvoiceDataUseCase = deleteInvoiceDataUseCase;
        this.iInvoiceDataRepository = iInvoiceDataRepository;
        this.updateInvoiceDataByIdUseCase = updateInvoiceDataByIdUseCase;
    }

    @PostMapping
    public InvoiceDataResponse create(@RequestBody InvoiceDataRequest invoiceDataRequest) {
        InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
        InvoiceData invoiceData = createInvoiceDataUseCase.createInvoiceData(invoiceDataBusinessObj);
        return invoiceDataDTOMapper.toResponse(invoiceData);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDataResponse>> getAllInvoiceData() {
        List<InvoiceData> invoiceDataList = getAllInvoiceDataUseCase.getAllInvoiceData();
        List<InvoiceDataResponse> invoiceDataResponseList = invoiceDataList.stream()
                .map(invoiceDataDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(invoiceDataResponseList);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Object> getInvoiceDataByCode(@PathVariable String code) {
        InvoiceData invoiceData = findInvoiceDataByCodeUseCase.findByCode(code);
        InvoiceDataResponse invoiceDataResponse = invoiceDataDTOMapper.toResponse(invoiceData);
        return new ResponseEntity<>(invoiceDataResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<InvoiceDataResponse> updateInvoiceData(@RequestBody InvoiceDataRequest invoiceDataRequest) {
        InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
        InvoiceData invoiceData = updateInvoiceDataUseCase.updateInvoiceData(invoiceDataBusinessObj);
        InvoiceDataResponse invoiceDataResponse = invoiceDataDTOMapper.toResponse(invoiceData);
        return new ResponseEntity<>(invoiceDataResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInvoiceDataById(@PathVariable Integer id,
                                                        @RequestBody InvoiceDataRequest invoiceDataRequest) {
        Optional<InvoiceDataEntity> invoiceDataEntityIsPresent = iInvoiceDataRepository.findById(id);
        if (invoiceDataEntityIsPresent.isPresent()) {
            InvoiceData invoiceDataBusinessObj = invoiceDataDTOMapper.toInvoiceData(invoiceDataRequest);
            InvoiceData invoiceData = updateInvoiceDataByIdUseCase.updateInvoiceDataById(invoiceDataBusinessObj);
            InvoiceDataResponse invoiceDataResponse = invoiceDataDTOMapper.toResponse(invoiceData);
            return new ResponseEntity<>(invoiceDataResponse, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID: " + id + ", invoiceData not found");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteInvoiceData(@PathVariable String code) {
        deleteInvoiceDataUseCase.deleteInvoiceData(code);
        return ResponseEntity.status(HttpStatus.OK).body("InvoiceData deleted successfully.");
    }

}
