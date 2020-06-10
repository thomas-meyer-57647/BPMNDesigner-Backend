package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * test the function of <code>Point</code>
 */
class PointTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		int x = 0;
		int y = 0;
		
		Point point = new Point();
		
		assertEquals(x, point.getX());
		assertEquals(y, point.getY());
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		int x = 20;
		int y = 30;
		
		Point point = new Point(x, y);
		
		assertEquals(x, point.getX());
		assertEquals(y, point.getY());
	}
	
	/**
	 * test copy constructor
	 */
	@SuppressWarnings("unused")
	@Test
	void testCopyConstructor() {
		int x = 20;
		int y = 30;
		boolean exception = false;
		Point point = new Point(x, y);
		Point newPoint = null;
		
		try {
			newPoint = new Point(point);
		} catch (Exception e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertEquals(x, point.getX());
		assertEquals(y, point.getY());
	}
	
	/**
	 * test copy constructor with null
	 */
	@SuppressWarnings("unused")
	@Test
	void testCopyConstructorWithNull() {
		int x = 20;
		int y = 30;
		boolean exception = false;
		Point point = null;
		Point newPoint = null;
		
		try {
			newPoint = new Point(point);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

}
