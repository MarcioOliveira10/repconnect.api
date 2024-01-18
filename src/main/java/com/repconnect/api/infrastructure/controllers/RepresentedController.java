package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.represented.CreateRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.DeleteRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.GetAllRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.UpdateRepresentedUseCase;
import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.infrastructure.dto.represented.RepresentedDTOMapper;
import com.repconnect.api.infrastructure.dto.represented.RepresentedRequest;
import com.repconnect.api.infrastructure.dto.represented.RepresentedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("represented")
public class RepresentedController {


    private final CreateRepresentedUseCase createRepresentedUseCase;
    private final GetAllRepresentedUseCase getAllRepresentedUseCase;

    private final UpdateRepresentedUseCase updateRepresentedUseCase;
    private final DeleteRepresentedUseCase deleteRepresentedUseCase;


    public RepresentedController(CreateRepresentedUseCase createRepresentedUseCase,
                                 GetAllRepresentedUseCase getAllRepresentedUseCase,
                                 UpdateRepresentedUseCase updateRepresentedUseCase,
                                 DeleteRepresentedUseCase deleteRepresentedUseCase) {
        this.createRepresentedUseCase = createRepresentedUseCase;
        this.getAllRepresentedUseCase = getAllRepresentedUseCase;
        this.updateRepresentedUseCase = updateRepresentedUseCase;
        this.deleteRepresentedUseCase = deleteRepresentedUseCase;
    }

    @PostMapping
    public ResponseEntity<RepresentedResponse> create(@RequestBody RepresentedRequest representedRequest){
            Represented representedBusinessObj = RepresentedDTOMapper.INSTANCE.toRepresented(representedRequest);  //representedDTOMapper.INSTANCE.toRepresented(representedRequest); //toRepresented(representedRequest);
            Represented represented = createRepresentedUseCase.createRepresented(representedBusinessObj);
            RepresentedResponse response = RepresentedDTOMapper.INSTANCE.toResponse(represented); //representedDTOMapper.toResponse(represented);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RepresentedResponse>> getAllRepresented(){
        List<Represented> representedList = getAllRepresentedUseCase.getAllRepresented();
        List<RepresentedResponse> representedResponseList = representedList.stream()
                .map(RepresentedDTOMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(representedResponseList);
    }
    @PutMapping
    public ResponseEntity<RepresentedResponse> updateRepresented(@RequestBody RepresentedRequest representedRequest){
        Represented representedBusinessObj = RepresentedDTOMapper.INSTANCE.toRepresented(representedRequest);
        Represented represented = updateRepresentedUseCase.updateRepresented(representedBusinessObj);
        RepresentedResponse response = RepresentedDTOMapper.INSTANCE.toResponse(represented);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRepresented(@PathVariable(value = "id") Integer id){
         deleteRepresentedUseCase.deleteRepresentedUseCase(id);
         return ResponseEntity.status(HttpStatus.OK).body("Represented deleted successfully.");
    }


}
