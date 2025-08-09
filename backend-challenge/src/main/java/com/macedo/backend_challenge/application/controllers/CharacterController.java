package com.macedo.backend_challenge.application.controllers;

import com.macedo.backend_challenge.application.contracts.requests.CreateCharacterRequestDTO;
import com.macedo.backend_challenge.application.contracts.requests.UpdateCharacterRequestDTO;
import com.macedo.backend_challenge.application.contracts.responses.GetCharacterResponseDTO;
import com.macedo.backend_challenge.application.exceptions.CharacterNotFoundException;
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
            var character = characterService.save(request);
            return new ResponseEntity<>(character, HttpStatusCode.valueOf(201));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping
    public Iterable<Character> getAllCharacters() {
        return characterService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCharacterResponseDTO>  getCharacterById(@PathVariable Integer id) {
        try {
            var response = characterService.getById(id);
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
        } catch (CharacterNotFoundException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Integer id, @RequestBody UpdateCharacterRequestDTO request) {
        try {
            var response = characterService.update(id, request);
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
        } catch (CharacterNotFoundException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        try {
            characterService.remove(id);

            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
        } catch (CharacterNotFoundException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

}
