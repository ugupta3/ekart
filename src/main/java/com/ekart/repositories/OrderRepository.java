package com.ekart.repositories;

import com.ekart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    Order getOpenOrderByCustomerId(BigInteger id);
}
