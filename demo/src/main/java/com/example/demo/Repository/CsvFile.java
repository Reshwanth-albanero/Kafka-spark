package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.net.UnknownServiceException;

public interface CsvFile extends MongoRepository<User,String> {
}
