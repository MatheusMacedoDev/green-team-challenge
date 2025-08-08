package com.macedo.backend_challenge.application.contracts.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record CreateCharacterRequestDTO (
    @NotBlank(message = "Name is mandatory") String name,
    @NotBlank(message = "Class name is mandatory") @JsonProperty("class") String className,
    @NotBlank(message = "Level is mandatory") Integer level,
    @NotBlank(message = "HP is mandatory") Integer hp,
    @NotBlank(message = "MP is mandatory") Integer mp,
    @NotBlank(message = "Strength is mandatory") Integer strength,
    @NotBlank(message = "Intelligence is mandatory") Integer intelligence,
    @NotBlank(message = "Dexterity is mandatory") Integer dexterity
) {
}
