package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {
	@Id
	private String userName;//Attributes
	private String passWord;	
	//Default Constructor
	public Users() {
		super();
}	
	public Users(String id, String userName, String passWord) {//Parameterized Constructor
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getUserName() {//Setters and Getters
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	
	@Override
	public String toString() {//ToString 
		return "User [userName=" + userName + ", passWord=" + passWord + "]";
	}	
}
