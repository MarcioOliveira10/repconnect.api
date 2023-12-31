package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.CreatePhoneUseCase;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.infrastructure.dto.phone.CreatePhoneRequest;
import com.repconnect.api.infrastructure.dto.phone.CreatePhoneResponse;
import com.repconnect.api.infrastructure.dto.phone.PhoneDTOMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phone")
public class PhoneController {

    private final CreatePhoneUseCase createPhoneUseCase;

    private final PhoneDTOMapper phoneDTOMapper;

    public PhoneController(CreatePhoneUseCase createPhoneUseCase, PhoneDTOMapper phoneDTOMapper) {
        this.createPhoneUseCase = createPhoneUseCase;
        this.phoneDTOMapper = phoneDTOMapper;
    }

    @PostMapping
    CreatePhoneResponse create(@RequestBody CreatePhoneRequest request) {
        Phone phone = phoneDTOMapper.toPhone(request);
        Phone phoneSaved = createPhoneUseCase.createPhone(phone);
        return phoneDTOMapper.toResponse(phoneSaved);

    }
}
