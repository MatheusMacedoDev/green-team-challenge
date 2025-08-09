package com.macedo.backend_challenge.application.controllers;

import com.macedo.backend_challenge.application.contracts.requests.CreateGameMasterRequestDTO;
import com.macedo.backend_challenge.application.exceptions.CharacterNotFoundException;
import com.macedo.backend_challenge.application.services.GameMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private GameMasterService gameMasterService;

    @PostMapping
    public ResponseEntity<Void> saveGameMaster(@RequestBody CreateGameMasterRequestDTO request) {
        try {
            gameMasterService.save(request);
            return new ResponseEntity<>(HttpStatusCode.valueOf(201));
        } catch (CharacterNotFoundException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

}
