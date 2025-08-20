package com.example.PahanaEduProject.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.PahanaEduProject.model.Customer;
import com.example.PahanaEduProject.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins="*")
public class CustomerApiController {

    private final CustomerRepository repo;

    public CustomerApiController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer c) {
        return repo.save(c);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer c) {
        c.setId(id);
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        repo.deleteById(id);
    }
}
