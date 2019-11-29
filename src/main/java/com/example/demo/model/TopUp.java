package com.example.demo.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TopUp
{
    Long accountId;
    BigDecimal amount;
}
