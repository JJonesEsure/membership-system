package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
 
    @Column(nullable = false, unique = true)
    private long accountId;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private LocalDateTime dateOfBirth;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String sex;
    
    @Column(nullable = false)
    private String maritalStatus;
    
    @Column(nullable = false)
    private String occupation;
}