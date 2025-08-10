package com.macedo.backend_challenge.application.services;

import com.macedo.backend_challenge.application.contracts.requests.CreateCharacterRequestDTO;
import com.macedo.backend_challenge.application.contracts.requests.UpdateCharacterRequestDTO;
import com.macedo.backend_challenge.application.contracts.responses.CharacterDTO;
import com.macedo.backend_challenge.application.contracts.responses.GetSpecificCharacterResponseDTO;
import com.macedo.backend_challenge.application.exceptions.CharacterNotFoundException;
import com.macedo.backend_challenge.domain.entities.Character;
import com.macedo.backend_challenge.domain.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character save(CreateCharacterRequestDTO request) {
        var character = new Character(request);
        return characterRepository.save(character);
    }

    public List<CharacterDTO> getAll() {
        return  characterRepository.findAll().stream().map(CharacterDTO::new).toList();
    }

    public GetSpecificCharacterResponseDTO getById(Integer id) {
        var character = characterRepository.getByCharacterId(id);

        if (character == null) {
            throw new CharacterNotFoundException();
        }

        return new GetSpecificCharacterResponseDTO(
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

    public CharacterDTO update(Integer id, UpdateCharacterRequestDTO request) {
        var character = characterRepository.getByCharacterId(id);

        if (character == null) {
            throw new CharacterNotFoundException();
        }

        if (request.name() != null)
            character.setName(request.name());

        if (request.className() != null)
            character.setClassName(request.className());

        if (request.level() != null)
            character.setLevel(request.level());

        if (request.hp() != null)
            character.setHp(request.hp());

        if (request.mp() != null)
            character.setMp(request.mp());

        if (request.intelligence() != null)
            character.setIntelligence(request.intelligence());

        if (request.strength() != null)
            character.setStrength(request.strength());

        if (request.dexterity() != null)
            character.setDexterity(request.dexterity());

        return new CharacterDTO(characterRepository.save(character));
    }

    public void remove(Integer id) {
        var character = characterRepository.getByCharacterId(id);

        if (character == null) {
            throw new CharacterNotFoundException();
        }

        characterRepository.deleteById(id);
    }

}
