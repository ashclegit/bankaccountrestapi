package io.accountmanagementsystem.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import io.accountmanagementsystem.exception.AccountNotFoundException;
import io.accountmanagementsystem.exception.ErrorResponse;
import io.accountmanagementsystem.exception.InsuffecientFundsException;
import io.accountmanagementsystem.exception.InvalidAmountException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(AccountNotFoundException.class)
	  public final ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(),request.getDescription(false));
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsuffecientFundsException.class)
	  public final ResponseEntity<ErrorResponse> handleInsuffecientFundsException(InsuffecientFundsException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(),request.getDescription(false));
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidAmountException.class)
	  public final ResponseEntity<ErrorResponse> handleInvalidAmountException(InvalidAmountException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(),request.getDescription(false));
	    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}