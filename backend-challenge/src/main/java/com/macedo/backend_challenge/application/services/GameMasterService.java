package com.macedo.backend_challenge.application.services;

import com.macedo.backend_challenge.application.contracts.requests.CreateGameMasterRequestDTO;
import com.macedo.backend_challenge.application.contracts.requests.LoginRequestDTO;
import com.macedo.backend_challenge.application.exceptions.CharacterNotFoundException;
import com.macedo.backend_challenge.application.exceptions.InvalidLoginException;
import com.macedo.backend_challenge.domain.entities.GameMaster;
import com.macedo.backend_challenge.domain.repositories.CharacterRepository;
import com.macedo.backend_challenge.domain.repositories.GameMasterRepository;
import com.macedo.backend_challenge.infra.security.authentication.TokenStrategy;
import com.macedo.backend_challenge.infra.security.cryptography.CryptographyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameMasterService {

    @Autowired
    private GameMasterRepository gameMasterRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CryptographyStrategy cryptographyStrategy;

    @Autowired
    private TokenStrategy tokenStrategy;

    public void save(CreateGameMasterRequestDTO request) {
        var character = characterRepository.getByCharacterId(request.characterId());

        if (character == null)
            throw new CharacterNotFoundException();

        byte[] passwordSalt = cryptographyStrategy.generateSalt();
        byte[] passwordHash = cryptographyStrategy.hashPassword(request.passwordText(), passwordSalt);

        var gameMaster = new GameMaster(request, passwordHash, passwordSalt, character);

        gameMasterRepository.save(gameMaster);
    }

    public String login(LoginRequestDTO request) {
        var gameMaster = gameMasterRepository.getByEmail(request.email());

        if (gameMaster == null || !cryptographyStrategy.passwordMatches(
            request.password(),
            gameMaster.getPasswordSalt(),
            gameMaster.getPasswordHash()
        )) {
            throw new InvalidLoginException();
        }

        return tokenStrategy.generateToken(gameMaster);
    }

}
