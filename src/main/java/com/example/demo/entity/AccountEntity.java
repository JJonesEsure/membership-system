package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
 
    @Column(nullable = false, unique = true)
    private long personId;
    
    @Column(nullable = false, unique = true)
    private long cardNumberId;
 
    @Column(nullable = false)
    private LocalDateTime creationDate;
    
    @Column(nullable = false)
    private boolean isActive;
    
    @Column(nullable = false)
    private float balance;
    
    @Column(nullable = false)
    private String restrictions;
    
    @Column(nullable = false)
    private LocalDateTime lastUsed;
}