package com.ekart.repositories;

import com.ekart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductsByCategory( String category);
}
