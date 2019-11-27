package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardNumberId;
 
    @Column(nullable = false, unique = true)
    private long accountId;
 
    @Column(nullable = false)
    private LocalDateTime experationDate;
    
    @Column(nullable = false)
    private LocalDateTime issueDate;
}