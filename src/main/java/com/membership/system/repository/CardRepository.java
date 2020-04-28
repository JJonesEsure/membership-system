package com.membership.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.membership.system.entity.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity, Long>
{

}