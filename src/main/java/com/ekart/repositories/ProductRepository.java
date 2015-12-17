package com.ekart.repositories;

import com.ekart.constants.CacheNameSpace;
import com.ekart.entity.Product;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
@Transactional(readOnly = true)
public interface ProductRepository extends CrudRepository<Product, BigInteger> {
    @Cacheable(value = "products")
    List<Product> getProductsByCategory( String category);
}
