package com.membership.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.membership.system.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>
{
    
}
