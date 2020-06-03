package com.metho.bpmndesigner.model;
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
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PaletteEntityTest {
	
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
		String name = "palette";
		List<Color> colors = new ArrayList<Color>();
		
		PaletteEntity palette = new PaletteEntity(name, colors);
		
		Set<ConstraintViolation<PaletteEntity>> violations = validator.validate(palette);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test constructor 2 Parameters with colors null
	 */
	@Test
	void testConstructor2ParametersWithColorsNull() {
		String name = "palette";
		List<Color> colors = null;
		
		PaletteEntity palette = new PaletteEntity(name, colors);
		
		Set<ConstraintViolation<PaletteEntity>> violations = validator.validate(palette);
		assertFalse(violations.isEmpty());		
	}
	
	/**
	 * test getName()
	 */
	@Test
	void testGetName() {
		String name = "palette";
		List<Color> colors = new ArrayList<Color>();
		
		PaletteEntity palette = new PaletteEntity();
		palette.setName(name);
		palette.setColors(colors);
		
		assertEquals(name, palette.getName());
	}
	
	/**
	 * test setName()
	 */
	@Test
	void testSetName() {
		String name = "palette";
		List<Color> colors = new ArrayList<Color>();
		
		PaletteEntity palette = new PaletteEntity();
		palette.setName(name);
		palette.setColors(colors);
		
		assertEquals(name, palette.getName());
		
		Set<ConstraintViolation<PaletteEntity>> violations = validator.validate(palette);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test getColors()
	 */
	@Test
	void testGetColors() {
		String name = "palette";
		List<Color> colors = new ArrayList<Color>();
		
		PaletteEntity palette = new PaletteEntity();
		palette.setName(name);
		palette.setColors(colors);
		
		assertEquals(colors, palette.getColors());
	}
	
	/**
	 * test setColors()
	 */
	@Test
	void testSetColors() {
		String name = "palette";
		List<Color> colors = new ArrayList<Color>();
		
		PaletteEntity palette = new PaletteEntity();
		palette.setName(name);
		palette.setColors(new ArrayList<Color>());
		
		assertEquals(colors, palette.getColors());
		
		Set<ConstraintViolation<PaletteEntity>> violations = validator.validate(palette);
		assertTrue(violations.isEmpty());		
	}
	
	/**
	 * test setColors() With Null
	 */
	@Test
	void testSetColorsWithNull() {
		String name = "palette";
		List<Color> colors = null;
		
		PaletteEntity palette = new PaletteEntity();
		palette.setName(name);
		palette.setColors(colors);
		
		assertEquals(colors, palette.getColors());
		
		Set<ConstraintViolation<PaletteEntity>> violations = validator.validate(palette);
		assertFalse(violations.isEmpty());		
	}

}
