package com.example.PahanaEduProject.repository;

import com.example.PahanaEduProject.model.RequestForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestFormRepository extends MongoRepository<RequestForm, String> {}
