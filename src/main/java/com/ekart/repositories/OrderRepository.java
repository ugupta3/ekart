package com.ekart.repositories;

import com.ekart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

    Order   getOrderByCustomerIdAndStatus(Long id,String status);
}
