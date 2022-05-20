package com.SpringApp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.SpringApp.model.User;
//The @SpringBootTest annotation is useful when we need to bootstrap the entire container.
//SpringExtension integrates the Spring TestContext Framework into JUnit 5's Jupiter programming model.
	@SpringBootTest
	@ExtendWith(SpringExtension.class)
	class UserRepositoryTest {
		@Autowired
		private UserRepository usrRepo;
		//@Test annotation tells JUnit that this public void method (Test Case here) to which it is attached can be run as a test case.
		@Test
		public void givenUserShouldReturnUserObject() {
			User u1=new User(101,"samar","BR01FN0341","gopalganj");
			usrRepo.save(u1);
			User u2=usrRepo.findById(u1.getUserId()).get();
			assertNotNull(u2);
			assertEquals(u1.getUserName(),u2.getUserName());
				}
		@Test
		public void getAllmustReturnAllUserCar() {
			User u3=new User(102,"harsh","BR28L1527","gopalganj");
			User u4=new User(103,"dev","BR01FN0001","gopalganj");
			usrRepo.save(u3);
			usrRepo.save(u4);
			List<User>usrList=(List<User>)usrRepo.findAll();
			assertEquals("dev", usrList.get(0).getUserName());
		}	     
	}

