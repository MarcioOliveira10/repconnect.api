package com.repconnect.api.infrastructure.dto.address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CreateAddressRequest(
        Integer id,
        @NotBlank(message = "O nome da rua é obrigatório.")
        String street,
        @NotBlank(message = "O número é obrigatório, adicionar S/N caso não houver número.")
        String number,
        String city,
        String zipCode,
        String complement,
        LocalDateTime createAt,
        LocalDateTime updatedAt) {
}
