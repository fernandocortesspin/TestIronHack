package com.fernando.lab.two.service;

import java.math.BigDecimal;

public abstract class PaymentService {

    public abstract boolean process(BigDecimal amount);

    public abstract boolean process(BigDecimal amount, int priority);

}
