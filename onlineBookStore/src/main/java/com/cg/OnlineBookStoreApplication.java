package com.cg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineBookStoreApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OnlineBookStoreApplication.class);
	 
    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
         
        LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
    }

}
