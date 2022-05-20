package com.SpringApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document is an annotation provided by Spring data project. 
//It is used to identify a domain object, which is persisted to MongoDB.
@Document(collection="User")
public class User {
	//@Id annotation specifies the primary key of an entity
	
    //in model class we have created default, parameterized constructor,to string,getter and setters
	@Id
	private int userId;
	private String userName;
	private String userCar; 
	private String userAddress;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String userCar, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userCar = userCar;
		this.userAddress = userAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCar() {
		return userCar;
	}
	public void setUserCar(String userCar) {
		this.userCar = userCar;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userCar=" + userCar + ", userAddress="
				+ userAddress + "]";
	}
}
