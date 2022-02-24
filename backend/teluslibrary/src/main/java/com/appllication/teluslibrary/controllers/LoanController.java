package com.appllication.teluslibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> main
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appllication.teluslibrary.entities.Loan;
import com.appllication.teluslibrary.payload.createLoanDto;
import com.appllication.teluslibrary.payload.updateLoanDto;
import com.appllication.teluslibrary.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	LoanService ls;
	
	@PostMapping
	public ResponseEntity<Loan> createLoan(@RequestBody createLoanDto loanDto) {
		return new ResponseEntity<>(ls.createLoan(loanDto), HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<Loan> updateLoan(@RequestBody updateLoanDto loanDto) {
		return new ResponseEntity<>(ls.updateLoan(loanDto), HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Loan> getLoan(@PathVariable Long id) {
		return new ResponseEntity<>(ls.getLoan(id), HttpStatus.OK);
	}
}