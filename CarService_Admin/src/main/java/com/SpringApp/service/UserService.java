package com.SpringApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringApp.model.Users;
import com.SpringApp.repository.UserRepositiory;

//It is used to mark the class as a service provider. 
//So overall @Service annotation is used with classes that provide some business functionalities
//this class is a implementation of methods
@Service
public class UserService implements UserDetailsService {

	//it is used to inject the required depndencies to the class
	@Autowired
	private UserRepositiory userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByuserName(username);
		if(user==null)
			throw new UsernameNotFoundException(username, null);
		String usern=user.getUserName();
		String passwrd=user.getPassWord();
		return new User(usern,passwrd,new ArrayList<>());

}
}