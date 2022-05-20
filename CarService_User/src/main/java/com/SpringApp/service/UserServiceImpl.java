package com.SpringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp.exception.CarAlreadyExistsException;
import com.SpringApp.model.User;
import com.SpringApp.repository.UserRepository;

//It is used to mark the class as a service provider. 
//So overall @Service annotation is used with classes that provide some business functionalities
//this class is a implementation of methods
@Service
public class UserServiceImpl implements UserService {
		
	private UserRepository usrRepo;
		// it is used to inject the required dependencies to the class
		@Autowired
		public UserServiceImpl(UserRepository usrRepo) {
			super();
			this.usrRepo = usrRepo;
		}

		@Override
		public User addUserCar(User usr) throws CarAlreadyExistsException{  //adding data
			// TODO Auto-generated method stub
			if(usrRepo.existsById(usr.getUserId())) {
				throw new CarAlreadyExistsException();
			}
			User savedUsr = usrRepo.save(usr);
			return savedUsr;
		}

		@Override
		public List<User> getAllUserCar() { //getting the data
			// TODO Auto-generated method stub
			return (List<User>) usrRepo.findAll();
		}
}
