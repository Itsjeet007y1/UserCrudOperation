package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

/*
 * UserRepository extending MongoRepository to avail database connectivity through mongodb
 */
@Repository // Generic annotation for dao layer
public interface UserRepository extends MongoRepository<User, String> {
	public int deleteByUserId(String userId); // custom method to delete user by id
}
