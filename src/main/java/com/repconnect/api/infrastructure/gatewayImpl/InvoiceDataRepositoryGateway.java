package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import com.repconnect.api.infrastructure.mapper.InvoiceDataEntityMapper;
import com.repconnect.api.infrastructure.repository.IInvoiceDataRepository;

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
        InvoiceDataEntity savedObj = invoiceDataRepository.save(invoiceDataEntity);

        return invoiceDataEntityMapper.toDomainObj(savedObj);
    }
}
