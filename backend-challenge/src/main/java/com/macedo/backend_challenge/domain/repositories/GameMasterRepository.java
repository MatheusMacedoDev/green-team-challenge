package com.macedo.backend_challenge.domain.repositories;

import com.macedo.backend_challenge.domain.entities.GameMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface GameMasterRepository extends JpaRepository<GameMaster, Integer> {
    GameMaster getByEmail(String email);
}
