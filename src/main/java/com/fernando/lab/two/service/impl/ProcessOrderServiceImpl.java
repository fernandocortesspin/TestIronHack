package com.fernando.lab.two.service.impl;

import com.fernando.lab.two.entity.Order;
import com.fernando.lab.two.factory.OrderFactory;
import com.fernando.lab.two.service.GeneralPaymentService;
import com.fernando.lab.two.service.ProcessOrderService;

public class ProcessOrderServiceImpl implements ProcessOrderService {

    @Override
    public void processOrder(Order order) {

        verifyInventory(order);

        GeneralPaymentService paymentService = OrderFactory.getInstance(order);

        paymentService.processPayment(order);
    }

    private void verifyInventory(Order order) {
        int inventory = 100 ; // Get from some repository
        // Checks inventory levels
        if (inventory < order.getQuantity()) {
            throw new Error("Out of stock");
        }
    }

}
