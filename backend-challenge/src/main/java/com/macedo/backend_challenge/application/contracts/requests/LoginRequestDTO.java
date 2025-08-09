package com.macedo.backend_challenge.application.contracts.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
    @NotBlank(message = "E-mail is mandatory") String email,
    @NotBlank(message = "Password is mandatory") String password
) {
}
