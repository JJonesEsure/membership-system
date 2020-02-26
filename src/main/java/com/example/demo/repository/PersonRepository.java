package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>
{

}
