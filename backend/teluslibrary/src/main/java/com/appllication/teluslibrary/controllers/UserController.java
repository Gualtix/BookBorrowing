package com.appllication.teluslibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appllication.teluslibrary.entities.User;
import com.appllication.teluslibrary.payload.CreateUserDto;
import com.appllication.teluslibrary.payload.UserDto;
import com.appllication.teluslibrary.services.UserService;

import lombok.Setter;

@RestController
@Setter
public class UserController {
	@Autowired
	UserService us;
	
	@GetMapping("/users")
	public List<UserDto> getUsers(){
		return us.getUsers();
	}
	@PostMapping("/users")
	public UserDto createUser(@RequestBody CreateUserDto userDto) {
		return us.createUser(userDto);
	}
	@PutMapping("/users")
	public UserDto updateUser(@RequestBody User user) {
		return us.updateUser(user);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		try {
			UserDto user = us.getUser(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return us.deleteUser(id);
	}
}
