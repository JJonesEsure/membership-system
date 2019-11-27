package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
 
    @Column(nullable = false, unique = true)
    private long cardNumberId;
 
    @Column(nullable = false)
    private String price;
    
    @Column(nullable = false)
    private boolean isToppingUp;
    
    @Column(nullable = false)
    private String item;
    
    @Column(nullable = false)
    private LocalDateTime transactionDate;
    
    @Column(nullable = false)
    private String location;
}