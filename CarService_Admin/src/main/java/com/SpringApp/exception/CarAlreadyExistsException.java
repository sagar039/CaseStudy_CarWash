package com.SpringApp.exception;

//here we are create custom exception for our service
public class CarAlreadyExistsException extends Exception {
		private static final long serialVersionUID = 1L;
		public CarAlreadyExistsException() {
			super();
}
		public CarAlreadyExistsException(String message) {
		super(message);
		}
}
	
