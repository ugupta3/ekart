package com.ekart.services;

import com.ekart.entity.Order;
import com.ekart.entity.OrderItem;

import java.math.BigInteger;

/**
 * Created by umam on 11/26/15.
 */
public interface OrderService {
    Iterable<Order> listAllOrders();

    Order getOrderById(BigInteger id);

    Order saveOrder(Order order);

    Order getOpenOrderByCustomerId(BigInteger customerId);

    OrderItem saveOrderItem(OrderItem item);
}
