package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.TransactionEntity;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;

public class TopUpServiceTest
{
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private TopUpService topUpService;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() {
       MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void topUpAccountFailureInvalidAccount() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Id doesn't exist");
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(1L);
        when(accountRepository.findById(1L)).thenReturn(Optional.empty());
        topUpService.topUpAccount(transactionEntity);
    }
    
    @Test
    public void topUpAccountSuccess() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(1L);
        accountEntity.setBalance(BigDecimal.ONE);
        accountEntity.setActive(true);
        accountEntity.setCardNumberId(1L);
        accountEntity.setCreationDate(LocalDateTime.now());
        accountEntity.setLastUsed(LocalDateTime.now());
        accountEntity.setPersonId(1L);
        accountEntity.setRestrictions("restrictions");
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(1L);
        transactionEntity.setPrice(BigDecimal.ONE);
        transactionEntity.setItem("item");
        transactionEntity.setLocation("location");
        transactionEntity.setToppingUp(true);
        transactionEntity.setTransactionDate(LocalDateTime.now());
        when(accountRepository.findById(1L)).thenReturn(Optional.of(accountEntity));
        BigDecimal balance = topUpService.topUpAccount(transactionEntity);
        verify(transactionRepository).save(transactionEntity);
        assertThat(balance).isEqualTo("11");
    }
    
    @Test
    public void TopUpAccountWhenBalanceIsNull() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(1L);
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(1L);
        transactionEntity.setPrice(BigDecimal.TEN);
        when(accountRepository.findById(1L)).thenReturn(Optional.of(accountEntity));
        BigDecimal balance = topUpService.topUpAccount(transactionEntity);
        verify(transactionRepository).save(transactionEntity);
        assertThat(balance).isEqualTo("10");
    }
}
