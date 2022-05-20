package com.SpringApp.service;

import java.util.List;

import com.SpringApp.exception.CarAlreadyExistsException;
import com.SpringApp.model.Admin;

//interface created for admin
public interface AdminService {
		
		public Admin addCar(Admin adm) throws CarAlreadyExistsException; //method for adding car
		public List<Admin> getAllCars(); //method for getting the data
		public void deleteCarByid(int id); //method for deleting the data
		public Admin updateCar (Admin adm); //method for updating a data

	
}
