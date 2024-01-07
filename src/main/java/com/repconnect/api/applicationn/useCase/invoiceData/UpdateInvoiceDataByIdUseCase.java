package com.repconnect.api.applicationn.useCase.invoiceData;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;

public class UpdateInvoiceDataByIdUseCase {

    private final IInvoiceDataGateway iInvoiceDataGateway;

    public UpdateInvoiceDataByIdUseCase(IInvoiceDataGateway iInvoiceDataGateway) {
        this.iInvoiceDataGateway = iInvoiceDataGateway;
    }

    public InvoiceData updateInvoiceDataById(InvoiceData invoiceData){
        return iInvoiceDataGateway.updateInvoiceDataById(invoiceData);
    }
}
