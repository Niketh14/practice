package com.myproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.execption.ResourceNotFoundException;
import com.myproject.model.TravelPackages;
import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.repository.PackageRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	private PackageRepository packagereposiory;
	
	//get all users
	@GetMapping("/user")
	public List<User>getAllUser(){
		return userRepository.findAll();
	}
	
	//create new user
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	

	
	//get employee by id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		User user= userRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException(
						"User not exist with id:"+ id));
		return ResponseEntity.ok(user);	
		
	}
	
	
	
	//update user 
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("users not exist with id :" + id));
		
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setPassword(userDetails.getPassword());
		user.setEmailId(userDetails.getEmailId());
		user.setMobilenum(userDetails.getMobilenum());
		user.setDate(userDetails.getDate());
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	



	//delete user
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
