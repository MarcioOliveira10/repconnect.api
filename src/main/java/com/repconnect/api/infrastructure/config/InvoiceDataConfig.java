package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.applicationn.useCase.invoiceData.*;
import com.repconnect.api.infrastructure.dto.invoiceData.InvoiceDataDTOMapper;
import com.repconnect.api.infrastructure.gatewayImpl.InvoiceDataRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.InvoiceDataEntityMapper;
import com.repconnect.api.infrastructure.repository.IInvoiceDataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvoiceDataConfig {
    @Bean
    UpdateInvoiceDataByIdUseCase updateInvoiceDataByIdUseCase(IInvoiceDataGateway iInvoiceDataGateway){
        return new UpdateInvoiceDataByIdUseCase(iInvoiceDataGateway);
    }
    @Bean
    DeleteInvoiceDataUseCase deleteInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway){
        return new DeleteInvoiceDataUseCase(iInvoiceDataGateway);
    }

    @Bean
    UpdateInvoiceDataUseCase updateInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway){
        return new UpdateInvoiceDataUseCase(iInvoiceDataGateway);
    }
    @Bean
    FindInvoiceDataByCodeUseCase findInvoiceDataByCode(IInvoiceDataGateway iInvoiceDataGateway){
        return new FindInvoiceDataByCodeUseCase(iInvoiceDataGateway);
    }
    @Bean
    GetAllInvoiceDataUseCase getAllInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway){
        return new GetAllInvoiceDataUseCase(iInvoiceDataGateway);
    }
    @Bean
    CreateInvoiceDataUseCase createInvoiceDataUseCase(IInvoiceDataGateway iInvoiceDataGateway){
        return new CreateInvoiceDataUseCase(iInvoiceDataGateway);
    }
    @Bean
    IInvoiceDataGateway invoiceDataGateway(IInvoiceDataRepository iInvoiceDataRepository, InvoiceDataEntityMapper invoiceDataEntityMapper){
        return new InvoiceDataRepositoryGateway(iInvoiceDataRepository, invoiceDataEntityMapper);
    }
    @Bean
    InvoiceDataEntityMapper invoiceDataEntityMapper(){
        return new InvoiceDataEntityMapper();
    }
    @Bean
    InvoiceDataDTOMapper invoiceDataDTOMapper(){return new InvoiceDataDTOMapper();}
}
