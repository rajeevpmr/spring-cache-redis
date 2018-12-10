package com.example.cache.cachedemo.controller;

import com.example.cache.cachedemo.model.Customer;
import com.example.cache.cachedemo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    @Cacheable(value = "customers", key = "#customerId")
    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET)
    public Optional<Customer> getCustomer(@PathVariable String customerId) {

        logger.info("Retrieving customer details for "+ customerId);

        return repository.findById(Long.valueOf(customerId));


    }

    @CachePut(value = "customers", key = "#customer.id")
    @PostMapping("/")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        logger.info("Saving details for "+ newCustomer.getName());
        return repository.save(newCustomer);
    }

    private class CustomerNotFoundException extends RuntimeException {
        CustomerNotFoundException(String customerId){
            super("Could not find customer "+customerId);
        }
    }

    @RequestMapping("/")
    public List<String> getDefault(){

        List<String> defaultNames = new ArrayList<>();
        defaultNames.add("John");
        defaultNames.add("Mark");
        return defaultNames;
    }
}
