package com.fernando.lab.two.service.impl;

import com.fernando.lab.two.entity.Order;
import com.fernando.lab.two.repository.PaymentRepository;
import com.fernando.lab.two.service.GeneralPaymentService;

public class ExpressPaymentServiceImpl implements GeneralPaymentService {

    PaymentRepository paymentRepository;

    public ExpressPaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public boolean processPayment(Order order) {
        // Handles express payment processing
        if (paymentRepository.process(order.getAmount(), order.getPriority())) {
            return true;
        } else {
            throw new Error("Express payment failed");
        }
    }

}
