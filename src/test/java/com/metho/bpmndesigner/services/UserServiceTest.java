package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the user service
 */
@SpringBootTest
class UserServiceTest {

	@Autowired 
	UserService userService;
	
	/**
	 * test create
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testCreate() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());

		// clean up
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findByEmailAndPassword
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindByEmailAndPassword() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
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
		
		Optional<UserEntity> foundUser = userService.findByEmailAndPassword(email, password);
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());

		// clean up
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findByEmail
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindByEmail() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
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
		
		Optional<UserEntity> foundUser = userService.findByEmail(email);
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());

		// clean up
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findById
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindById() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());

		// clean up
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findBySecret
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindBySecret() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		String secret = "!1a2b3c#";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setSecret(secret);
		
		try {
			userService.createUser(null, user);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
		
		Optional<UserEntity> foundUser = userService.findBySecret(secret);
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());

		// clean up
		userService.deleteUser(user.getId());
	}

	/**
	 * test update
	 * @throws ResourceNotFoundException 
	 */	
	@Test
	void testUpdate() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		String secret = "!1a2b3c#";
		
		String updaterFirstname = "thomas";
		String updaterLastname = "Updater";
		String updaterEmail = "thomas.meyer.67747@gmail.com";
		String updaterPassword = "a other password";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);

		UserEntity updaterUser = new UserEntity();
		
		updaterUser.setFirstname(updaterFirstname);
		updaterUser.setLastname(updaterLastname);
		updaterUser.setEmail(updaterEmail);
		updaterUser.setPassword(updaterPassword);
		
		// create updater
		try {
			userService.createUser(null, updaterUser);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
	
		// create user
		try {
			userService.createUser(updaterUser, user);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
		
		// update user
		user.setSecret(secret);
		
		try {
			userService.updateUser(updaterUser, user.getId(), user);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		
		assertTrue( foundUser.isPresent() );
		
		assertEquals(firstname, foundUser.get().getFirstname());
		assertEquals(lastname, foundUser.get().getLastname());
		assertEquals(email, foundUser.get().getEmail());
		assertEquals(password, foundUser.get().getPassword());
		assertEquals(secret, foundUser.get().getSecret());

		// clean up
		userService.deleteUser(user.getId());
		userService.deleteUser(updaterUser.getId());
	}	
	
	/**
	 * test delete
	 * @throws ResourceNotFoundException 
	 */	
	@Test
	void testDelete() throws ResourceNotFoundException {
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		boolean exception = false;
		UserEntity user = new UserEntity();
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		
		// create user
		try {
			userService.createUser(null, user);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);

		// delete
		userService.deleteUser(user.getId());

		Optional<UserEntity> foundUser = userService.findById(user.getId());
		
		assertFalse( foundUser.isPresent() );
	}	
}
