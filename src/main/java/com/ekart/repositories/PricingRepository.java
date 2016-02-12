package com.ekart.repositories;

import com.ekart.entity.Pricing;
import com.ekart.entity.MerchantProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by santhosh on 8/12/2015.
 */

public interface PricingRepository extends JpaRepository<Pricing, MerchantProductKey> {


}
