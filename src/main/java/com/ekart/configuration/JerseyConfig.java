package com.ekart.configuration;

import com.ekart.account.resource.UserRegistrationResource;
import com.ekart.api.OrderResource;
import com.ekart.api.ProductResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by umam on 11/28/15.
 */
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(OrderResource.class);
        register(ProductResource.class);
        register(UserRegistrationResource.class);
    }
}
