package com.membership.system.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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
@Table(name="transaction")
public class TransactionEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    
    @JoinTable(name = "account", foreignKey = @ForeignKey(name = "account_id"))
    @Column(nullable = false)
    private long accountId;
 
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column(nullable = false)
    private boolean isToppingUp;
    
    @Column(nullable = true)
    private String item;
    
    @Column(nullable = false)
    private LocalDateTime transactionDate;
    
    @Column(nullable = true)
    private String location;
}