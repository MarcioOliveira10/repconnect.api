package com.repconnect.api.applicationn.useCase;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;

public class DeleteInvoiceDataUseCase {

    private final IInvoiceDataGateway iInvoiceDataGateway;

    public DeleteInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway) {
        this.iInvoiceDataGateway = iInvoiceDataGateway;
    }

    public void deleteInvoiceData(String code){
         iInvoiceDataGateway.deleteByCode(code);
    }
}
