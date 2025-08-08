package com.macedo.backend_challenge.application.controllers;

import com.macedo.backend_challenge.application.contracts.requests.CreateCharacterRequestDTO;
import com.macedo.backend_challenge.domain.entities.Character;
import com.macedo.backend_challenge.application.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<Character> saveCharacter(@RequestBody CreateCharacterRequestDTO request) {
        try {
            Character character = characterService.save(request);
            return new ResponseEntity<>(character, HttpStatusCode.valueOf(201));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping
    public Iterable<Character> getAllCharacters() {
        return characterService.getAll();
    }

}
