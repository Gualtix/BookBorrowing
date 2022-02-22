package com.appllication.teluslibrary.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.appllication.teluslibrary.util.UserRole;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastName;

	private Long nbooks;
	
	private String email;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Loan> loans;
}
