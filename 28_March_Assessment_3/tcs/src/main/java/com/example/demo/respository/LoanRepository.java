package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Loan;

import java.util.*;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByApplicantNameAndStatus(String applicantName, String status);
}