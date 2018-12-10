package com.example.cache.cachedemo;

import com.example.cache.cachedemo.model.Customer;
import com.example.cache.cachedemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
@EnableCaching
public class CacheDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CacheDemoApplication.class, args);
	}
	private final Logger logger = LoggerFactory.getLogger(getClass());


	private final CustomerRepository repository;

	@Autowired
	public CacheDemoApplication(CustomerRepository repository){
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList list = new ArrayList();
		list.add("cake");
		list.add("pepsi");
		logger.info("loading data "+repository.save(new Customer("rajeev", list)));
		logger.info("loading data "+repository.save(new Customer("Sachin", list)));
		logger.info("loading data "+repository.save(new Customer("Saurav", list)));
	}
}
