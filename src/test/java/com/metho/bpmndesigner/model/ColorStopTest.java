package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * test class for the colorstop class
 */
@SpringBootTest
class ColorStopTest {

	private static Validator validator;

	@BeforeAll
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	/**
	 * test constructor 2 Parameters
	 */
	@Test
	void testConstructor2Parameters() {
		double offset = 0;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test constructor 2 Parameters with Offset less than 0
	 */
	@Test
	void testConstructor2ParametersWithOffsetLessThan0() {
		double offset = -1f;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertFalse(violations.isEmpty());
	}	
	
	/**
	 * test constructor 2 Parameters with Offset 0
	 */
	@Test
	void testConstructor2ParametersWithOffset0() {
		double offset = 0;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test constructor 2 Parameters with Offset 1
	 */
	@Test
	void testConstructor2ParametersWithOffset1() {
		double offset = 1f;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test constructor 2 Parameters with Offset greater than 1
	 */
	@Test
	void testConstructor2ParametersWithOffsetGreaterThan1() {
		double offset = 1.1f;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertFalse(violations.isEmpty());
	}	
	
	/**
	 * test constructor 2 Parameters with Color null
	 */
	@Test
	void testConstructor2ParametersWithColorNull() {
		double offset = .1f;
		Color color = null;
		
		ColorStop colorstop = new ColorStop(offset, color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertFalse(violations.isEmpty());
	}	
	
	/**
	 * test getColorStop
	 */
	@Test
	void testGetColorStop() {
		double offset = 1f;
		Color color = null;
		
		ColorStop colorstop = new ColorStop(offset, color);
		
		assertEquals(offset, colorstop.getOffset());
	}	
	
	/**
	 * test setColorStop
	 */
	@Test
	void testSetColorStop() {
		double offset = 1f;
		Color color = new Color(1);
		
		ColorStop colorstop = new ColorStop(.5f, color);
		colorstop.setOffset(offset);
		
		assertEquals(offset, colorstop.getOffset());
		
		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test setColorStop with offset less than 0
	 */
	@Test
	void testSetColorStopWithOffsetLessThan0() {
		double offset = -1f;
		Color color = null;
		
		ColorStop colorstop = new ColorStop(.5f, color);
		colorstop.setOffset(offset);
		
		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertFalse(violations.isEmpty());
	}	
	
	/**
	 * test setColorStop with offset 0
	 */
	@Test
	void testSetColorStopWithOffset0() {
		double offset = 0;
		Color color = new Color(1);
		
		ColorStop colorstop = new ColorStop(.5f, color);
		colorstop.setOffset(offset);
		
		assertEquals(offset, colorstop.getOffset());
		
		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test setColorStop with offset 1
	 */
	@Test
	void testSetColorStopWithOffset1() {
		double offset = 1f;
		Color color = new Color(1);
		
		ColorStop colorstop = new ColorStop(.5f, color);
		colorstop.setOffset(offset);
		
		assertEquals(offset, colorstop.getOffset());
		
		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test setColorStop with offset greater than 0
	 */
	@Test
	void testSetColorStopWithOffsetGreaterThan0() {
		double offset = 1.1f;
		Color color = null;
		
		ColorStop colorstop = new ColorStop(.5f, color);
		colorstop.setOffset(offset);
		
		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertFalse(violations.isEmpty());
	}	
	
	/**
	 * test getColor
	 */
	@Test
	void testGetColor() {
		double offset = 1f;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, new Color(1));
		colorstop.setColor(color);

		assertEquals(color, colorstop.getColor());
	}	
	
	/**
	 * test setColor
	 */
	@Test
	void testSetColor() {
		double offset = 1f;
		Color color = new Color(255);
		
		ColorStop colorstop = new ColorStop(offset, new Color(1));
		colorstop.setColor(color);

		assertEquals(color, colorstop.getColor());
		
		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertTrue(violations.isEmpty());
	}	
	
	/**
	 * test setColor With Color Null
	 */
	@Test
	void testSetColorWithColorNull() {
		double offset = 1f;
		Color color = null;
		
		ColorStop colorstop = new ColorStop(offset, new Color(1));
		colorstop.setColor(color);

		Set<ConstraintViolation<ColorStop>> violations = validator.validate(colorstop);
		assertFalse(violations.isEmpty());
	}	
	
}
