/**
 *
 @author Prabhash
 *  
 */
package com.ps.fullstack.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.fullstack.customException.ResourceNotFoundException;
import com.ps.fullstack.entity.User;
import com.ps.fullstack.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	//Register user
	@Transactional
	public User registerUser(User user) {
		return repo.save(user);
	}

	@Transactional
	public Iterable<User> getAllUser() {
		return repo.findAll();
	}
	
	@Transactional
	public Iterable<User> deleteByUserName(String userName){
		return repo.deleteByUserName(userName);
	}

	@Transactional
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public User findByUserName(String username) {
		User user=repo.findByUserName(username);
		if(user==null)
			throw new ResourceNotFoundException("Resource not found");
		return repo.findByUserName(username);
		
	}
}
