package com.membership.system.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.membership.system.entity.PersonEntity;
import com.membership.system.model.AuthenticatedUser;
import com.membership.system.security.JwtTokenProvider;

@Component
public class AuthenticatedUserFactory {
    private final JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    public AuthenticatedUserFactory(final JwtTokenProvider jwtTokenProvider)
    {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    
    public AuthenticatedUser create(final PersonEntity person) {
        return new AuthenticatedUser()
                .setUserName(person.getUsername())
                .setToken(jwtTokenProvider.createToken(person.getUsername(), person.getRoles()));
    }
}