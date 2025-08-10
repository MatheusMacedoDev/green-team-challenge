package com.macedo.backend_challenge.domain.entities;

import com.macedo.backend_challenge.application.contracts.requests.CreateGameMasterRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameMaster implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
