package com.membership.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.membership.system.entity.PersonEntity;
import com.membership.system.exceptions.UserAlreadyExistsException;
import com.membership.system.factory.AuthenticatedUserFactory;
import com.membership.system.model.AuthenticatedUser;
import com.membership.system.model.AuthenticationRequest;
import com.membership.system.model.Register;
import com.membership.system.repository.PersonRepository;

@Service
public class PersonService
{
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthenticatedUserFactory authenticatedUserFactory;
    
    @Autowired
    public PersonService(
            final PersonRepository personRepository,
            final PasswordEncoder passwordEncoder,
            final AuthenticationManager authenticationManager,
            final AuthenticatedUserFactory authenticatedUserFactory) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.authenticatedUserFactory = authenticatedUserFactory;
    }
    
    /**
     * Registers a new person with an account
     * based on the details of the person.
     * @param register
     * @return personId
     */
    public AuthenticatedUserFactory registerForAccount(Register register) {
        if (personRepository.findByUsername(register.getUserName()).isPresent())
        {
            throw new UserAlreadyExistsException("Supplied user already exists");
        } else {
            final PersonEntity personEntity = setUpPersonEntity(register);
            return authenticatedUserFactory.create(person);
        }
    }
    
    public AuthenticatedUser signin(final AuthenticationRequest data) {
        try {
            final String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            final PersonEntity person = personRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
            return authenticatedUserFactory.create(person);
            
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
    
    /**
     * Sets up the person entity, this is done by
     * retrieving the information from register.
     * @param
     * @return personEntity
     */
    private PersonEntity setUPersonEntity(Register register)
    {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUsername(register.getUserName());
        personEntity.setPassword(passwordEncoder.encode(register.getPassword()));
        personEntity.setDateOfBirth(register.getDateOfBirth());
        personEntity.setTitle(register.getTitle());
        personEntity.setEmail(register.getEmail());
        personEntity.setSex(register.getSex());
        personEntity.setMaritalStatus(register.getMaritalStatus());
        personEntity.setOccupation(register.getOccupation());
        personRepository.saveAndFlush(personEntity);
        return personEntity;
    }
}
