package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.CreateAddressUseCase;
import com.repconnect.api.core.domain.Address;
import com.repconnect.api.infrastructure.dto.address.AddressDTOMapper;
import com.repconnect.api.infrastructure.dto.address.CreateAddressRequest;
import com.repconnect.api.infrastructure.dto.address.CreateAddressResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {
    private final CreateAddressUseCase createAddressUseCase;
    private final AddressDTOMapper addressDTOMapper;


    public AddressController(CreateAddressUseCase createAddressUseCase, AddressDTOMapper addressDTOMapper) {
        this.createAddressUseCase = createAddressUseCase;
        this.addressDTOMapper = addressDTOMapper;
    }

    @PostMapping
    CreateAddressResponse create(@Valid @RequestBody  CreateAddressRequest addressRequest){
        Address addressObj = addressDTOMapper.toAddress(addressRequest);
        Address address = createAddressUseCase.createAddress(addressObj);
        return addressDTOMapper.toResponse(address);
    }
}