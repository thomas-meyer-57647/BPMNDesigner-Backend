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
import com.metho.bpmndesigner.model.Color;
import com.metho.bpmndesigner.model.ColorStop;
import com.metho.bpmndesigner.model.EGradientType;
import com.metho.bpmndesigner.model.GradientEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the gradient service
 */
@SpringBootTest
class GradientServiceTest {
	
	@Autowired 
	GradientService gradientService;
	
	@Autowired 
	UserService userService;
	
	/**
	 * test create a gradient
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testCreateGradient() throws ResourceNotFoundException {
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
		
		// create Gradient
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "palette";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 1;
		int y2 = 2;
		int r2 = 3;
		ColorStop colorstop1 = new ColorStop(0.25, new Color(1));
		ColorStop colorstop2 = new ColorStop(0.5, new Color(255));
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		
		colorstops.add(colorstop1);
		colorstops.add(colorstop2);
		
		GradientEntity gradient = new GradientEntity(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		
		exception = false;
		try {
			gradientService.createGradient(user, gradient);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<GradientEntity> foundGradient = gradientService.findById(gradient.getId());
		
		assertTrue( foundGradient.isPresent() );
		
		assertEquals(user.getId(), foundGradient.get().getCreatedBy().getId());
		assertEquals(type, foundGradient.get().getGradientType());
		assertEquals(name, foundGradient.get().getName());
		assertEquals(idname, foundGradient.get().getIdname());
		assertEquals(x1, foundGradient.get().getX1());
		assertEquals(y1, foundGradient.get().getY1());
		assertEquals(r1, foundGradient.get().getR1());
		assertEquals(x2, foundGradient.get().getX2());
		assertEquals(y2, foundGradient.get().getY2());
		assertEquals(r2, foundGradient.get().getR2());
		
		// clean up
		gradientService.deleteGradient(gradient.getId());
		userService.deleteUser(user.getId());
	}
	
	/**
	 * test findByID
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindByID() throws ResourceNotFoundException {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "palette";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 1;
		int y2 = 2;
		int r2 = 3;
		ColorStop colorstop1 = new ColorStop(0.25, new Color(1));
		ColorStop colorstop2 = new ColorStop(0.5, new Color(255));
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		
		colorstops.add(colorstop1);
		colorstops.add(colorstop2);
		
		GradientEntity gradient = new GradientEntity(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		
		boolean exception = false;
		try {
			gradientService.createGradient(null, gradient);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<GradientEntity> foundGradient = gradientService.findById(gradient.getId());
		
		assertTrue( foundGradient.isPresent() );
		assertEquals(type, foundGradient.get().getGradientType() );
		assertEquals(name, foundGradient.get().getName() );
		assertEquals(idname, foundGradient.get().getIdname() );
		assertEquals(x1, foundGradient.get().getX1() );
		assertEquals(y1, foundGradient.get().getY1() );
		assertEquals(r1, foundGradient.get().getR1() );
		assertEquals(x2, foundGradient.get().getX2() );
		assertEquals(y2, foundGradient.get().getY2() );
		assertEquals(r2, foundGradient.get().getR2() );
		assertEquals(2, foundGradient.get().getColorStops().size() );
		assertEquals(colorstop1.getColor().getColorValue(), foundGradient.get().getColorStops().get(0).getColor().getColorValue() );
		assertEquals(colorstop1.getOffset(), foundGradient.get().getColorStops().get(0).getOffset() );
		assertEquals(colorstop2.getColor().getColorValue(), foundGradient.get().getColorStops().get(1).getColor().getColorValue() );
		assertEquals(colorstop2.getOffset(), foundGradient.get().getColorStops().get(1).getOffset() );
		
		// clean up
		gradientService.deleteGradient(gradient.getId());
	}
	
	/**
	 * test findByName
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testFindByName() throws ResourceNotFoundException {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "palette";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 1;
		int y2 = 2;
		int r2 = 3;
		ColorStop colorstop1 = new ColorStop(0.25, new Color(1));
		ColorStop colorstop2 = new ColorStop(0.5, new Color(255));
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		
		colorstops.add(colorstop1);
		colorstops.add(colorstop2);
		
		GradientEntity gradient = new GradientEntity(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		
		boolean exception = false;
		try {
			gradientService.createGradient(null, gradient);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<GradientEntity> foundGradient = gradientService.findByName(null, name);
		
		assertTrue( foundGradient.isPresent() );
		assertEquals(name, foundGradient.get().getName() );
		
		// clean up
		gradientService.deleteGradient(gradient.getId());
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
		
		// create gradient
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "palette";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 1;
		int y2 = 2;
		int r2 = 3;
		ColorStop colorstop1 = new ColorStop(0.25, new Color(1));
		ColorStop colorstop2 = new ColorStop(0.5, new Color(255));
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		
		colorstops.add(colorstop1);
		colorstops.add(colorstop2);
		
		GradientEntity gradient = new GradientEntity(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		
		exception = false;
		try {
			gradientService.createGradient(user, gradient);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		// update
		EGradientType type2 = EGradientType.RADIALGRADIENT;
		String name2 = "palette2";
		String idname2 = "idname2";
		int x1_2 = 9;
		int y1_2 = 8;
		int r1_2 = 7;
		int x2_2 = 6;
		int y2_2 = 5;
		int r2_2 = 4;
		ColorStop colorstop1_2 = new ColorStop(0.75, new Color(255));
		ColorStop colorstop2_2 = new ColorStop(0.25, new Color(1));
		List<ColorStop> colorstops2 = new ArrayList<ColorStop>();
		
		colorstops2.add(colorstop1_2);
		colorstops2.add(colorstop2_2);
		
		GradientEntity gradient2 = new GradientEntity(type2, name2, idname2, x1_2, y1_2, r1_2, x2_2, y2_2, r2_2, colorstops2);
		
		exception = false;
		try {
			gradientService.updateGradient(user, gradient.getId(), gradient2);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<GradientEntity> foundGradient = gradientService.findById(gradient.getId());
		
		assertTrue( foundGradient.isPresent() );
		assertEquals(user.getId(), foundGradient.get().getUpdatedBy().getId());
		assertEquals(type2, foundGradient.get().getGradientType() );
		assertEquals(name2, foundGradient.get().getName() );
		assertEquals(idname2, foundGradient.get().getIdname() );
		assertEquals(x1_2, foundGradient.get().getX1() );
		assertEquals(y1_2, foundGradient.get().getY1() );
		assertEquals(r1_2, foundGradient.get().getR1() );
		assertEquals(x2_2, foundGradient.get().getX2() );
		assertEquals(y2_2, foundGradient.get().getY2() );
		assertEquals(r2_2, foundGradient.get().getR2() );
		assertEquals(2, foundGradient.get().getColorStops().size() );
		assertEquals(colorstop1_2.getColor().getColorValue(), foundGradient.get().getColorStops().get(0).getColor().getColorValue() );
		assertEquals(colorstop1_2.getOffset(), foundGradient.get().getColorStops().get(0).getOffset() );
		assertEquals(colorstop2_2.getColor().getColorValue(), foundGradient.get().getColorStops().get(1).getColor().getColorValue() );
		assertEquals(colorstop2_2.getOffset(), foundGradient.get().getColorStops().get(1).getOffset() );
		
		// clean up
		gradientService.deleteGradient(gradient.getId());
		userService.deleteUser(user.getId());
	}	

	/**
	 * test delete
	 * 
	 * @throws ResourceNotFoundException 
	 */	
	@Test
	void testDelete() throws ResourceNotFoundException {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "palette";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 1;
		int y2 = 2;
		int r2 = 3;
		ColorStop colorstop1 = new ColorStop(0.25, new Color(1));
		ColorStop colorstop2 = new ColorStop(0.5, new Color(255));
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		
		colorstops.add(colorstop1);
		colorstops.add(colorstop2);
		
		GradientEntity gradient = new GradientEntity(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		
		boolean exception = false;
		try {
			gradientService.createGradient(null, gradient);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<GradientEntity> foundGradient = gradientService.findById(gradient.getId());
		assertTrue( foundGradient.isPresent() );
		
		// delete
		gradientService.deleteGradient(gradient.getId());

		Optional<GradientEntity> foundGradient2 = gradientService.findById(gradient.getId());
		assertFalse( foundGradient2.isPresent() );
	}	
}
