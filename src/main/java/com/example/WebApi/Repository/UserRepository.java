package com.example.WebApi.Repository;

import com.example.WebApi.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
