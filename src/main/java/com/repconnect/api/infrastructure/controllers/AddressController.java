package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.CreateAddressUseCase;
import com.repconnect.api.applicationn.useCase.GetAllAddressesUseCase;
import com.repconnect.api.core.domain.Address;
import com.repconnect.api.infrastructure.dto.address.AddressDTOMapper;
import com.repconnect.api.infrastructure.dto.address.CreateAddressRequest;
import com.repconnect.api.infrastructure.dto.address.CreateAddressResponse;
import com.repconnect.api.infrastructure.gatewayImpl.AddressRepositoryGateway;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("address")
public class AddressController {
    private final CreateAddressUseCase createAddressUseCase;
    private final AddressRepositoryGateway addressRepositoryGateway;
    private final AddressDTOMapper addressDTOMapper;
    private final GetAllAddressesUseCase getAllAddressesUseCase;


    public AddressController(CreateAddressUseCase createAddressUseCase, AddressRepositoryGateway addressRepositoryGateway, AddressDTOMapper addressDTOMapper, GetAllAddressesUseCase getAllAddressesUseCase) {
        this.createAddressUseCase = createAddressUseCase;
        this.addressRepositoryGateway = addressRepositoryGateway;
        this.addressDTOMapper = addressDTOMapper;
        this.getAllAddressesUseCase = getAllAddressesUseCase;
    }

    @PostMapping
    public CreateAddressResponse create(@Valid @RequestBody CreateAddressRequest addressRequest) {
        Address addressObj = addressDTOMapper.toAddress(addressRequest);
        Address address = createAddressUseCase.createAddress(addressObj);
        return addressDTOMapper.toResponse(address);
    }

    @GetMapping
    public ResponseEntity<List<CreateAddressResponse>> getAllAddresses() {
        List<Address> addresses = getAllAddressesUseCase.getAllAddresses();
        List<CreateAddressResponse> addressResponseList = addresses.stream()
                .map(addressDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(addressResponseList);
    }

}
