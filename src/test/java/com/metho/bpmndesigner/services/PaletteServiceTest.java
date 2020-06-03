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
import com.metho.bpmndesigner.model.PaletteEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the palette service
 */
@SpringBootTest
class PaletteServiceTest {
	
	@Autowired 
	PaletteService paletteService;

	@Autowired 
	UserService userService;
	
	/**
	 * test create a palette
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testCreate() throws ResourceNotFoundException {
		boolean exception = false;

		// create user
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

		// create palette
		String name = "palette";
		Color color1 = new Color(1);
		Color color2 = new Color(255);
		List<Color> colors = new ArrayList<Color>();
		
		colors.add(color1);
		colors.add(color2);
		
		PaletteEntity palette = new PaletteEntity(name, colors);
		
		try {
			paletteService.createPalette(user, palette);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<PaletteEntity> foundPalette = paletteService.findById(palette.getId());
		
		assertTrue( foundPalette.isPresent() );
		assertEquals(user.getId(), foundPalette.get().getCreatedBy().getId());
		assertEquals(name, foundPalette.get().getName());
		assertEquals(color1.getColorValue(), foundPalette.get().getColors().get(0).getColorValue());
		assertEquals(color2.getColorValue(), foundPalette.get().getColors().get(1).getColorValue());

		// clean up
		paletteService.deletePalette(palette.getId());
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

		// create user
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

		// create palette
		String name = "palette";
		Color color1 = new Color(1);
		Color color2 = new Color(255);
		List<Color> colors = new ArrayList<Color>();
		
		colors.add(color1);
		colors.add(color2);
		
		PaletteEntity palette = new PaletteEntity(name, colors);
		
		try {
			paletteService.createPalette(user, palette);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<PaletteEntity> foundPalette = paletteService.findById(palette.getId());
		assertTrue( foundPalette.isPresent() );

		assertEquals(palette.getId(), foundPalette.get().getId());
		assertEquals(palette.getName(), foundPalette.get().getName());
		
		// clean up
		paletteService.deletePalette(palette.getId());
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

		// create user
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

		// create palette
		String name = "palette";
		Color color1 = new Color(1);
		Color color2 = new Color(255);
		List<Color> colors = new ArrayList<Color>();
		
		colors.add(color1);
		colors.add(color2);
		
		PaletteEntity palette = new PaletteEntity(name, colors);
		
		try {
			paletteService.createPalette(user, palette);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<PaletteEntity> foundPalette = paletteService.findByName(user, palette.getName());
		assertTrue( foundPalette.isPresent() );

		assertEquals(palette.getId(), foundPalette.get().getId());
		assertEquals(palette.getName(), foundPalette.get().getName());
		
		// clean up
		paletteService.deletePalette(palette.getId());
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

		// create user
		String firstname = "thomas";
		String lastname = "meyer";
		String email = "thomas.meyer.67647@gmail.com";
		String password = "a password";
		
		UserEntity user = new UserEntity();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);

		exception = false;
		try {
			userService.createUser(null, user);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<UserEntity> foundUser = userService.findById(user.getId());
		assertTrue( foundUser.isPresent() );

		// create palette
		String name = "palette";
		Color color1 = new Color(1);
		Color color2 = new Color(255);
		List<Color> colors = new ArrayList<Color>();
		
		colors.add(color1);
		colors.add(color2);
		
		PaletteEntity palette = new PaletteEntity(name, colors);
		
		exception = false;
		try {
			paletteService.createPalette(user, palette);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<PaletteEntity> foundPalette = paletteService.findById(palette.getId());
		assertTrue( foundPalette.isPresent() );

		// update palette
		String name2 = "palette";
		Color color1_2 = new Color(64);
		Color color2_2 = new Color(128);
		List<Color> colors2 = new ArrayList<Color>();
		
		colors2.add(color1_2);
		colors2.add(color2_2);
		
		PaletteEntity palette2 = new PaletteEntity(name2, colors2);

		exception = false;
		try {
			paletteService.updatePalette(user, palette.getId(), palette2);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<PaletteEntity> foundPalette2 = paletteService.findById(palette.getId());
		
		assertTrue( foundPalette2.isPresent() );
		assertEquals(user.getId(), foundPalette2.get().getUpdatedBy().getId());
		assertEquals(name2, foundPalette2.get().getName());
		assertEquals(color1_2.getColorValue(), foundPalette2.get().getColors().get(0).getColorValue());
		assertEquals(color2_2.getColorValue(), foundPalette2.get().getColors().get(1).getColorValue());

		// clean up
		paletteService.deletePalette(palette.getId());
		userService.deleteUser(user.getId());
	}	

	/**
	 * test delete
	 * 
	 * @throws ResourceNotFoundException 
	 */	
	@Test
	void testDelete() throws ResourceNotFoundException {
		
		String name = "palette";
		
		Color color1 = new Color(1);
		Color color2 = new Color(255);
		List<Color> colors = new ArrayList<Color>();
		
		colors.add(color1);
		colors.add(color2);

		PaletteEntity palette = new PaletteEntity(name, colors);
		
		boolean exception = false;
		try {
			paletteService.createPalette(null, palette);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		// delete
		paletteService.deletePalette(palette.getId());

		Optional<PaletteEntity> foundUser = paletteService.findById(palette.getId());
		
		assertFalse( foundUser.isPresent() );
	}	
}
