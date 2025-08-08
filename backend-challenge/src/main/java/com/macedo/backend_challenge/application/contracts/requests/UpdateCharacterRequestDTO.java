package com.macedo.backend_challenge.application.contracts.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UpdateCharacterRequestDTO(
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
