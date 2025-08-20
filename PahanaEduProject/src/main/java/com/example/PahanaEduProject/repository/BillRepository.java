package com.example.PahanaEduProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PahanaEduProject.model.Bill;


public interface BillRepository extends MongoRepository<Bill, String> {
}
