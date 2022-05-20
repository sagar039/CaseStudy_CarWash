package com.SpringApp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.SpringApp.model.Admin;
//The @SpringBootTest annotation is useful when we need to bootstrap the entire container.
//SpringExtension integrates the Spring TestContext Framework into JUnit 5's Jupiter programming model.
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AdminRepositoryTest {
		@Autowired
		private AdminRepository admRepo;
		//@Test annotation tells JUnit that this public void method (Test Case here) to which it is attached can be run as a test case.
		@Test
		public void givenUserShouldReturnUserObject() {
			Admin u1=new Admin(101,"samar","BR01FN0341","gopalganj");
			admRepo.save(u1);
			Admin u2=admRepo.findById(u1.getUserId()).get();
			assertNotNull(u2);
			assertEquals(u1.getUserName(),u2.getUserName());
				}
		@Test
		public void getAllmustReturnAllUserCar() {
			Admin u3=new Admin(102,"harsh","BR28L1527","gopalganj");
			Admin u4=new Admin(103,"dev","BR01FN0001","gopalganj");
			admRepo.save(u3);
			admRepo.save(u4);
			List<Admin>usrList=(List<Admin>)admRepo.findAll();
			assertEquals("dev", usrList.get(0).getUserName());
		}	
}
