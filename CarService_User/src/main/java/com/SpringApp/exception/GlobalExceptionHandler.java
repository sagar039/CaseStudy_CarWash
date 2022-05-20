package com.SpringApp.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//When using the Global Exception Handler with a project that includes a Try Catch, make sure to group activities into a Sequence inside the Try container. 
//Otherwise, the Global Exception Handler does not execute.
public class GlobalExceptionHandler {
	//@Value is used to automatically assign a value from multiple environment such as spring environment, system environment,
	@Value(value="${data.exception.msg}")
	private String msg;
    //@ExceptionHandler is an annotation for handling exceptions in specific handler classes or handler methods.
	@ExceptionHandler(value = CarAlreadyExistsException.class)
	public ResponseEntity<String> CarAlreadyExistsException(CarAlreadyExistsException cae)
	{
	return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
	}

}
