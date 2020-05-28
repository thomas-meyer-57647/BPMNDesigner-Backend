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

/**
 * test function for the group test
 */
class GroupTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		DrawObject drawobject = new DrawObject(points);
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject);
		
		boolean exception = false;
		try {
			Group group = new Group(drawobjects);			
		} catch (Exception e) {
			exception = true;
		}
		
		assertFalse(exception);
	}
	
	/**
	 * test constructor with null should throw IllegalArgumentException
	 */
	@Test
	void testConstructorWithNullShouldThrowIllegalArgumentException() {
		
		boolean exception = false;
		try {
			Group group = new Group(null);			
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

	/**
	 * test constructor with empty list should throw IllegalArgumentException
	 */
	@Test
	void testConstructorWithEmptyListShouldThrowIllegalArgumentException() {
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		
		boolean exception = false;
		try {
			Group group = new Group(drawobjects);			
		} catch (Exception e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setDrawObjects
	 */
	@Test
	void testSetDrawObjects() {
		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(1, 2));
		points1.add(new Point(3, 4));
		
		DrawObject drawobject1 = new DrawObject(points1);
		
		List<AbstractDrawObject> drawobjects1 = new ArrayList<AbstractDrawObject>();
		drawobjects1.add(drawobject1);
		
		List<Point> points2 = new ArrayList<Point>();
		points2.add(new Point(1, 2));
		points2.add(new Point(3, 4));
		
		DrawObject drawobject2 = new DrawObject(points1);
		
		List<AbstractDrawObject> drawobjects2 = new ArrayList<AbstractDrawObject>();
		drawobjects2.add(drawobject2);

		Group group = new Group(drawobjects1);			
		
		boolean exception = false;
		try {
			group.setDrawobjects(drawobjects2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
	}
	
	/**
	 * test setDrawObjects with null should throw IllegalArgumentException
	 */
	@Test
	void testSetDrawObjectsWithNullShouldThrowIllegalArgumentException() {
		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(1, 2));
		points1.add(new Point(3, 4));
		
		DrawObject drawobject1 = new DrawObject(points1);
		
		List<AbstractDrawObject> drawobjects1 = new ArrayList<AbstractDrawObject>();
		drawobjects1.add(drawobject1);
		
		List<AbstractDrawObject> drawobjects2 = null;

		Group group = new Group(drawobjects1);			
		
		boolean exception = false;
		try {
			group.setDrawobjects(drawobjects2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setDrawObjects with empty list should throw IllegalArguemtnException
	 */
	@Test
	void testSetDrawObjectsWithEmptyListShouldThrowIllegalArgumentException() {
		List<Point> points1 = new ArrayList<Point>();
		points1.add(new Point(1, 2));
		points1.add(new Point(3, 4));
		
		DrawObject drawobject1 = new DrawObject(points1);
		
		List<AbstractDrawObject> drawobjects1 = new ArrayList<AbstractDrawObject>();
		drawobjects1.add(drawobject1);
		
		List<AbstractDrawObject> drawobjects2 = new ArrayList<AbstractDrawObject>();

		Group group = new Group(drawobjects1);			
		
		boolean exception = false;
		try {
			group.setDrawobjects(drawobjects2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
}
