package com.ekart.repositories;
import com.ekart.entity.OrderItem;
import com.ekart.entity.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by santhosh on 7/12/2015.
 */

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
    List<OrderItem> findByOrderId(Long orderId);
}

