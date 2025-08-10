package com.macedo.backend_challenge.application.contracts.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.macedo.backend_challenge.domain.entities.Character;

public record CharacterDTO(
    Integer id,
    String name,
    @JsonProperty("class") String className,
    Integer level,
    Integer hp,
    Integer mp,
    Integer strength,
    Integer intelligence,
    Integer dexterity
) {
    public CharacterDTO(Character character) {
        this(
            character.getCharacterId(),
            character.getName(),
            character.getClassName(),
            character.getLevel(),
            character.getHp(),
            character.getMp(),
            character.getStrength(),
            character.getIntelligence(),
            character.getDexterity()
        );
    }
}
