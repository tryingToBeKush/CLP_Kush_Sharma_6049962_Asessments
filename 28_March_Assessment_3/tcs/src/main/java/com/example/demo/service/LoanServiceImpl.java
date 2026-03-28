	package com.example.demo.service;
	
	import java.util.*;
	
	import org.springframework.stereotype.Service;
	
	import com.example.demo.entity.Loan;
	import com.example.demo.exception.DuplicateLoanApplicationException;
	import com.example.demo.exception.InvalidLoanAmountException;
	import com.example.demo.exception.LoanNotFoundException;
	import com.example.demo.respository.LoanRepository;
	
	@Service
	public class LoanServiceImpl implements LoanService{
		private LoanRepository repo;
		
		public LoanServiceImpl(LoanRepository repo) {
			this.repo = repo;
		}
		
		@Override
		public Loan createLoan(Loan loan) {
			if(loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000) {
				throw new InvalidLoanAmountException("Loan Amount must be between 1 and 50,00,000");
			}
			
			List<Loan> pendingLoans = repo.findByApplicantNameAndStatus(loan.getApplicantName(),"PENDING");
			
			if(!pendingLoans.isEmpty()) {
				throw new DuplicateLoanApplicationException("Applicant already has a pending loan application");
			}
			
			loan.setStatus("PENDING");
	
			return repo.save(loan);
		}
		
		@Override
		public Loan updateStatus(Long id, String status) {
			Loan loan = repo.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan Not Found"));
			
			loan.setStatus("APPROVED");
			return repo.save(loan);
		}
		
		@Override
		public List<Loan> getAllLoan(){
			return repo.findAll();
		}
		
		@Override
		public Loan getLoanById(Long id) {
			return repo.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan Not Found")); 
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
