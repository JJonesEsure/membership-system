package com.example.demo.repository.implementation;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TransactionRepositoryImplementation implements TransactionRepository
{
    static HashMap<Long, TransactionEntity> hashMap = new HashMap<>();
    static Long latestId = 0L;
    
    @Override
    public TransactionEntity save(TransactionEntity transactionEntity)
    {
        log.info("got to here");
        latestId ++;
        transactionEntity.setTransactionId(latestId);
        hashMap.put(transactionEntity.getTransactionId(), transactionEntity);
        return transactionEntity;
    }

    @Override
    public Optional<TransactionEntity> getById(Long id)
    {
        
        return Optional.ofNullable(hashMap.get(id));
    }

}
