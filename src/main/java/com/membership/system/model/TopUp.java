package com.membership.system.model;

import java.math.BigDecimal;

import lombok.Data;

/**
 * The TopUp model, this is the request for
 * the topUp endpoint and is the data given
 * in the body.
 * @author Jacob Jones
 *
 */
@Data
public class TopUp
{
    Long accountId;
    BigDecimal price;
}
