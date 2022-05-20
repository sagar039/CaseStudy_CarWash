package com.SpringApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringApp.exception.CarAlreadyExistsException;
import com.SpringApp.model.User;
import com.SpringApp.service.UserService;


@RestController
@RequestMapping("/api/v1")
public class UserController {
	private UserService usrServ;

	@Autowired
	public UserController(UserService usrServ) {
			this.usrServ = usrServ;
	}
	
	@PostMapping("/addcar")
	 public ResponseEntity<User> addUserCar(@RequestBody User usr ) throws CarAlreadyExistsException{
		User savedusr = usrServ.addUserCar(usr);
        return new ResponseEntity<>(savedusr, HttpStatus.CREATED);
    }
	
	@GetMapping("/getcar")
	public ResponseEntity<List<User>> getAllUserCar(){
        return new ResponseEntity<List<User>>((List<User>)usrServ.getAllUserCar(),HttpStatus.OK);
    }

}
