package com.macedo.backend_challenge.domain.entities;

import com.macedo.backend_challenge.application.contracts.requests.CreateGameMasterRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameMasterId;

    private String email;

    private byte[] passwordHash;
    private byte[] passwordSalt;

    @ManyToOne
    @JoinColumn(name = "characterId")
    private Character character;

    public GameMaster(CreateGameMasterRequestDTO request, byte[] passwordHash, byte[] passwordSalt, Character character) {
        this.email = request.email();
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.character = character;
    }

}
