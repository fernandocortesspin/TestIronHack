package com.fernando.lab.two.service.impl;

import com.fernando.lab.two.entity.Order;
import com.fernando.lab.two.repository.PaymentRepository;
import com.fernando.lab.two.service.GeneralPaymentService;

public class StandardPaymentServiceImpl implements GeneralPaymentService {

    PaymentRepository paymentRepository;

    public StandardPaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public boolean processPayment(Order order) {
        // Handles standard payment processing
        if (paymentRepository.process(order.getAmount())) {
            return true;
        } else {
            throw new Error("Payment failed");
        }
    }

}
