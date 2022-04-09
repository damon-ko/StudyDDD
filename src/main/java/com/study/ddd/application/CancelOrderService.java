package com.study.ddd.application;

import com.study.ddd.NoOrderException;
import com.study.ddd.domain.order.Order;
import com.study.ddd.domain.order.OrderNumber;
import com.study.ddd.domain.order.OrderRepository;

import javax.transaction.Transactional;

public class CancelOrderService {
    private final OrderRepository orderRepository;

    public CancelOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void cancel(OrderNumber number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException();
        order.cancel();
    }
}
