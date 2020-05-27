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
 * the test class for the color
 * 
 * @author tomth
 */
@SpringBootTest
class ColorTest {
	
	private static Validator validator;

	@BeforeAll
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	/**
	 * test constructor With 3 Parameters
	 */
	@Test
	void testConstructorWith3Parameters() {
		int colorvalue = 255;
		Float transparency = 0.25f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		assertEquals(colorvalue, color.getColorValue());
		assertEquals(transparency, color.getTransparency());
		assertEquals(name, color.getName());
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
		
	}
	
	/**
	 * test constructor With 3 Parameters with colorvalue less than 0
	 */
	@Test
	void testConstructorWith3ParametersWithColorValueLessThan0() {
		int colorvalue = -1;
		Float transparency = 0.25f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test constructor With 3 Parameters with transparency null
	 */
	@Test
	void testConstructorWith3ParametersWithTransparencyNull() {
		int colorvalue = 255;
		Float transparency = null;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test constructor With 3 Parameters with transparency less than 0
	 */
	@Test
	void testConstructorWith3ParametersWithTransparencyLessThan0() {
		int colorvalue = 255;
		Float transparency = -1f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test constructor With 3 Parameters with transparency 0
	 */
	@Test
	void testConstructorWith3ParametersWithTransparency0() {
		int colorvalue = 0;
		Float transparency = 0f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test constructor With 3 Parameters with transparency 1
	 */
	@Test
	void testConstructorWith3ParametersWithTransparency1() {
		int colorvalue = 0;
		Float transparency = 1f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test constructor With 3 Parameters with transparency greater than 1
	 */
	@Test
	void testConstructorWith3ParametersWithTransparencyGreaterThan1() {
		int colorvalue = 0;
		Float transparency = 1.1f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test getColorValue
	 */
	@Test
	void testGetColorValue() {
		int colorvalue = 255;
		Color color = new Color(1);
		
		color.setColorvalue(colorvalue);
		
		assertEquals(colorvalue, color.getColorValue());
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		

	}
	
	/**
	 * test setColorValue
	 */
	@Test
	void testSetColorValue() {
		int colorvalue = 255;
		Color color = new Color(1);
		
		color.setColorvalue(colorvalue);
		
		assertEquals(colorvalue, color.getColorValue());
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		

	}
	
	/**
	 * test setColorValue with less than 0
	 */
	@Test
	void testSetColorValueWithLessThan0() {
		int colorvalue = -1;
		Color color = new Color(1);
		
		color.setColorvalue(colorvalue);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test setColorValue with 0
	 */
	@Test
	void testSetColorValueWith0() {
		int colorvalue = 0;
		Color color = new Color(1);
		
		color.setColorvalue(colorvalue);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test getTransparency
	 */
	@Test
	void testgetTransparency() {
		int colorvalue = 255;
		Float transparency = .5f;
		
		Color color = new Color(colorvalue, transparency);
		
		assertEquals(transparency, color.getTransparency());
	}
	
	/**
	 * test setTransparency
	 */
	@Test
	void testSetTransparency() {
		int colorvalue = 255;
		Float transparency = .25f;
		
		Color color = new Color(colorvalue, 0.5f);
		
		color.setTransparency(transparency);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test setTransparency with null
	 */
	@Test
	void testSetTransparencyWithNull() {
		int colorvalue = 255;
		Float transparency = null;
		
		Color color = new Color(colorvalue, 0.5f);
		
		color.setTransparency(transparency);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test setTransparency with less than 0
	 */
	@Test
	void testSetTransparencyWithLessThan0() {
		int colorvalue = 255;
		Float transparency = -1f;
		
		Color color = new Color(colorvalue, 0.5f);
		
		color.setTransparency(transparency);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test setTransparency with 0
	 */
	@Test
	void testSetTransparencyWith0() {
		int colorvalue = 255;
		Float transparency = 0f;
		
		Color color = new Color(colorvalue, 0.5f);
		
		color.setTransparency(transparency);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test setTransparency with 1
	 */
	@Test
	void testSetTransparencyWith1() {
		int colorvalue = 255;
		Float transparency = 1f;
		
		Color color = new Color(colorvalue, 0.5f);
		
		color.setTransparency(transparency);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test setTransparency with greater than 1
	 */
	@Test
	void testSetTransparencyWithGreaterThan1() {
		int colorvalue = 255;
		Float transparency = 1.1f;
		
		Color color = new Color(colorvalue, 0.5f);
		
		color.setTransparency(transparency);

		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test getName
	 */
	@Test
	void testGetName() {
		int colorvalue = 255;
		Float transparency = 1.1f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, name);
		
		assertEquals(name, color.getName());		
	}
	
	/**
	 * test setName
	 */
	@Test
	void testSetName() {
		int colorvalue = 255;
		Float transparency = .1f;
		String name = "color";
		
		Color color = new Color(colorvalue, transparency, "color2");
		color.setName(name);
		
		Set<ConstraintViolation<Color>> violations = validator.validate(color);
		assertTrue(violations.isEmpty());		
	}

}
