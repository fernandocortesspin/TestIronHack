package com.fernando.lab.two.repository;

import java.math.BigDecimal;

public abstract class PaymentRepository {

    public abstract boolean process(BigDecimal amount);

    public abstract boolean process(BigDecimal amount, int priority);
}
