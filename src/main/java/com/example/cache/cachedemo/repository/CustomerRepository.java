package com.example.cache.cachedemo.repository;

import com.example.cache.cachedemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
