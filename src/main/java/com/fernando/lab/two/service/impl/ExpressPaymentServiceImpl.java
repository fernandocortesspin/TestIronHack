package com.fernando.lab.two.service.impl;

import com.fernando.lab.two.entity.Order;
import com.fernando.lab.two.service.GeneralPaymentService;
import com.fernando.lab.two.service.PaymentService;

public class ExpressPaymentServiceImpl implements GeneralPaymentService {

    PaymentService paymentService;

    public ExpressPaymentServiceImpl(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @Override
    public boolean processPayment(Order order) {
        // Handles express payment processing
        if (paymentService.process(order.getAmount(), order.getPriority())) {
            return true;
        } else {
            throw new Error("Express payment failed");
        }
    }

}
