package com.membership.system.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.membership.system.entity.TransactionEntity;
import com.membership.system.model.Pay;
import com.membership.system.model.TopUp;
import com.membership.system.service.PayService;
import com.membership.system.service.TopUpService;


@RestController
public class AppController {

    private TopUpService topUpService;
    private PayService payService;
    @Autowired
    public AppController(TopUpService topUpService, PayService payService) {
        this.topUpService = topUpService;
        this.payService = payService;
    }
    
    /**
     * TopUp endpoint, runs a post which accepts and returns json.
     * Adds the amount specified to the balance of the account specified.
     * @param topUp
     * @return balance
     */
    @PostMapping(path = "/topUp", consumes = "application/json", produces = "application/json")
    public BigDecimal topUp(@RequestBody TopUp topUp) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(topUp.getAccountId());
        transactionEntity.setPrice(topUp.getPrice());
        transactionEntity.setToppingUp(true);
        return topUpService.topUpAccount(transactionEntity);
    }

    /**
     * Pay endpoint, runs a post which accepts and returns json.
     * Subtracts the amount specified to the balance of the account specified.
     * @param pay
     * @return balance
     */
        @PostMapping(path = "/pay", consumes = "application/json", produces = "application/json")
    public BigDecimal pay(@RequestBody Pay pay) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAccountId(pay.getAccountId());
        transactionEntity.setPrice(pay.getPrice());
        transactionEntity.setToppingUp(true);
        transactionEntity.setItem(pay.getItem());
        return payService.payFromAccount(transactionEntity);
    }
    
}