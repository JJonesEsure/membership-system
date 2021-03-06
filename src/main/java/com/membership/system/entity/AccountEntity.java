package com.membership.system.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ForeignKey;
import javax.persistence.Table;

import com.membership.system.exceptions.InsufficientFundsException;

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
 
    @JoinTable(name = "person", foreignKey = @ForeignKey(name = "person_id"))
    @Column(nullable = false, unique = true)
    private long personId;
    
    @JoinTable(name = "card", foreignKey = @ForeignKey(name = "card_number_id"))
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
        if (balance.compareTo(BigDecimal.ZERO)<0) {
            balance = balance.add(price);
            throw new InsufficientFundsException("Insufficient Funds");
        }
        return this;
    }
}