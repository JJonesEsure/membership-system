package com.membership.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.membership.system.model.AuthenticatedUser;
import com.membership.system.model.AuthenticationRequest;
import com.membership.system.model.Register;
import com.membership.system.service.PersonService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    private final PersonService personService;
    
    @Autowired
    public AuthenticationController(final PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping(path = "/signIn", consumes = "application/json")
    public ResponseEntity<AuthenticatedUser>
    signin(@RequestBody AuthenticationRequest data) {
        return ResponseEntity.ok(personService.signin(data)); 
    }
    
    /**
     * The register endpoint, runs a post which accepts and returns json.
     * Takes the persons details, and assignes them to a person and returns the id.
     * @param register
     * @return personId
     */
    //register endpoint, runs a post which accepts and returns json.
    //User specifies details which are then added to account, returns the new personId.
        @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
        public ResponseEntity<AuthenticatedUser>
        register(@RequestBody Register register){
            return ResponseEntity.ok(personService.registerForAccount(register));
    }
}
