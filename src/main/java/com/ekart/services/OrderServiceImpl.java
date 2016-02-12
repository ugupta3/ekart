package com.ekart.services;

import com.ekart.constants.OrderStatus;
import com.ekart.entity.*;
import com.ekart.repositories.OrderItemRepository;
import com.ekart.repositories.OrderRepository;
import com.ekart.repositories.PricingRepository;
import com.ekart.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Order getOrderById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOpenOrderByCustomerId(Long customerId)
    {
        return this.getOrderByCustomerIdAndStatus(customerId, OrderStatus.OPEN.stringValue());
    }


    public Order getOrderByCustomerIdAndStatus(Long customerId, String status)
    {
        return orderRepository.getOrderByCustomerIdAndStatus(customerId,status);
    }

    public OrderItem getOrderItemById(OrderItemKey itemKey) {
        return orderItemRepository.findOne(itemKey);
    }

    public OrderItem saveOrderItem(OrderItem orderItem)
    {
        Pricing pricing = pricingRepository.findOne(new MerchantProductKey(orderItem.getId().getProductId(),orderItem.getId().getMerchantId()));
        orderItem.setSellPrice(pricing.getSellPrice());
        orderItem.setEkPercentage(pricing.getEkPercentagek());
        orderItem.setMerchantPrice(pricing.getMerchantPrice());
        orderItem.setTotalPrice(orderItem.getQuantity()*orderItem.getSellPrice());
        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem>  listAllOpenOrderItems( Long customerId){
        List<OrderItem> orderItemResponses = new ArrayList<>();

       Order openOrder = this.getOpenOrderByCustomerId(customerId);
       if(openOrder != null) {
           orderItemResponses = orderItemRepository.findByOrderId(openOrder.getOrderId());
                }
        return orderItemResponses;
    }
}
