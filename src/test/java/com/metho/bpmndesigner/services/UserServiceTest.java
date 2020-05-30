package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.User;

/**
 * test function for the user service
 */
@SpringBootTest
class UserServiceTest {

	@Autowired 
	UserService userService;
	
	/**
	 * test create
	 */
	@Test
	void testCreate() {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		boolean exception = false;
		User user = new User();
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			userService.createUser(null, user);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
		
		Optional<User> foundUser = userService.findById(user.getId());
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());
		
	}

}
