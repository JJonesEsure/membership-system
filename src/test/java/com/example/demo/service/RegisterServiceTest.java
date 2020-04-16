package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.model.Register;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class RegisterServiceTest
{
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private RegisterService registerService;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() {
       MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void registerAccountFailureInvalidAccount() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Id doesn't exist");
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPersonId(1L);
        Register register = new Register();
        when(personRepository.findById(1L)).thenReturn(Optional.empty());
        registerService.registerForAccount(register);
    }
    
    @Test
    public void registerForAccountSuccess() {
        Register register = new Register();
        PersonEntity personEntity = new PersonEntity();
        register.setFirstName("Jacob");
        register.setLastName("Jones");
        register.setDateOfBirth(LocalDateTime.parse("2000-08-02T00:29:53.949"));
        register.setTitle("Mr");
        register.setEmail("jacob.jones@esure.com");
        register.setSex("male");
        register.setMaritalStatus("Single");
        register.setOccupation("Software Engineer");
        when(personRepository.findById(1L)).thenReturn(Optional.of(personEntity));
        Long personId = registerService.registerForAccount(register);
        verify(personRepository).save(personEntity);
        assertThat(personId).isEqualTo("1");
    }
}
