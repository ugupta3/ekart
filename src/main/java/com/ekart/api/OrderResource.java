package com.ekart.api;

import com.ekart.constants.OrderStatus;
import com.ekart.entity.Order;
import com.ekart.entity.OrderItem;
import com.ekart.entity.OrderItemKey;
import com.ekart.services.OrderService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    /*
    params:
           1. HTTPRequest or Session ID
     */
    public List<OrderItem> listOpenOrderItems(@Context HttpServletRequest httpRequest) {
        Long customerId = new Long(httpRequest.getParameter("userAccount"));
        return orderService.listAllOpenOrderItems(customerId);
    }

    @POST
    @Path(value = "/addItemToCart")
    @Produces(MediaType.APPLICATION_JSON)
    //three params : ProductID UserAccount (from HTTPRequestObject), MerchantID, Quantity
    // Create/get orderId for passed in UserAccount
    // Create OrderItem
    // return success Status
    public Response addItemToCart(@FormParam("ProductId") Long productId,
                                  @FormParam("MerchantId") Long merchantId,
                                  @FormParam("Quantity") int quantity,
                                  @Context HttpServletRequest httpRequest) {
        Long customerId = new Long(httpRequest.getParameter("userAccount"));
        Order openOrder = orderService.getOpenOrderByCustomerId(customerId);
        if(openOrder == null)
        {
            //order doesn't exist yet. Create one
            openOrder = new Order();
            Date now = new Date();
            openOrder.setCustomerId(customerId);
            openOrder.setDateCreated(now);
            //openOrder.setSessionId(new Long(httpRequest.getSession().getId()));
            openOrder.setDateUpdated(now);
            openOrder.setOrderStatus(OrderStatus.OPEN.stringValue());
            openOrder = orderService.saveOrder(openOrder);

        }

        List<OrderItem> itemsList  = openOrder.getOrderItems();
        OrderItemKey itemKey = new OrderItemKey();
        itemKey.setOrderId(openOrder.getOrderId());
        itemKey.setProductId(productId);
        itemKey.setMerchantId(merchantId);
        OrderItem newItem =  new OrderItem();
        newItem.setId(itemKey);
        int index = itemsList.indexOf(newItem);
        if(index != -1){
            //same item is already preset in the order, so augment it with the new quantity
            OrderItem savedItem = itemsList.get(index);
            savedItem.setQuantity(savedItem.getQuantity()+quantity);
            newItem = savedItem;
        }
        else{
            //its a new item, so add it to the list
            newItem.setQuantity(quantity);
        }

        newItem = orderService.saveOrderItem(newItem);
        return null;
    }
}
