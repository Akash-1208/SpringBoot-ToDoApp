package com.example.thymeleaf.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.thymeleaf.model.Task;

public interface TaskRepo extends MongoRepository<Task,String>{
    
}
