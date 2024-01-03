package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.CreatePhoneUseCase;
import com.repconnect.api.applicationn.useCase.GetAllPhonesUseCase;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.infrastructure.dto.phone.PhoneRequest;
import com.repconnect.api.infrastructure.dto.phone.PhoneResponse;
import com.repconnect.api.infrastructure.dto.phone.PhoneDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("phone")
public class PhoneController {

    private final CreatePhoneUseCase createPhoneUseCase;
    private final PhoneDTOMapper phoneDTOMapper;
    private final GetAllPhonesUseCase getAllPhonesUseCase;

    public PhoneController(CreatePhoneUseCase createPhoneUseCase, PhoneDTOMapper phoneDTOMapper, GetAllPhonesUseCase getAllPhonesUseCase) {
        this.createPhoneUseCase = createPhoneUseCase;
        this.phoneDTOMapper = phoneDTOMapper;
        this.getAllPhonesUseCase = getAllPhonesUseCase;
    }

    @PostMapping
    public PhoneResponse create(@RequestBody PhoneRequest request) {
        Phone phone = phoneDTOMapper.toPhone(request);
        Phone phoneSaved = createPhoneUseCase.createPhone(phone);
        return phoneDTOMapper.toResponse(phoneSaved);
    }

    @GetMapping
    public ResponseEntity<List<PhoneResponse>> getAllPhones(){
        List<Phone> phoneList = getAllPhonesUseCase.getAllPhones();
        List<PhoneResponse> phoneResponseList = phoneList.stream()
                .map(phoneDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(phoneResponseList);
    }
}
