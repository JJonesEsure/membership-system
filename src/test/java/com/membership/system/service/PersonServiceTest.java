package com.membership.system.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.membership.system.entity.PersonEntity;
import com.membership.system.exceptions.UserAlreadyExistsException;
import com.membership.system.factory.AuthenticatedUserFactory;
import com.membership.system.model.AuthenticatedUser;
import com.membership.system.model.Register;
import com.membership.system.repository.PersonRepository;

@Service
public class PersonServiceTest
{
    @Mock
    private PersonRepository personRepository;

    @Mock
    private PasswordEncoder passwordEncoder;
    
    @Mock 
    private AuthenticationManager authenticationManager;
    
    @Mock
    private AuthenticatedUserFactory authenticatedUserFactory;
    
    @InjectMocks
    private PersonService registerService;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void registerAccountFailureInvalidAccount() {
        expectedException.expect(UserAlreadyExistsException.class);
        expectedException.expectMessage("Supplied user already exists");
        PersonEntity personEntity= new PersonEntity();
        personEntity.setPersonId(1L);
        Register register = new Register();
        register.setUserName("jjones");
        when(personRepository.findByUsername("jjones")).thenReturn(Optional.of(personEntity));
        registerService.registerForAccount(register);
    }
    
    @Test
    public void registerForAccountSuccess() {
        Register register = new Register();
        register.setFirstName("Jacob");
        register.setLastName("Jones");
        register.setDateOfBirth(LocalDateTime.parse("2000-08-02T00:29:53.949"));
        register.setTitle("Mr");
        register.setEmail("jacob.jones@esure.com");
        register.setSex("male");
        register.setMaritalStatus("Single");
        register.setOccupation("Software Engineer");
        register.setUserName("jjones");
        register.setPassword("password");
        
        ArgumentCaptor<PersonEntity> personCaptor = ArgumentCaptor.forClass(PersonEntity.class);
        
        when(personRepository.findByUsername("jjones")).thenReturn(Optional.empty());
        when(authenticatedUserFactory.create(personCaptor.capture())).thenReturn(new AuthenticatedUser().setUserName("jjones"));
        AuthenticatedUser user = registerService.registerForAccount(register);
        verify(personRepository).saveAndFlush(personCaptor.capture());
        assertThat(user.getUserName()).isEqualTo("jjones");
        assertThat(personCaptor.getValue())
            .hasFieldOrPropertyWithValue("firstName", "Jacob")
            .hasFieldOrPropertyWithValue("lastName", "Jones")
            .hasFieldOrPropertyWithValue("title", "Mr")
            .hasFieldOrPropertyWithValue("email", "jacob.jones@esure.com")
            .hasFieldOrPropertyWithValue("sex", "male")
            .hasFieldOrPropertyWithValue("maritalStatus", "Single")
            .hasFieldOrPropertyWithValue("occupation", "Software Engineer")
            .hasFieldOrPropertyWithValue("username", "jjones");
    }
}
