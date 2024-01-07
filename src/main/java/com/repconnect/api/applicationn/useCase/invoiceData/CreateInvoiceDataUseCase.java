package com.repconnect.api.applicationn.useCase.invoiceData;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;

public class CreateInvoiceDataUseCase {
    private IInvoiceDataGateway IInvoiceDataGateway;

    public CreateInvoiceDataUseCase(IInvoiceDataGateway IInvoiceDataGateway) {
        this.IInvoiceDataGateway = IInvoiceDataGateway;
    }

    public InvoiceData createInvoiceData(InvoiceData invoiceData) {
        return IInvoiceDataGateway.createInvoiceData(invoiceData);
    }
}
