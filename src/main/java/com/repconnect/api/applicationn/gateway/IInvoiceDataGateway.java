package com.repconnect.api.applicationn.gateway;
import com.repconnect.api.core.domain.InvoiceData;

public interface IInvoiceDataGateway {
    InvoiceData createInvoiceData(InvoiceData invoiceData);
}
