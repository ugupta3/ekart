package com.ekart.services;

import com.ekart.entity.Order;
import com.ekart.entity.OrderItem;
import com.ekart.entity.OrderItemKey;

import java.util.List;

/**
 * Created by umam on 11/26/15.
 */
public interface OrderService {
    Iterable<Order> listAllOrders();

    Order getOrderById(Long id);

    Order saveOrder(Order order);

    Order getOpenOrderByCustomerId(Long customerId);

    Order getOrderByCustomerIdAndStatus(Long id,String status);

    OrderItem getOrderItemById(OrderItemKey itemKey);

    OrderItem saveOrderItem(OrderItem item);

    List<OrderItem> listAllOpenOrderItems(Long customerId);
}
