package com.macedo.backend_challenge.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.macedo.backend_challenge.application.contracts.requests.CreateCharacterRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "game_character")
@Getter
@Setter
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer characterId;

    private String name;

    private String className;

    private Integer level;

    private Integer hp;

    private Integer mp;

    private Integer strength;

    private Integer intelligence;

    private Integer dexterity;

    @OneToMany(mappedBy = "gameMasterId")
    private List<GameMaster> gameMasters;

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