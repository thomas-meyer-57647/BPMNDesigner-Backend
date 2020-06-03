package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.LineDashEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the line dash service
 */
@SpringBootTest
class LineDashServiceTest {
	
	@Autowired 
	LineDashService linedashService;
	
	@Autowired 
	UserService userService;
	
	/**
	 * test create a line dash in the database
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testCreateLineDash() throws ResourceNotFoundException {
		boolean exception = false;
		
		// create User
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		assertTrue( foundUser.isPresent() );
		
		// create LineDash
		String name = "linedash";
		List<Integer> segments = new ArrayList<Integer>();
		
		segments.add(1);
		segments.add(2);
		
		LineDashEntity linedash = new LineDashEntity(name, segments);
		
		exception = false;
		try {
			linedashService.createLineDash(user, linedash);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<LineDashEntity> foundLineDash = linedashService.findById(linedash.getId());
		assertTrue( foundLineDash.isPresent() );
		
		assertEquals(user.getId(), foundLineDash.get().getCreatedBy().getId());
		assertEquals(name, foundLineDash.get().getName());
		assertEquals(segments.size(), foundLineDash.get().getSegments().size());
		assertEquals(segments.get(0), foundLineDash.get().getSegments().get(0));
		assertEquals(segments.get(1), foundLineDash.get().getSegments().get(1));
		
		// clean up
		linedashService.deleteLineDash(linedash.getId());
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findByID
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindByID() throws ResourceNotFoundException {
		boolean exception = false;
		
		// create User
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		assertTrue( foundUser.isPresent() );
		
		// create LineDash
		String name = "linedash";
		List<Integer> segments = new ArrayList<Integer>();
		
		segments.add(1);
		segments.add(2);
		
		LineDashEntity linedash = new LineDashEntity(name, segments);
		
		exception = false;
		try {
			linedashService.createLineDash(user, linedash);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);

		Optional<LineDashEntity> foundLineDash = linedashService.findById(linedash.getId());
		assertTrue( foundLineDash.isPresent() );
		
		// clean up
		linedashService.deleteLineDash(linedash.getId());
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findByName
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindByName() throws ResourceNotFoundException {
		boolean exception = false;
		
		// create User
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		assertTrue( foundUser.isPresent() );
		
		// create LineDash
		String name = "linedash";
		List<Integer> segments = new ArrayList<Integer>();
		
		segments.add(1);
		segments.add(2);
		
		LineDashEntity linedash = new LineDashEntity(name, segments);
		
		exception = false;
		try {
			linedashService.createLineDash(user, linedash);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);

		Optional<LineDashEntity> foundLineDash = linedashService.findByName(user, name);
		assertTrue( foundLineDash.isPresent() );
		
		// clean up
		linedashService.deleteLineDash(linedash.getId());
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test update
	 * 
	 * @throws ResourceNotFoundException 
	 */	
	@Test
	void testUpdate() throws ResourceNotFoundException {
		boolean exception = false;
		
		// create User
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		assertTrue( foundUser.isPresent() );
		
		// create LineDash
		String name = "linedash";
		List<Integer> segments = new ArrayList<Integer>();
		
		segments.add(1);
		segments.add(2);
		
		LineDashEntity linedash = new LineDashEntity(name, segments);
		
		exception = false;
		try {
			linedashService.createLineDash(user, linedash);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);

		Optional<LineDashEntity> foundLineDash = linedashService.findById(linedash.getId());
		assertTrue( foundLineDash.isPresent() );
		
		// update LineDash
		String name2 = "lineDash2";

		List<Integer> segments2 = new ArrayList<Integer>();
		
		segments2.add(3);
		segments2.add(4);
		
		LineDashEntity linedash2 = new LineDashEntity(name2, segments2);

		exception = false;
		try {
			linedashService.updateLineDash(user, foundLineDash.get().getId(), linedash2);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);

		Optional<LineDashEntity> foundLineDash2 = linedashService.findById(linedash.getId());

		assertEquals(user.getId(), foundLineDash2.get().getCreatedBy().getId());
		assertEquals(name2, foundLineDash2.get().getName());
		assertEquals(segments2.size(), foundLineDash2.get().getSegments().size());
		assertEquals(segments2.get(0), foundLineDash2.get().getSegments().get(0));
		assertEquals(segments2.get(1), foundLineDash2.get().getSegments().get(1));
		
		// clean up
		linedashService.deleteLineDash(linedash.getId());
		userService.deleteUser(user.getId());
	}	

	/**
	 * test delete
	 * 
	 * @throws ResourceNotFoundException 
	 */	
	@Test
	void testDelete() throws ResourceNotFoundException {
		boolean exception = false;
		
		// create User
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
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
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		assertTrue( foundUser.isPresent() );
		
		// create LineDash
		String name = "linedash";
		List<Integer> segments = new ArrayList<Integer>();
		
		segments.add(1);
		segments.add(2);
		
		LineDashEntity linedash = new LineDashEntity(name, segments);
		
		exception = false;
		try {
			linedashService.createLineDash(user, linedash);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);

		Optional<LineDashEntity> foundLineDash = linedashService.findById(linedash.getId());
		assertTrue( foundLineDash.isPresent() );
		
		// delete
		linedashService.deleteLineDash(linedash.getId());

		Optional<LineDashEntity> foundLineDash2 = linedashService.findById(linedash.getId());
		assertFalse( foundLineDash2.isPresent() );
		
		userService.deleteUser(user.getId());
	}	
}