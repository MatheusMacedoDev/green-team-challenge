package com.macedo.backend_challenge.application.contracts.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetSpecificCharacterResponseDTO(
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
