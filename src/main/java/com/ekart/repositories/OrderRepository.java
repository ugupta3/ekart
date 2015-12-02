package com.ekart.repositories;

import com.ekart.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface OrderRepository extends CrudRepository<Order, BigInteger>{
}
