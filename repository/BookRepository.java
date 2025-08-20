package com.example.PahanaEduProject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PahanaEduProject.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByCategory(String category);
}
