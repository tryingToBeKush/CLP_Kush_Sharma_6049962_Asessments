package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DuplicateLoanApplicationException.class)
	public ErrorResponse handleDuplicate(DuplicateLoanApplicationException ex) {
		return new ErrorResponse("DuplicateLoanApplicationException", ex.getMessage(), LocalDateTime.now());
	}
	
	@ExceptionHandler(InvalidLoanAmountException.class)
	public ErrorResponse handleInvalidAmount(InvalidLoanAmountException ex) {
		return new ErrorResponse("InvalidLoanAmountException", ex.getMessage(), LocalDateTime.now());
	}
	
	@ExceptionHandler(LoanNotFoundException.class)
	public ErrorResponse handleLoanNotFound(LoanNotFoundException ex) {
		return new ErrorResponse("LoanNotFoundExceptioni", ex.getMessage(), LocalDateTime.now());
	}
}

