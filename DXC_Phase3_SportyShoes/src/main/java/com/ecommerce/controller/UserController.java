package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.BusinessException;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	private MultiValueMap<String, String> map;
	
	public User authenticate(String user_id, String password) {
		
		return null;
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
	
		return service.addUser(user);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		
		return service.updateUser(user);
	}

    @GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK) ;
		} catch (BusinessException e) {
			map=new LinkedMultiValueMap<>() ;
			map.add("ErrorMessage", e.getMessage());
			return new ResponseEntity<>(null,map, HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable int id) {
		
		
	}

    @GetMapping("/users")
	public List<User> getAllUsers() {
		
		return service.getAllUsers();
	}

    @GetMapping("/user/age/{age}")
	public List<User> getAllUsersByAge(@PathVariable int age) {
		
		return service.getAllUsersByAge(age);
	}
	
	
}