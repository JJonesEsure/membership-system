package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TopUp;

@RestController
public class DemoController {

    @RequestMapping("/home")
    public String helloWorld() {
        return "Hello World!";
    }
    
    @RequestMapping("/topUp")
    public void topUp() {
        //Show account balance
        //Enter a value
        //Add value to account
        //Show account balance
        TopUp topUp = new TopUp();
        float accountBalance = 0;
        topUp.displayAccount(accountBalance);
        float value = topUp.getValueForTopUp();
        accountBalance = topUp.topUpAccountWithValue(accountBalance, value);
        topUp.displayAccount(accountBalance);
    }

    public static String topUpGetValue() {
        return "value";
    }

    public static String topUpAccountBalance() {
        return "accountBalance";
    }
    
}