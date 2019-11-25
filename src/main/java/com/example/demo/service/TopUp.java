package com.example.demo.service;

import org.springframework.ui.Model;

import com.example.demo.controller.DemoController;

public class TopUp
{
    private float value;
    
    public float getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    
    public static void displayAccount(float accountBalance) {
        //output
    }

    public static float getValueForTopUp()
    {
        
        //input
        String inputValue = DemoController.topUpGetValue(model);
        float value =  Float.valueOf(inputValue).floatValue();
        return value;
    }

    public static float topUpAccountWithValue(float accountBalance, float value)
    {
        accountBalance += value;
        return accountBalance;
    }
}
