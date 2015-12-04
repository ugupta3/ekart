package com.ekart.repositories;

import com.ekart.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
@Transactional(readOnly = true)
public interface ProductRepository extends CrudRepository<Product, BigInteger> {
    List<Product> getProductsByCategory( String category);
}