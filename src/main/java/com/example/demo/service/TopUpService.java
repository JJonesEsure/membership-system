package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.model.TopUp;
import com.example.demo.repository.TransactionRepository;

@Service
public class TopUpService
{
    
    private final TransactionRepository transactionRepository;
    @Autowired
    public TopUpService(TransactionRepository transactionRepository) {
      this.transactionRepository = transactionRepository;
    }
    
    public BigDecimal topUpAccount(TopUp topUp) {
       TransactionEntity transactionEntity = new TransactionEntity();
       transactionRepository.save(transactionEntity);
       return BigDecimal.TEN;
       
    }
 
    public void displayAccount(float accountBalance) {
        //output
    }

    public float getValueForTopUp()
    {
        //input
        TransactionEntity transactionEntity= new TransactionEntity();
        float value =  transactionEntity.getPrice();
        return value;
    }

    public float topUpAccountWithValue(float accountBalance, float value)
    {
        accountBalance += value;
        return accountBalance;
    }
}
