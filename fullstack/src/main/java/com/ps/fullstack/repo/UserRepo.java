/**
 *
 @author Prabhash
 *  
 */
package com.ps.fullstack.repo;

import org.springframework.data.repository.CrudRepository;

import com.ps.fullstack.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	public Iterable<User> deleteByUserName(String userName);
	public User findByUserName(String username);
}
