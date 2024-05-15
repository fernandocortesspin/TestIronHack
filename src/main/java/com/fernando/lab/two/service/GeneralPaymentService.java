package com.fernando.lab.two.service;

import com.fernando.lab.two.entity.Order;

public interface GeneralPaymentService {

    boolean processPayment(Order order);

}
