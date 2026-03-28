package com.example.demo.service;

import java.util.*;

import com.example.demo.entity.Loan;

public interface LoanService {
	Loan createLoan(Loan loan);
	List<Loan> getAllLoan();
	Loan getLoanById(Long id);
	Loan updateStatus(Long id, String status);
	
}
