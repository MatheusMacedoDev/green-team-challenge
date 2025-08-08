package com.macedo.backend_challenge.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.macedo.backend_challenge.application.contracts.requests.CreateCharacterRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "game_character")
@Getter
@Setter
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String className;

    private Integer level;

    private Integer hp;

    private Integer mp;

    private Integer strength;

    private Integer intelligence;

    private Integer dexterity;

    public Character(CreateCharacterRequestDTO request) {
        this.name = request.name();
        this.className = request.className();
        this.level = request.level();
        this.hp = request.hp();
        this.mp = request.mp();
        this.strength = request.strength();
        this.intelligence = request.intelligence();
        this.dexterity = request.dexterity();
    }

}