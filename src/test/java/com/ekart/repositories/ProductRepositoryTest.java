package com.ekart.repositories;

import com.ekart.configuration.RepositoryConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testSaveProduct(){
    /*    //setup product
        Product product = new Product();
        product.setProductName("Spring Framework Guru Shirt");
        product.setImageUrl("/helloSpring");
        product.setCategoryId(BigInteger.ONE);
        //save product, verify has ID value after save
        assertNull(product.getProductId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getProductId()); //not null after save

        //fetch from DB
        Product fetchedProduct = productRepository.findOne(product.getProductId());

        //should not be null
        assertNotNull(fetchedProduct);

        //should equal
        assertEquals(product.getProductId(), fetchedProduct.getProductId());
        assertEquals(product.getProductName(), fetchedProduct.getProductName());

        //update description and save
        fetchedProduct.setProductName("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getProductId());
        assertEquals(fetchedProduct.getProductName(), fetchedUpdatedProduct.getProductName());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product p : products){
            count++;
        }

        assertEquals(count, 1);*/
    }
}
