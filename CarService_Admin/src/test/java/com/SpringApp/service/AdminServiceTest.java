package com.SpringApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.SpringApp.model.Admin;
import com.SpringApp.repository.AdminRepository;
//The @SpringBootTest annotation is useful when we need to bootstrap the entire container.
//SpringExtension integrates the Spring TestContext Framework into JUnit 5's Jupiter programming model.
	@SpringBootTest
	@ExtendWith(MockitoExtension.class)
	class AdminServiceTest {
	//@Mock: It is used to mock the objects that helps in minimizing the repetitive mock objects.
	@Mock
	private AdminRepository ar;
	//@InjectMocks is the Mockito Annotation. It allows you to mark a field on which an injection is to be performed.
	 @InjectMocks //used in implementation layer
	private AdminServiceImpl asl;
	//@Test annotation tells JUnit that this public void method (Test Case here) to which it is attached can be run as a test case.
	 @Test
	public void testGetAllUser()
	{
	Admin a1=new Admin(101,"samar","BR01FN0341","gopalganj"); // user input
	Admin a2=new Admin(102,"harsh","BR28L1527","gopalganj"); //user input
	Admin a3=new Admin(103,"dev","BR28A0001","gopalganj"); //user input
	ar.save(a1); //data saved to database
	ar.save(a2); //data saved to database
	ar.save(a3); //data saved to database
	List<Admin> alist=new ArrayList<>(); // creating list object
	alist.add(a1);
	alist.add(a2);
	alist.add(a3);
	when(ar.findAll()).thenReturn(alist); // return student list
	List<Admin> alist1 = asl.getAllCars();
	assertEquals(alist, alist1); //checking both objects are equal
	verify(ar,times(1)).save(a1);
	verify(ar,times(1)).findAll();
	}
}

