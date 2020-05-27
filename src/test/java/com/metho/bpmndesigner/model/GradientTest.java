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

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * test function for the gradient test
 */
@SpringBootTest
class GradientTest {
	/**
	 * test constructor() 
	 */
	@Test
	void testConstructor() {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "gradient";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 4;
		int y2 = 5;
		int r2 = 6;
		boolean exception = false;
		Gradient gradient = null;
		ColorStop colorstop = new ColorStop(.1f, new Color(255));
		
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		colorstops.add(colorstop);

		try {
			gradient = new Gradient(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertEquals(type, gradient.getGradientType());
		assertEquals(name, gradient.getName());
		assertEquals(idname, gradient.getIdname());
		assertEquals(x1, gradient.getX1());
		assertEquals(y1, gradient.getY1());
		assertEquals(r1, gradient.getR1());
		assertEquals(x2, gradient.getX2());
		assertEquals(y2, gradient.getY2());
		assertEquals(r2, gradient.getR2());
		assertEquals(colorstops, gradient.getColorStops());
	}
	
	/**
	 * test constructor() with Colorstops null 
	 */
	@Test
	void testConstructorWithColorStopsNull() {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "gradient";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 4;
		int y2 = 5;
		int r2 = 6;
		boolean exception = false;
		Gradient gradient = null;
		List<ColorStop> colorstops = null; 
		
		try {
			gradient = new Gradient(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test constructor() with empty ColorStop List 
	 */
	@Test
	void testConstructorWithEmptyColorStopList() {
		EGradientType type = EGradientType.LINEARGRADIENT;
		String name = "gradient";
		String idname = "idname";
		int x1 = 1;
		int y1 = 2;
		int r1 = 3;
		int x2 = 4;
		int y2 = 5;
		int r2 = 6;
		boolean exception = false;
		Gradient gradient = null;
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		
		try {
			gradient = new Gradient(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setColorStop() 
	 */
	@Test
	void testSetColorStop() {
		ColorStop colorstop = new ColorStop(.1f, new Color(255));
		
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		colorstops.add(colorstop);
		
		Gradient gradient = new Gradient();
		boolean exception = false;
		
		try {
			gradient.setColorStops(colorstops);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
	}

	/**
	 * test setColorStop() with NULL
	 */
	@Test
	void testSetColorStopWithNULL() {
		List<ColorStop> colorstops = null;
		Gradient gradient = new Gradient();
		boolean exception = false;
		
		try {
			gradient.setColorStops(colorstops);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setColorStop() with empty list
	 */
	@Test
	void testSetColorStopWithEmptyList() {
		List<ColorStop> colorstops = new ArrayList<ColorStop>();
		Gradient gradient = new Gradient();
		boolean exception = false;
		
		try {
			gradient.setColorStops(colorstops);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

}
