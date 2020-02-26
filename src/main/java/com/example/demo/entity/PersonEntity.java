package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This is the account entity,
 * it is the structure of the data.
 * @author Jacob Jones
 *
 */
@Entity
@Data
@Table(name="person")
public class PersonEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = true)
    private LocalDateTime dateOfBirth;
    
    @Column(nullable = true)
    private String title;
    
    @Column(nullable = true)
    private String email;
    
    @Column(nullable = true)
    private String sex;
    
    @Column(nullable = true)
    private String maritalStatus;
    
    @Column(nullable = true)
    private String occupation;
}