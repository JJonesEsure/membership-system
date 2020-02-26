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
 * This is the card entity,
 * it is the structure of the data.
 * @author Jacob Jones
 *
 */
@Entity
@Data
@Table(name="card")
public class CardEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardNumberId;
 
    @Column(nullable = true)
    private LocalDateTime experationDate;
    
    @Column(nullable = true)
    private LocalDateTime issueDate;
}