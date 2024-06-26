package com.fernando.lab.two.factory;

import com.fernando.lab.two.constant.OrderType;
import com.fernando.lab.two.entity.Order;
import com.fernando.lab.two.repository.PaymentRepositoryImpl;
import com.fernando.lab.two.service.GeneralPaymentService;
import com.fernando.lab.two.service.impl.ExpressPaymentServiceImpl;
import com.fernando.lab.two.service.impl.StandardPaymentServiceImpl;

public class OrderFactory {


    public static GeneralPaymentService getInstance(Order order){

        if(OrderType.EXPRESS.equals(order.getType())){

            return new ExpressPaymentServiceImpl(new PaymentRepositoryImpl());

        } else if(OrderType.STANDARD.equals(order.getType())) {

            return new StandardPaymentServiceImpl(new PaymentRepositoryImpl());
        } else {

            throw new RuntimeException("Type not supported");
        }

    }
}
