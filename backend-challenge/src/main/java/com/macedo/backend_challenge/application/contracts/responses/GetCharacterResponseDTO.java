package com.macedo.backend_challenge.application.contracts.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record GetCharacterResponseDTO(
    String name,
    @JsonProperty("class") String className,
    Integer level,
    Integer hp,
    Integer mp,
    Integer strength,
    Integer intelligence,
    Integer dexterity
) {
}
