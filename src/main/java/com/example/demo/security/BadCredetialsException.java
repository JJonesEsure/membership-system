package com.example.demo.security;

import org.springframework.security.core.AuthenticationException;

public class BadCredetialsException extends AuthenticationException {
    /**
     * 
     */
    private static final long serialVersionUID = -761503632186596342L;

    public BadCredetialsException(String e) {
        super(e);
    }
}