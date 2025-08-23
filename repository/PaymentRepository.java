package com.example.PahanaEduProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.PahanaEduProject.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
