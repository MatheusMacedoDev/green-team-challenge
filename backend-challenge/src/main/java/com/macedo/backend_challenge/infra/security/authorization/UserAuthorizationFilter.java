package com.macedo.backend_challenge.infra.security.authorization;

import com.macedo.backend_challenge.domain.entities.GameMaster;
import com.macedo.backend_challenge.domain.repositories.GameMasterRepository;
import com.macedo.backend_challenge.infra.security.authentication.TokenStrategy;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UserAuthorizationFilter extends  OncePerRequestFilter{

    @Autowired
    private TokenStrategy tokenStrategy;

    @Autowired
    private GameMasterRepository gameMasterRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoveryToken(request);

        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String subject = tokenStrategy.getSubjectFromToken(token);

        GameMaster gameMaster = gameMasterRepository.getByEmail(subject);

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(gameMaster.getUsername(), null, gameMaster.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }

}
