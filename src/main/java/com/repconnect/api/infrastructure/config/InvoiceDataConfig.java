package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.applicationn.useCase.CreateInvoiceDataUseCase;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataDTOMapper;
import com.repconnect.api.infrastructure.gatewayImpl.InvoiceDataRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.InvoiceDataEntityMapper;
import com.repconnect.api.infrastructure.repository.IInvoiceDataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvoiceDataConfig {
    @Bean
    CreateInvoiceDataUseCase createInvoiceDataUseCase(IInvoiceDataGateway IInvoiceDataGateway){
        return new CreateInvoiceDataUseCase(IInvoiceDataGateway);
    }
    @Bean
    IInvoiceDataGateway invoiceDataGateway(IInvoiceDataRepository IInvoiceDataRepository, InvoiceDataEntityMapper invoiceDataEntityMapper){
        return new InvoiceDataRepositoryGateway(IInvoiceDataRepository, invoiceDataEntityMapper);
    }
    @Bean
    InvoiceDataEntityMapper invoiceDataEntityMapper(){
        return new InvoiceDataEntityMapper();
    }
    @Bean
    InvoiceDataDTOMapper invoiceDataDTOMapper(){return new InvoiceDataDTOMapper();}
}
