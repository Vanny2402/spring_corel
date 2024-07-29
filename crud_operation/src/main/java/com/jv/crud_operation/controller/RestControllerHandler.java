package com.jv.crud_operation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.response.error.ErrorResponse;

@RestControllerAdvice
public class RestControllerHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobleexcException(Exception ex){
		ErrorResponse err=new ErrorResponse(ex.getMessage(),(short)500);
//		Map<String,Object> mapData=new HashMap<>();
//		mapData.put("message",ex.getMessage());
//		mapData.put("Staus", 500);
//		return ResponseEntity.status(500).body(mapData);
		return ResponseEntity.status(500).body(err);
	}
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ErrorResponse>handlerAlreadyExistException(AlreadyExistException ex){
		ErrorResponse err=new ErrorResponse(ex.getMessage(),(short) 409);
		return ResponseEntity.status(409).body(err);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex){
		ErrorResponse err=new ErrorResponse(ex.getMessage(),(short) 404);
		return ResponseEntity.status(404).body(err);
	}

}
