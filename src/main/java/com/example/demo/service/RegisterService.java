package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.model.Register;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class RegisterService
{
    @SuppressWarnings("unused")
    private final AccountRepository accountRepository;
    @SuppressWarnings("unused")
    private final PersonRepository personRepository;
    @SuppressWarnings("unused")
    private final CardRepository cardRepository;
    @Autowired
    public RegisterService(TransactionRepository transactionRepository, AccountRepository accountRepository, PersonRepository personRepository, CardRepository cardRepository) {
      this.accountRepository = accountRepository;
      this.personRepository = personRepository;
      this.cardRepository = cardRepository;
    }
    
    /**
     * Registers a new person with an account
     * based on the details of the person.
     * @param register
     * @return personId
     */
    public Long registerForAccount(Register register) {
        PersonEntity personEntity = setUpPersonEntity(register);
        Long personId = personEntity.getPersonId();
        return personId;
    }
    
    /**
     * Sets up the person entity, this is done by
     * retrieving the information from register.
     * @param register
     * @return personEntity
     */
    private PersonEntity setUpPersonEntity(Register register)
    {
        PersonEntity personEntity = new PersonEntity();
           personEntity.setPersonId(Long.valueOf(2));
           personEntity.setFirstName(register.getFirstName());
           personEntity.setLastName(register.getLastName());
           personEntity.setDateOfBirth(register.getDateOfBirth());
           personEntity.setTitle(register.getTitle());
           personEntity.setEmail(register.getEmail());
           personEntity.setSex(register.getSex());
           personEntity.setMaritalStatus(register.getMaritalStatus());
           personEntity.setOccupation(register.getOccupation());
        return personEntity;
    }
}
