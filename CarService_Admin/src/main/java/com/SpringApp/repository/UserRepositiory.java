package com.SpringApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.SpringApp.model.Users;

//in this layer 
//A repository is a mechanism for encapsulating storage, retrieval,
//and search behavior which emulates a collection of objects.
//it extends mongo repository interface
public interface UserRepositiory extends MongoRepository<Users, String> {
	Users findByuserName(String userName);
}
