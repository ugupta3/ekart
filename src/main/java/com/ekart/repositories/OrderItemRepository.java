package com.ekart.repositories;
import com.ekart.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;

/**
 * Created by santhosh on 7/12/2015.
 */

public interface OrderItemRepository extends JpaRepository<OrderItem, BigInteger> {

}

