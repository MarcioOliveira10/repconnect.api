package com.repconnect.api.applicationn.gateway;
import com.repconnect.api.core.domain.InvoiceData;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInvoiceDataGateway {
    InvoiceData createInvoiceData(InvoiceData invoiceData);

    List<InvoiceData> getAllInvoiceData();


    InvoiceData findByCode(String code);

    InvoiceData updateInvoiceData(InvoiceData invoiceData);


    void deleteByCode(String code);

    InvoiceData updateInvoiceDataById(InvoiceData invoiceData);
}
