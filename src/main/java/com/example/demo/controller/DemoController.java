package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TopUp;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DemoController {

    @RequestMapping("/home")
    public String helloWorld() {
        return "Hello World!";
    }
    
    @RequestMapping("/topUp")
    public String topUp() {
        //Show account balance
        //Enter a value
        //Add value to account
        //Show account balance
        float accountBalance = 0;
        TopUp.displayAccount(accountBalance);
        float value = TopUp.getValueForTopUp();
        accountBalance = TopUp.topUpAccountWithValue(accountBalance, value);
        TopUp.displayAccount(accountBalance);
        return "";
    }

}