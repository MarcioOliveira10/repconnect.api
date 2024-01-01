package com.repconnect.api.applicationn.useCase;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;

import java.util.List;

public class GetAllInvoiceDataUseCase {
    private IInvoiceDataGateway iInvoiceDataGateway;

    public GetAllInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway) {
        this.iInvoiceDataGateway = iInvoiceDataGateway;
    }

    public List<InvoiceData> getAllInvoiceData() {
        return iInvoiceDataGateway.getAllInvoiceData();
    }
}
