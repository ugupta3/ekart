package com.ekart.services;


import com.ekart.entity.Product;
import com.ekart.response.ProductResponse;

import java.math.BigInteger;
import java.util.List;

public interface ProductService {

    List<ProductResponse> listAllProducts();

    List<ProductResponse> getProductsByCategory(String category);

    Product getProductById(BigInteger id);

    Product saveProduct(Product product);
}
