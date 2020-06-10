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
 * test function for the LineDash class
 */
@SpringBootTest
class LineDashTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		boolean exception = false;
		String name = "a line dash";
		LineDash lineDash = null;
		Integer value = 1;
		List<Integer> linedashList = new ArrayList<Integer>();
		
		linedashList.add(value);

		try {
			lineDash = new LineDash(name, linedashList);			
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertEquals(linedashList, lineDash.getSegments());
	}
	
	/**
	 * test constructor with NULL segments list
	 */
	@Test
	void testConstructorWithNullSegmentsList() {
		boolean exception = false;
		String name = "a line dash";
		@SuppressWarnings("unused")
		LineDash lineDash = null;
		List<Integer> segments = null;

		try {
			lineDash = new LineDash(name, segments);			
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test constructor with empty segments list
	 */
	@Test
	void testConstructorWithEmptySegmentsList() {
		boolean exception = false;
		String name = "a line dash";
		@SuppressWarnings("unused")
		LineDash lineDash = null;
		List<Integer> segments = new ArrayList<Integer>();

		try {
			lineDash = new LineDash(name, segments);			
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	/**
	 * test setSegments
	 */
	@Test
	void testSetSegments() {
		boolean exception = false;

		String name = "a line dash";

		Integer value1 = 1;
		List<Integer> segments1 = new ArrayList<Integer>();
		segments1.add(value1);
		
		Integer value2 = 2;
		List<Integer> segments2 = new ArrayList<Integer>();
		segments2.add(value2);

		LineDash lineDash = null;
		
		try {
			lineDash = new LineDash(name, segments1);		
			lineDash.setSegments(segments2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertEquals(segments2, lineDash.getSegments());
	}
	
	/**
	 * test setSegments with null list
	 */
	@Test
	void testSetSegmentsWithNullList() {
		boolean exception = false;
		String name = "a line dash";

		Integer value1 = 1;
		List<Integer> segments1 = new ArrayList<Integer>();
		segments1.add(value1);
		
		List<Integer> segments2 = null;

		LineDash lineDash = new LineDash(name, segments1);
		
		try {
			lineDash.setSegments(segments2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setSegments with empty list
	 */
	@Test
	void testSetSegmentsWithEmptyList() {
		boolean exception = false;
		String name = "a line dash";

		Integer value1 = 1;
		List<Integer> segments1 = new ArrayList<Integer>();
		segments1.add(value1);
		
		List<Integer> segments2 =  new ArrayList<Integer>();

		LineDash lineDash = new LineDash(name, segments1);
		
		try {
			lineDash.setSegments(segments2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
}
