package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TopUp;
import com.example.demo.service.TopUpService;

@RestController
public class DemoController {

    private TopUpService topUpService;
    @Autowired
    public DemoController(TopUpService topUpService) {
      this.topUpService = topUpService;
    }
    
    @RequestMapping("/home")
    public String helloWorld() {
        return "Hello World!";
    }
    
    @PostMapping(path = "/topUp", consumes = "application/json", produces = "application/json")
    public BigDecimal topUp(@RequestBody TopUp topUp) {
        //Show account balance
        //Enter a value
        //Add value to account
        //Show account balance
        return topUpService.topUpAccount(topUp);
    }

    public static String topUpGetValue() {
        return "value";
    }

    public static String topUpAccountBalance() {
        return "accountBalance";
    }
    
}