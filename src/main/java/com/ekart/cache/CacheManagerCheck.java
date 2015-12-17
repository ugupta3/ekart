package com.ekart.cache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by umam on 12/5/15.
 */@Component
   public class CacheManagerCheck implements  CommandLineRunner{


    private static final Logger logger = LoggerFactory
            .getLogger(CacheManagerCheck.class);

    private final CacheManager cacheManager;

    @Inject
    public CacheManagerCheck(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "=========================================================\n\n");
    }


}