package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class TopUpService
{
    
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    
    @Autowired
    public TopUpService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
      this.transactionRepository = transactionRepository;
      this.accountRepository = accountRepository;
    }
    
    @Transactional
    /**
     * Tops up the account balance with the price
     * and returns the new balance.
     * @param transactionEntity
     * @return balance
     */
    public BigDecimal topUpAccount(TransactionEntity transactionEntity) {
               
       Optional<AccountEntity> account = accountRepository.findById(transactionEntity.getAccountId());
      
       if (account.isPresent()) {
           AccountEntity accountEntity = account.get();
           transactionRepository.save(transactionEntity);           
           accountEntity.addBalance(transactionEntity.getPrice());
           accountRepository.save(accountEntity);

           return accountEntity.getBalance();
       }
       else {
           throw new IllegalArgumentException("Id doesn't exist");
       }
       
       
    }
}