package com.macedo.backend_challenge.application.services;

import com.macedo.backend_challenge.application.contracts.requests.CreateCharacterRequestDTO;
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
        Character character = new Character(request);
        return characterRepository.save(character);
    }

    public List<Character> getAll() {
        return  characterRepository.findAll();
    }

    public Character getById(Integer id) {
        return characterRepository.getCharacterById(id);
    }

    public Character update(Character character) {
        return characterRepository.save(character);
    }

    public void remove(Integer id) {
        characterRepository.deleteById(id);
    }

}
