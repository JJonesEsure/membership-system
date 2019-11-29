package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.TransactionEntity;

public interface TransactionRepository
{
    TransactionEntity save(TransactionEntity transactionEntity);
    Optional<TransactionEntity> getById(Long id);
}
