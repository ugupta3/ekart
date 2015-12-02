package com.ekart.api;

import com.ekart.response.ProductResponse;
import com.ekart.services.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductResource {

    private ProductService productService;

    @Inject
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductResponse> listAllProductsByCategory(
            @DefaultValue("water")@QueryParam(value = "category") String categoryName) {

        return productService.getProductsByCategory(categoryName);
    }

}
