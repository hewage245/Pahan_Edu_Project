package com.example.PahanaEduProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PahanaEduProject.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
}
