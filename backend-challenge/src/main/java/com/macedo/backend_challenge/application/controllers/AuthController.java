package com.macedo.backend_challenge.application.controllers;

import com.macedo.backend_challenge.application.contracts.requests.CreateGameMasterRequestDTO;
import com.macedo.backend_challenge.application.contracts.requests.LoginRequestDTO;
import com.macedo.backend_challenge.application.exceptions.CharacterNotFoundException;
import com.macedo.backend_challenge.application.exceptions.InvalidLoginException;
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

    @PostMapping("/register")
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
        try {
            var token = gameMasterService.login(request);
            return new ResponseEntity<>(token, HttpStatusCode.valueOf(200));
        } catch (InvalidLoginException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

}