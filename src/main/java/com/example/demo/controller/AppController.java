package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TransactionEntity;
import com.example.demo.model.Pay;
import com.example.demo.model.Register;
import com.example.demo.model.TopUp;
import com.example.demo.service.PayService;
import com.example.demo.service.RegisterService;
import com.example.demo.service.TopUpService;


@RestController
public class AppController {

    private TopUpService topUpService;
    private PayService payService;
    private RegisterService registerService;
    @Autowired
    public AppController(TopUpService topUpService, PayService payService, RegisterService registerService) {
      this.topUpService = topUpService;
      this.payService = payService;
      this.registerService = registerService;
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
    
    /**
     * The register endpoint, runs a post which accepts and returns json.
     * Takes the persons details, and assignes them to a person and returns the id.
     * @param register
     * @return personId
     */
    //register endpoint, runs a post which accepts and returns json.
    //User specifies details which are then added to account, returns the new personId.
        @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public Long register(@RequestBody Register register) {
        return registerService.registerForAccount(register);
    }
}