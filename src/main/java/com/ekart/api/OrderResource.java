package com.ekart.api;

import com.ekart.constants.OrderStatus;
import com.ekart.entity.Order;
import com.ekart.entity.OrderItem;
import com.ekart.services.OrderService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
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
    public List<OrderItem> listOpenOrderItems() {
        return null;
    }

    @POST
    @Path(value = "/addItemToCart")
    @Produces(MediaType.APPLICATION_JSON)
   //three params : ProductID UserAccount (from HTTPRequestObject), MerchantID, Quantity
    // Create/get orderId for passed in UserAccount
    // Create OrderItem
    // return success Status
    public Response addItemToCart(@FormParam("ProductId") BigInteger productId,
                                  @FormParam("MerchantId") BigInteger merchantId,
                                  @FormParam("Quantity") int quantity,
                                  @Context HttpServletRequest httpRequest) {
        BigInteger customerId = new BigInteger(httpRequest.getParameter("userAccount"));
       Order openOrder = orderService.getOpenOrderByCustomerId(customerId);
       if(openOrder == null)
        {
            //order doesn't exist yet. Create one
            openOrder = new Order();
            Date now = new Date();
            openOrder.setCustomerId(customerId);
            openOrder.setDateCreated(now);
            //openOrder.setSessionId(new BigInteger(httpRequest.getSession().getId()));
            openOrder.setDateUpdated(now);
            openOrder.setOrderStatus(OrderStatus.OPEN.stringValue());
        }
        orderService.saveOrder(openOrder);
        OrderItem item = new OrderItem();
        item.setOrderId(openOrder.getOrderId());
        item.setMerchantId(merchantId);
        item.setProductId(productId);
        item.setQuantity(quantity);

        item = orderService.saveOrderItem(item);
        return null;
    }



}
