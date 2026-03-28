package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Loan;
import com.example.demo.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
    private LoanService service;

    public LoanController(LoanService service) {

        this.service = service;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {

        return service.createLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {

        return service.getAllLoan();
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable Long id) {

        return service.getLoanById(id);
    }

    @PutMapping("/{id}/status")
    public Loan updateStatus(@PathVariable Long id, @RequestBody Loan loan) {

        return service.updateStatus(id, loan.getStatus());
    }
}