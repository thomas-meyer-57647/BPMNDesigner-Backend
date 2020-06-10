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
 * test the function of an <code>AbstractDrawObject</code>
 */
class AbstractDrawObjectTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		EDrawType drawType = EDrawType.LINE;							
		List<Point> points = new ArrayList<Point>();					
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject();
		
		assertTrue( points != abstractDrawObject.getPoints() );
		assertTrue( drawObjectStyle != abstractDrawObject.getDrawObjectStyle() );
		assertEquals( drawType, abstractDrawObject.getDrawType() );
		assertEquals( points, abstractDrawObject.getPoints() );
		assertEquals( drawObjectStyle, abstractDrawObject.getDrawObjectStyle() );
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testIntializeConstructor() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
				drawType, 
				points, 
				drawObjectStyle
		);
		
		assertTrue( points != abstractDrawObject.getPoints() );
		assertTrue( p1 != abstractDrawObject.getPoints().get(0) );
		assertTrue( p2 != abstractDrawObject.getPoints().get(1) );
		assertTrue( drawObjectStyle != abstractDrawObject.getDrawObjectStyle() );
		assertTrue( points != abstractDrawObject.getPoints() );
		
		assertEquals( points, abstractDrawObject.getPoints() );
		assertEquals( p1, abstractDrawObject.getPoints().get(0) );
		assertEquals( p1, abstractDrawObject.getPoints().get(1) );
		assertEquals( drawType, abstractDrawObject.getDrawType() );
		assertEquals( points, abstractDrawObject.getPoints() );
		assertEquals( drawObjectStyle, abstractDrawObject.getDrawObjectStyle() );
	}
	
	/**
	 * test initialize constructor with null point list should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testIntializeConstructorWithNullPointListShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;		

		List<Point> points = null;					
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();

		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		boolean exception = false;
		try {
			AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
					drawType, 
					points, 
					drawObjectStyle
			);
		} catch (NullPointerException e) {
			exception = true;

		}
		
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null draw object style should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testIntializeConstructorWithNullDrawObjectStyleShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		DrawObjectStyle drawObjectStyle = null;
		
		boolean exception = false;
		try {
			AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
					drawType, 
					points, 
					drawObjectStyle
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test copy constructor
	 */
	@Test
	void testCopyConstructor() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
				drawType, 
				points, 
				drawObjectStyle
		);

		AbstractDrawObject copyAbstractDrawObject = new AbstractDrawObject(abstractDrawObject);
		
		assertTrue( abstractDrawObject.getPoints() != copyAbstractDrawObject.getPoints() );
		assertTrue( abstractDrawObject.getPoints().get(0) != copyAbstractDrawObject.getPoints().get(0) );
		assertTrue( abstractDrawObject.getPoints().get(1) != copyAbstractDrawObject.getPoints().get(1) );
		assertTrue( abstractDrawObject.getDrawObjectStyle() != copyAbstractDrawObject.getDrawObjectStyle() );
		
		assertEquals( abstractDrawObject.getPoints(), copyAbstractDrawObject.getPoints() );
		assertEquals( abstractDrawObject.getPoints().get(0), copyAbstractDrawObject.getPoints().get(0) );
		assertEquals( abstractDrawObject.getPoints().get(1), copyAbstractDrawObject.getPoints().get(1) );
		assertEquals( abstractDrawObject.getDrawType(), copyAbstractDrawObject.getDrawType() );
		assertEquals( abstractDrawObject.getDrawObjectStyle(), copyAbstractDrawObject.getDrawObjectStyle() );
	}
	
	/**
	 * test setPoints
	 */
	@Test
	void testSetPoints() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
				drawType, 
				points, 
				drawObjectStyle
		);
		
		Point p3 = new Point(5, 6);
		Point p4 = new Point(7, 8);
		
		List<Point> points2 = new ArrayList<Point>();					
		points.add(p2);
		points.add(p3);

		boolean exception = false;
		try {
			abstractDrawObject.setPoints(points2);
		} catch (NullPointerException e) {
			exception = true;
		}

		assertFalse(exception);
		assertTrue( points2 != abstractDrawObject.getPoints() );
		assertTrue( p3 != abstractDrawObject.getPoints().get(9) );
		assertTrue( p4 != abstractDrawObject.getPoints().get(1) );
		
		assertEquals( points2, abstractDrawObject.getPoints() );
		assertEquals( p3, abstractDrawObject.getPoints().get(0) );
		assertEquals( p4, abstractDrawObject.getPoints().get(1) );
	}
	
	/**
	 * test setPoints with null point list should throw NullPointerException
	 */
	@Test
	void testSetPointsWithNullPointListShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
				drawType, 
				points, 
				drawObjectStyle
		);
		
		List<Point> points2 = null;					

		boolean exception = false;
		try {
			abstractDrawObject.setPoints(points2);
		} catch (NullPointerException e) {
			exception = true;
		}

		assertTrue(exception);
	}
	
	/**
	 * test set draw object style
	 */
	@Test
	void testSetDrawObjectStyle() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
				drawType, 
				points, 
				drawObjectStyle
		);
		
		DrawObjectStyle newDrawObjectStyle = new DrawObjectStyle();
		boolean exception = false;
		
		try {
			abstractDrawObject.setDrawObjectStyle(newDrawObjectStyle);
		} catch (NullPointerException e) {
			exception = true;
		}

		assertFalse(exception);
		assertTrue( newDrawObjectStyle != abstractDrawObject.getDrawObjectStyle() );
		assertEquals( newDrawObjectStyle, abstractDrawObject.getDrawObjectStyle() );
	}
	
	/**
	 * test set draw object style with null should throw NullPointerException
	 */
	@Test
	void testSetDrawObjectStyleWithNullShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();					
		points.add(p1);
		points.add(p2);
			
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);		

		AbstractDrawObject abstractDrawObject = new AbstractDrawObject(
				drawType, 
				points, 
				drawObjectStyle
		);
		
		DrawObjectStyle newDrawObjectStyle = null;
		boolean exception = false;
		
		try {
			abstractDrawObject.setDrawObjectStyle(newDrawObjectStyle);
		} catch (NullPointerException e) {
			exception = true;
		}

		assertTrue(exception);
	}
	
}
