package com.membership.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.membership.system.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>
{
    Optional<PersonEntity> findByUsername(String username);
}
