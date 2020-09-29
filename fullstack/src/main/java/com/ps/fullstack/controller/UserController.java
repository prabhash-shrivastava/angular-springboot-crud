/**
 *
 @author Prabhash
 *  
 */
package com.ps.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.fullstack.entity.User;
import com.ps.fullstack.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value={"/home","/","/index"})
	public String loginCheck() {
		return "Welcome!";
	}
	
	//Register User
	@PostMapping(value="/registerUser")
	public String registerUser(@RequestBody User user) {
		service.registerUser(user);
		return "Hello "+user.getUserName() +" you have been registered successfully!";
	}
	
	@GetMapping(value="/getAllUsers")
	public Iterable<User> getAllUser() {
		return service.getAllUser();
		
	}
	
	@DeleteMapping(value="/deleteByUsername/{username}")
	public Iterable<User> deleteByUserName(@PathVariable("username")String userName){
		 service.deleteByUserName(userName);
		 return service.getAllUser();
	}
	
	@PutMapping(value="/updateUser")
	public User updateUser(@RequestBody User user) {
//		return service.updateUser(user);
		return null;
	}
	
	@GetMapping(value="/findByUsername/{username}")
	public User findByUserName(@PathVariable("username") String username) {
		return service.findByUserName(username);
	}
	
}
