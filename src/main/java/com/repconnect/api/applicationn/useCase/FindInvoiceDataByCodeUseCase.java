package com.repconnect.api.applicationn.useCase;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;

public class FindInvoiceDataByCodeUseCase {

    private IInvoiceDataGateway iInvoiceDataGateway;

    public FindInvoiceDataByCodeUseCase(IInvoiceDataGateway iInvoiceDataGateway) {
        this.iInvoiceDataGateway = iInvoiceDataGateway;
    }

    public InvoiceData findByCode(String code){
        return iInvoiceDataGateway.findByCode(code);
    }
}
