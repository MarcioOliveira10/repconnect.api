package com.repconnect.api.applicationn.useCase;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;

public class UpdateInvoiceDataUseCase {
    private final IInvoiceDataGateway iInvoiceDataGateway;

    public UpdateInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway) {
        this.iInvoiceDataGateway = iInvoiceDataGateway;
    }

    public InvoiceData updateInvoiceData(InvoiceData invoiceData){
        return iInvoiceDataGateway.updateInvoiceData(invoiceData);
    }
}
