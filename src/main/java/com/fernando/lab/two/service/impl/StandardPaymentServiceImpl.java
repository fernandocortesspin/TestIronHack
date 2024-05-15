package com.fernando.lab.two.service.impl;

import com.fernando.lab.two.entity.Order;
import com.fernando.lab.two.service.GeneralPaymentService;
import com.fernando.lab.two.service.PaymentService;

public class StandardPaymentServiceImpl implements GeneralPaymentService {

    PaymentService paymentService;

    public StandardPaymentServiceImpl(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    public boolean processPayment(Order order) {
        // Handles standard payment processing
        if (paymentService.process(order.getAmount())) {
            return true;
        } else {
            throw new Error("Payment failed");
        }
    }

}
