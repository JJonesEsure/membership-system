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
        float accountBalance = 0;
        TopUp.displayAccount(accountBalance);
        float value = TopUp.getValueForTopUp();
        accountBalance = TopUp.topUpAccountWithValue(accountBalance, value);
        TopUp.displayAccount(accountBalance);
    }

    @GetMapping("/topUpGetValue")
    public static String topUpGetValue(Model model) {
        model.addAttribute("value", new TopUp());
        return "value";
    }

    @PostMapping("/topUpAccountBalance")
    public static String topUpAccountBalance(@ModelAttribute TopUp topUp) {
        return "accountBalance";
    }
    
}