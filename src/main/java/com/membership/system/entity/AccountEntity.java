package com.membership.system.entity;

import java.math.BigDecimal;
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
 * it is the structure of the data
 * and it also contains the functions to
 * add and subtract form the balance.
 * @author Jacob Jones
 *
 */
@Entity
@Data
@Table(name="account")
public class AccountEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
 
    @Column(nullable = false, unique = true)
    private long personId;
    
    @Column(nullable = false, unique = true)
    private long cardNumberId;
 
    @Column(nullable = true)
    private LocalDateTime creationDate;
    
    @Column(nullable = true)
    private boolean isActive;
    
    @Column(nullable = true)
    private BigDecimal balance=BigDecimal.ZERO;
    
    @Column(nullable = true)
    private String restrictions;
    
    @Column(nullable = true)
    private LocalDateTime lastUsed;
    
    public AccountEntity addBalance(BigDecimal price) {
        balance = balance.add(price);
        return this;
    }
    
    public AccountEntity subtractBalance(BigDecimal price) {
        balance = balance.subtract(price);
        return this;
    }
}