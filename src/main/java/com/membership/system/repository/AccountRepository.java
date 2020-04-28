package com.membership.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.membership.system.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>
{
    
}
