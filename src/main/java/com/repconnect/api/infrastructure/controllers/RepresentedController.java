package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.represented.CreateRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.GetAllRepresentedUseCase;
import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.infrastructure.dto.represented.RepresentedDTOMapper;
import com.repconnect.api.infrastructure.dto.represented.RepresentedRequest;
import com.repconnect.api.infrastructure.dto.represented.RepresentedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("represented")
public class RepresentedController {

    private final RepresentedDTOMapper representedDTOMapper;
    private final CreateRepresentedUseCase createRepresentedUseCase;
    private final GetAllRepresentedUseCase getAllRepresentedUseCase;


    public RepresentedController(RepresentedDTOMapper representedDTOMapper, CreateRepresentedUseCase createRepresentedUseCase, GetAllRepresentedUseCase getAllRepresentedUseCase) {
        this.representedDTOMapper = representedDTOMapper;
        this.createRepresentedUseCase = createRepresentedUseCase;
        this.getAllRepresentedUseCase = getAllRepresentedUseCase;
    }

    @PostMapping
    public ResponseEntity<RepresentedResponse> create(@RequestBody RepresentedRequest representedRequest){
            Represented representedBusinessObj = representedDTOMapper.toRepresented(representedRequest);
            Represented represented = createRepresentedUseCase.createRepresented(representedBusinessObj);
            RepresentedResponse response = representedDTOMapper.toResponse(represented);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RepresentedResponse>> getAllRepresented(){
        List<Represented> representedList = getAllRepresentedUseCase.getAllRepresented();
        List<RepresentedResponse> representedResponseList = representedList.stream()
                .map(representedDTOMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(representedResponseList);
    }


}
