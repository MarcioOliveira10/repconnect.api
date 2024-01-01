package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import com.repconnect.api.infrastructure.mapper.InvoiceDataEntityMapper;
import com.repconnect.api.infrastructure.repository.IInvoiceDataRepository;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceDataRepositoryGateway implements IInvoiceDataGateway {
    private final IInvoiceDataRepository invoiceDataRepository;
    private final InvoiceDataEntityMapper invoiceDataEntityMapper;

    public InvoiceDataRepositoryGateway(IInvoiceDataRepository IInvoiceDataRepository, InvoiceDataEntityMapper invoiceDataEntityMapper) {
        this.invoiceDataRepository = IInvoiceDataRepository;
        this.invoiceDataEntityMapper = invoiceDataEntityMapper;
    }

    @Override
    public InvoiceData createInvoiceData(InvoiceData invoiceDomainObj) {
        InvoiceDataEntity invoiceDataEntity = invoiceDataEntityMapper.toEntity(invoiceDomainObj);
        if (invoiceDataEntity.getCode() != null && invoiceDataRepository.findByCode(invoiceDataEntity.getCode()).isPresent()){
            throw new EntityAlreadyExistsException("An entity with this code already exists:" + invoiceDataEntity.getCode());
        }
        InvoiceDataEntity savedObj = invoiceDataRepository.save(invoiceDataEntity);
        return invoiceDataEntityMapper.toInvoiceData(savedObj);
    }

    @Override
    public List<InvoiceData> getAllInvoiceData() {
        List<InvoiceDataEntity> invoiceDataEntityList = invoiceDataRepository.findAll();
        return invoiceDataEntityList.stream()
                .map(invoiceDataEntityMapper::toInvoiceData)
                .collect(Collectors.toList());
    }
}
