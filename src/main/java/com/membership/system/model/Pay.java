package com.membership.system.model;

import java.math.BigDecimal;

import lombok.Data;

/**
 * The pay model, this is the request for
 * the pay endpoint and is the data given
 * in the body.
 * @author Jacob Jones
 *
 */
@Data
public class Pay
{
    Long accountId;
    BigDecimal price;
    String item;
}
