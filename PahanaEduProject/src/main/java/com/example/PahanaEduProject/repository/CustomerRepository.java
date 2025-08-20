package com.example.PahanaEduProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PahanaEduProject.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    
    // Find a customer by their account number
    Customer findByAccountNumber(String accountNumber);
    
    // You can add more query methods if needed
    // Example: List<Customer> findByNameContaining(String name);
}
