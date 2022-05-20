package com.SpringApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.SpringApp.model.User;
import com.SpringApp.repository.UserRepository;
//The @SpringBootTest annotation is useful when we need to bootstrap the entire container.
//SpringExtension integrates the Spring TestContext Framework into JUnit 5's Jupiter programming model.
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

//@Mock: It is used to mock the objects that helps in minimizing the repetitive mock objects. 
@Mock
private UserRepository pr;
//@InjectMocks is the Mockito Annotation. It allows you to mark a field on which an injection is to be performed.
 @InjectMocks //used in implementation layer
private UserServiceImpl asl;
 //@Test annotation tells JUnit that this public void method (Test Case here) to which it is attached can be run as a test case.
 @Test
public void testGetAllUser()
{
User p1=new User(101,"samar","BR01FN0341","gopalganj"); // user input
User p2=new User(102,"harsh","BR28L1527","gopalganj"); //user input
User p3=new User(103,"dev","BR01FN0001","gopalganj"); //user input
pr.save(p1); //data saved to database
pr.save(p2); //data saved to database
pr.save(p3); //data saved to database

List<User> plist=new ArrayList<>(); // crating list object
plist.add(p1);
plist.add(p2);
plist.add(p3);

when(pr.findAll()).thenReturn(plist); // return student list
List<User> plist1 = asl.getAllUserCar();
assertEquals(plist, plist1); //checking both objects are equal
verify(pr,times(1)).save(p1);
verify(pr,times(1)).findAll();

}
}