package com.ekart.services;

import com.ekart.entity.Order;
import com.ekart.entity.OrderItem;
import com.ekart.entity.Pricing;
import com.ekart.entity.MerchantProductKey;
import com.ekart.repositories.OrderItemRepository;
import com.ekart.repositories.OrderRepository;
import com.ekart.repositories.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.math.BigInteger;

/**
 * Created by umam on 11/26/15.
 */
@Named
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private PricingRepository pricingRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,OrderItemRepository orderItemRepository, PricingRepository pricingRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.pricingRepository = pricingRepository;
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

    public Order getOpenOrderByCustomerId(BigInteger customerId)
    {
        return orderRepository.getOpenOrderByCustomerId(customerId);
    }

    public OrderItem saveOrderItem(OrderItem orderItem)
    {
        Pricing pricing = pricingRepository.findOne(new MerchantProductKey(orderItem.getProductId(),orderItem.getMerchantId()));
        orderItem.setSellPrice(pricing.getSellPrice());
        orderItem.setEkPercentage(pricing.getEkPercentagek());
        orderItem.setMerchantPrice(pricing.getMerchantPrice());
        orderItem.setTotalPrice(orderItem.getQuantity()*orderItem.getSellPrice());
        return orderItemRepository.save(orderItem);
    }


}
