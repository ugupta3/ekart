package com.ekart.services;

import com.ekart.entity.Order;
import com.ekart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by umam on 11/26/15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(BigInteger id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
