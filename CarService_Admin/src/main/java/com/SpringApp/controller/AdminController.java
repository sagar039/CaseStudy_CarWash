package com.SpringApp.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.SpringApp.exception.CarAlreadyExistsException;
import com.SpringApp.model.Admin;
import com.SpringApp.service.AdminService;
   //RestController is a Spring annotation that is used to build REST API in a declarative way.
	@RestController  
	// It is used to map web requests onto specific handler classes and/or handler methods.
	@RequestMapping("/api/v1")
	public class AdminController {
		private AdminService admServ;
       //it is used to inject the required dependencies in a class
		@Autowired
		public AdminController(AdminService admServ) {
				this.admServ = admServ;
		}
		//it is used to add data from database
		@PostMapping("/car")
		 public ResponseEntity<Admin> addCar(@RequestBody Admin adm ) throws CarAlreadyExistsException{	
			Admin savedadm = admServ.addCar(adm);
	        return new ResponseEntity<>(savedadm, HttpStatus.CREATED);
	    }
		//it is used to get the data from database
		@GetMapping("/cars")
		public ResponseEntity<List<Admin>> getAllCars(){
	        return new ResponseEntity<List<Admin>>((List<Admin>)admServ.getAllCars(),HttpStatus.OK);
	    }
		//it is used to delete the data from database
		@DeleteMapping("/car/{id}")
		public ResponseEntity<Void> deleteCarById(@PathVariable int id){
	        admServ.deleteCarByid(id);
	        return ResponseEntity.noContent().build();
	    }
		//it is used to update the data
		@PutMapping("/update")
		public Admin updateCar(@RequestBody Admin adm) {
			return admServ.updateCar(adm);
		}
	}

