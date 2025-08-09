package com.macedo.backend_challenge.application.contracts.requests;

import jakarta.validation.constraints.NotBlank;

public record CreateGameMasterRequestDTO(
    @NotBlank(message = "E-mail is mandatory") String email,
    @NotBlank(message = "Password is mandatory") String passwordText,
    @NotBlank(message = "Character is mandatory") Integer characterId
) {
}
