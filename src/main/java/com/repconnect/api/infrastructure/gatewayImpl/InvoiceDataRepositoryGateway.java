package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.core.domain.InvoiceData;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.core.exception.EntityNotFoundExceptions;
import com.repconnect.api.infrastructure.entity.InvoiceDataEntity;
import com.repconnect.api.infrastructure.mapper.InvoiceDataEntityMapper;
import com.repconnect.api.infrastructure.repository.IInvoiceDataRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceDataRepositoryGateway implements IInvoiceDataGateway {
    private final IInvoiceDataRepository invoiceDataRepository;
    private final InvoiceDataEntityMapper invoiceDataEntityMapper;

    public InvoiceDataRepositoryGateway(IInvoiceDataRepository IInvoiceDataRepository, InvoiceDataEntityMapper invoiceDataEntityMapper) {
        this.invoiceDataRepository = IInvoiceDataRepository;
        this.invoiceDataEntityMapper = invoiceDataEntityMapper;
    }

    @Override
    public InvoiceData createInvoiceData(InvoiceData invoiceDomainObj) {
        InvoiceDataEntity invoiceDataEntity = invoiceDataEntityMapper.toEntity(invoiceDomainObj);
        if (invoiceDataEntity.getCode() != null && invoiceDataRepository.findByCode(invoiceDataEntity.getCode()).isPresent()) {
            throw new EntityAlreadyExistsException("An entity with this code already exists:" + invoiceDataEntity.getCode());
        }
        InvoiceDataEntity savedObj = invoiceDataRepository.save(invoiceDataEntity);
        return invoiceDataEntityMapper.toInvoiceData(savedObj);
    }

    @Override
    public List<InvoiceData> getAllInvoiceData() {
        List<InvoiceDataEntity> invoiceDataEntityList = invoiceDataRepository.findAll();
        return invoiceDataEntityList.stream()
                .map(invoiceDataEntityMapper::toInvoiceData)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceData findByCode(String code) {
        Optional<InvoiceDataEntity> invoiceDataEntityOp = invoiceDataRepository.findByCode(code);
        if (invoiceDataEntityOp.isPresent()) {
            InvoiceData invoiceData = invoiceDataEntityMapper.toInvoiceData(invoiceDataEntityOp.get());
            return invoiceData;
        } else {
            throw new EntityNotFoundExceptions("Entidade não encontrada"  );
        }
    }

    @Override
    public InvoiceData updateInvoiceData(InvoiceData invoiceData) { // Atualiza pelo "code".
        Optional<InvoiceDataEntity> invoiceDataEntityOp = invoiceDataRepository.findByCode(invoiceData.code());
        if(invoiceDataEntityOp.isPresent()){
            InvoiceDataEntity existingInvoiceDataEntity = invoiceDataEntityOp.get();
            existingInvoiceDataEntity.setCode(invoiceData.code());
            existingInvoiceDataEntity.setPdfLink(invoiceData.pdfLink());
            existingInvoiceDataEntity.setExcelLink(invoiceData.excelLink());
            InvoiceDataEntity updateInvoiceDataEntity = invoiceDataRepository.save(existingInvoiceDataEntity);
            return invoiceDataEntityMapper.toInvoiceData(updateInvoiceDataEntity);
        }else {
            throw new EntityNotFoundExceptions("Entidade não encontrada");
        }
    }

    @Override
    public InvoiceData updateInvoiceDataById(InvoiceData invoiceData) {// Atualiza pelo "id".
        try{
            Optional <InvoiceDataEntity> invoiceDataEntityOp = invoiceDataRepository.findById(invoiceData.id());
            if (invoiceDataEntityOp.isPresent()){
                InvoiceDataEntity existingInvoiceDataEntity = invoiceDataEntityOp.get();
                existingInvoiceDataEntity.setId(invoiceData.id());
                existingInvoiceDataEntity.setCode(invoiceData.code());
                existingInvoiceDataEntity.setPdfLink(invoiceData.pdfLink());
                existingInvoiceDataEntity.setExcelLink(invoiceData.excelLink());

                InvoiceDataEntity updateInvoiceDataEntity = invoiceDataRepository.save(existingInvoiceDataEntity);
                return invoiceDataEntityMapper.toInvoiceData(updateInvoiceDataEntity);
            }else {
                throw new EntityNotFoundExceptions("Entidade: " + invoiceData.id() + "não encontrada");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException("The given ID must not be null");
        }
    }

    @Override
    public void deleteByCode(String code) {
        Optional<InvoiceDataEntity> invoiceDataEntityOp = invoiceDataRepository.findByCode(code);
        if (invoiceDataEntityOp.isPresent()){
            invoiceDataRepository.deleteByCode(code);
        }else {
            throw new EntityNotFoundExceptions("Não existe entidade com o codigo: " + code);
        }

    }




}
