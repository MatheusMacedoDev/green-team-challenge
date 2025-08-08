package com.macedo.backend_challenge.domain.repositories;

import com.macedo.backend_challenge.domain.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository  extends JpaRepository<Character, Integer> {
    Character getCharacterById(Integer id);
}
