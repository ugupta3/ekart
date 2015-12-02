package com.ekart.api;

import com.ekart.constants.OrderStatus;
import com.ekart.entity.Order;
import com.ekart.services.OrderService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("")
public class OrderResource {

    private OrderService orderService;

    @Inject
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    @Path(value = "/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Order> listAll() {
        return orderService.listAllOrders();
    }

    @GET
    @Path(value = "/cart")
    @Produces(MediaType.APPLICATION_JSON)
    public Order createOrder() {
        Order order = new Order();
        order.setOrderName("First order");
        order.setOrderStatus(OrderStatus.PENDING.stringValue());
        orderService.saveOrder(order);
        return order;
    }

}
