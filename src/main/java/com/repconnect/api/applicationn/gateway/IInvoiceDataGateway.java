package com.repconnect.api.applicationn.gateway;
import com.repconnect.api.core.domain.InvoiceData;

import java.util.List;

public interface IInvoiceDataGateway {
    InvoiceData createInvoiceData(InvoiceData invoiceData);

    List<InvoiceData> getAllInvoiceData();


    InvoiceData findByCode(String code);
}
