package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DemoController {

    @RequestMapping("/helloWorld")
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
//        displayAccount(accountBalance);
//        float value = getValueForTopUp();
//        topUpAccountWithValue(accountBalance, value);
//        displayAccount(accountBalance);
        return "";
    }

}