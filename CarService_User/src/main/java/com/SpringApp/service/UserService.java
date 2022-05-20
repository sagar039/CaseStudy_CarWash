package com.SpringApp.service;

import java.util.List;

import com.SpringApp.exception.CarAlreadyExistsException;
import com.SpringApp.model.User;

//interface created for user
public interface UserService {
	public User addUserCar(User usr) throws CarAlreadyExistsException; //adding a data
	public List<User> getAllUserCar(); //getting the data
	
}
