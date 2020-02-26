package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class PayService
{
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    
    @Autowired
    public PayService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
      this.transactionRepository = transactionRepository;
      this.accountRepository = accountRepository;
    }
    
    /**
     * Pays from the account by getting the price
     * and subtracting it from the balance.
     * @param transactionEntity
     * @return balance
     */
    public BigDecimal payFromAccount(TransactionEntity transactionEntity) {
        Optional<AccountEntity> account = accountRepository.findById(transactionEntity.getAccountId());
        
        if (account.isPresent()) {
            AccountEntity accountEntity = account.get();
            transactionRepository.save(transactionEntity);           
            accountEntity.subtractBalance(transactionEntity.getPrice());
            accountRepository.save(accountEntity);

            return accountEntity.getBalance();
        }
        else {
            throw new IllegalArgumentException("Id doesn't exist");
        }
        
        
     }
}