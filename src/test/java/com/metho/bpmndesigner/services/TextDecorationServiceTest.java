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
import com.metho.bpmndesigner.model.ETextAlign;
import com.metho.bpmndesigner.model.ETextBaseline;
import com.metho.bpmndesigner.model.ETextDirection;
import com.metho.bpmndesigner.model.Matrix;
import com.metho.bpmndesigner.model.TextDecorationEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the text decoration service
 */
@SpringBootTest
class TextDecorationServiceTest {
	@Autowired 
	TextDecorationService textdecorationService;
	
	@Autowired 
	UserService userService;
	
	/**
	 * test create a text decoration
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testCreateTextDecoration() throws ResourceNotFoundException {
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
		String name = "a text decoration";
		Matrix matrix = new Matrix();
		
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		String font = "a font";
		ETextAlign align = ETextAlign.CENTER;
		ETextBaseline baseline = ETextBaseline.IDEOGRAPHIC;
		ETextDirection direction = ETextDirection.LTR;
		
		TextDecorationEntity textdecoration = new TextDecorationEntity();

		textdecoration.setName(name);
		textdecoration.setMatrix(matrix);
		textdecoration.setFont(font);
		textdecoration.setAlign(align);
		textdecoration.setBaseline(baseline);
		textdecoration.setDirection(direction);
		
		exception = false;
		try {
			textdecorationService.createTextDecoration(user, textdecoration);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<TextDecorationEntity> foundTextDecoration = textdecorationService.findById(textdecoration.getId());
		
		assertTrue( foundTextDecoration.isPresent() );
		
		assertEquals(user.getId(), foundTextDecoration.get().getCreatedBy().getId());
		assertEquals(matrix, foundTextDecoration.get().getMatrix());
		assertEquals(name, foundTextDecoration.get().getName());
		assertEquals(font, foundTextDecoration.get().getFont());
		assertEquals(align, foundTextDecoration.get().getAlign());
		assertEquals(baseline, foundTextDecoration.get().getBaseline());
		assertEquals(direction, foundTextDecoration.get().getDirection());
		
		// clean up
		textdecorationService.deleteTextDecoration(textdecoration.getId());
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
		
		// create Gradient
		String name = "a text decoration";
		Matrix matrix = new Matrix();
		
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		String font = "a font";
		ETextAlign align = ETextAlign.CENTER;
		ETextBaseline baseline = ETextBaseline.IDEOGRAPHIC;
		ETextDirection direction = ETextDirection.LTR;
		
		TextDecorationEntity textdecoration = new TextDecorationEntity();

		textdecoration.setName(name);
		textdecoration.setMatrix(matrix);
		textdecoration.setFont(font);
		textdecoration.setAlign(align);
		textdecoration.setBaseline(baseline);
		textdecoration.setDirection(direction);
		
		exception = false;
		try {
			textdecorationService.createTextDecoration(user, textdecoration);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<TextDecorationEntity> foundTextDecoration = textdecorationService.findById(textdecoration.getId());
		assertTrue( foundTextDecoration.isPresent() );
		
		// clean up
		textdecorationService.deleteTextDecoration(textdecoration.getId());
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
		
		// create Gradient
		String name = "a text decoration";
		Matrix matrix = new Matrix();							
		
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		String font = "a font";
		ETextAlign align = ETextAlign.CENTER;
		ETextBaseline baseline = ETextBaseline.IDEOGRAPHIC;
		ETextDirection direction = ETextDirection.LTR;
		
		TextDecorationEntity textdecoration = new TextDecorationEntity();

		textdecoration.setName(name);
		textdecoration.setMatrix(matrix);
		textdecoration.setFont(font);
		textdecoration.setAlign(align);
		textdecoration.setBaseline(baseline);
		textdecoration.setDirection(direction);
		
		exception = false;
		try {
			textdecorationService.createTextDecoration(user, textdecoration);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<TextDecorationEntity> foundTextDecoration = textdecorationService.findByName(user, name);
		assertTrue( foundTextDecoration.isPresent() );
		
		// clean up
		textdecorationService.deleteTextDecoration(textdecoration.getId());
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
		
		// create Gradient
		String name = "a text decoration";
		Matrix matrix = new Matrix();							
		
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		String font = "a font";
		ETextAlign align = ETextAlign.CENTER;
		ETextBaseline baseline = ETextBaseline.IDEOGRAPHIC;
		ETextDirection direction = ETextDirection.LTR;
		
		TextDecorationEntity textdecoration = new TextDecorationEntity();

		textdecoration.setName(name);
		textdecoration.setMatrix(matrix);
		textdecoration.setFont(font);
		textdecoration.setAlign(align);
		textdecoration.setBaseline(baseline);
		textdecoration.setDirection(direction);
		
		exception = false;
		try {
			textdecorationService.createTextDecoration(user, textdecoration);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<TextDecorationEntity> foundTextDecoration = textdecorationService.findById(textdecoration.getId());
		assertTrue( foundTextDecoration.isPresent() );

		// update
		String name2 = "a new text decoration";
		Matrix matrix2 = new Matrix();							
		
		matrix2.setA(8);
		matrix2.setB(9);
		matrix2.setC(10);
		matrix2.setD(11);
		matrix2.setE(12);
		matrix2.setF(13);
		
		String font2 = "a other font";
		ETextAlign align2 = ETextAlign.RIGHT;
		ETextBaseline baseline2 = ETextBaseline.MIDDLE;
		ETextDirection direction2 = ETextDirection.RTL;
		
		TextDecorationEntity textdecoration2 = new TextDecorationEntity();

		textdecoration2.setName(name2);
		textdecoration2.setMatrix(matrix2);
		textdecoration2.setFont(font2);
		textdecoration2.setAlign(align2);
		textdecoration2.setBaseline(baseline2);
		textdecoration2.setDirection(direction2);
		
		exception = false;
		try {
			textdecorationService.updateTextDecoration(user, textdecoration.getId(), textdecoration2);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<TextDecorationEntity> foundTextDecoration2 = textdecorationService.findById(textdecoration.getId());
		assertTrue( foundTextDecoration2.isPresent() );
		
		assertEquals(user.getId(), foundTextDecoration2.get().getUpdatedBy().getId());
		assertEquals(name2, foundTextDecoration2.get().getName());
		assertEquals(font2, foundTextDecoration2.get().getFont());
		assertEquals(matrix2, foundTextDecoration2.get().getMatrix());
		assertEquals(align2, foundTextDecoration2.get().getAlign());
		assertEquals(baseline2, foundTextDecoration2.get().getBaseline());
		assertEquals(direction2, foundTextDecoration2.get().getDirection());
		
		// clean up
		textdecorationService.deleteTextDecoration(textdecoration.getId());
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
		
		// create Gradient
		String name = "a text decoration";
		Matrix matrix = new Matrix();
		
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		String font = "a font";
		ETextAlign align = ETextAlign.CENTER;
		ETextBaseline baseline = ETextBaseline.IDEOGRAPHIC;
		ETextDirection direction = ETextDirection.LTR;
		
		TextDecorationEntity textdecoration = new TextDecorationEntity();

		textdecoration.setName(name);
		textdecoration.setMatrix(matrix);
		textdecoration.setFont(font);
		textdecoration.setAlign(align);
		textdecoration.setBaseline(baseline);
		textdecoration.setDirection(direction);
		
		exception = false;
		try {
			textdecorationService.createTextDecoration(user, textdecoration);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		assertFalse(exception);
		
		Optional<TextDecorationEntity> foundTextDecoration = textdecorationService.findById(textdecoration.getId());
		assertTrue( foundTextDecoration.isPresent() );
		
		// clean up
		textdecorationService.deleteTextDecoration(textdecoration.getId());
		userService.deleteUser(user.getId());
		
		Optional<TextDecorationEntity> foundTextDecoration2 = textdecorationService.findById(textdecoration.getId());
		assertFalse( foundTextDecoration2.isPresent() );
	}	

}
