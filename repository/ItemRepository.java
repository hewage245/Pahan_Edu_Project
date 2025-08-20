package com.example.PahanaEduProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.PahanaEduProject.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    // You can add custom query methods here if needed in the future
}
