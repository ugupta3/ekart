package com.ekart.services;

import com.ekart.entity.Pricing;
import com.ekart.entity.Product;
import com.ekart.repositories.ProductRepository;
import com.ekart.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private static Function<Pricing, ProductResponse> productToProductResponseFunction;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> listAllProducts() {
        return null;
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {

        List<ProductResponse> productResponses = new ArrayList<>();

        productRepository.getProductsByCategory(category).forEach(
                product -> {

                    List<ProductResponse> responses = product.getPricing().stream().map(
                            pricing ->
                                    new ProductResponse(product.getProductId(), product.getImageUrl(), product.getProductName(),
                                            pricing.getUser().getAddress().get(0).getAddressLine1(), pricing.getSellPrice())).collect(Collectors.toList());

                    productResponses.addAll(responses);
                }
        );

        return productResponses;

    }


    @Override
    public Product getProductById(BigInteger id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
