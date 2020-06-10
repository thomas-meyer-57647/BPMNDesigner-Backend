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
 * the test functions of <code>DrawObjectStyle</code>
 * 
 * @author tomth
 */
class DrawObjectStyleTest {
	/**
	 * test constructor 
	 */
	@Test
	void testConstructor() {
		IStyle fillStyle = null;
		IStyle strokeStyle = new ColorStyle(1);
		LineDash lineDash = new LineDash("", new ArrayList<Integer>());
		ELineCap lineCap = ELineCap.BUTT;
		int lineWidth = 1;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		boolean exception = false;
		
		try {
			drawObjectStyle = new DrawObjectStyle();
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle == drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );
	}
	
	/**
	 * test initialize constructor 
	 */
	@Test
	void testInitializeConstructor() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle != drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
	}
	
	/**
	 * test initialize constructor with color fill style
	 */
	@Test
	void testInitializeConstructorWithColorFillStyle() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle != drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
		assertEquals(EStyleType.COLOR, drawObjectStyle.getFillStyle().getStyleType());
	}
	
	/**
	 * test initialize constructor with gradient fill style
	 */
	@Test
	void testInitializeConstructorWithGradientFillStyle() {
		IStyle fillStyle = new GradientStyle();
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
 	    try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle != drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
		assertEquals(EStyleType.GRADIENT, drawObjectStyle.getFillStyle().getStyleType());
	}
	
	/**
	 * test initialize constructor with pattern fill style
	 */
	@Test
	void testInitializeConstructorWithPatternFillStyle() {
		IStyle fillStyle = new PatternStyle();
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle != drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
		assertEquals(EStyleType.PATTERN, drawObjectStyle.getFillStyle().getStyleType());
	}
	
	/**
	 * test initialize constructor with null stroke style should throw IllegalArgumentException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullStrokeStyleShouldThrowIllegalArgumentException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = null;
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with color stroke style
	 */
	@Test
	void testInitializeConstructorWithColorStrokeStyle() {
		IStyle fillStyle = null;
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle == drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
		assertEquals(EStyleType.COLOR, drawObjectStyle.getStrokeStyle().getStyleType());
	}
	
	/**
	 * test initialize constructor with gradient stroke style
	 */
	@Test
	void testInitializeConstructorWithGradientStrokeStyle() {
		IStyle fillStyle = null;
		IStyle strokeStyle = new GradientStyle();
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
 	    try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle == drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
		assertEquals(EStyleType.GRADIENT, drawObjectStyle.getStrokeStyle().getStyleType());
	}
	
	/**
	 * test initialize constructor with pattern stroke style
	 */
	@Test
	void testInitializeConstructorWithPatternStrokeStyle() {
		IStyle fillStyle = null;
		IStyle strokeStyle = new PatternStyle() ;
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( fillStyle == drawObjectStyle.getFillStyle() );
		assertTrue( strokeStyle != drawObjectStyle.getStrokeStyle() );
		assertTrue( lineDash != drawObjectStyle.getLineDash() );
		assertTrue( matrix != drawObjectStyle.getMatrix() );
		assertEquals( fillStyle, drawObjectStyle.getFillStyle() );
		assertEquals( strokeStyle, drawObjectStyle.getStrokeStyle() );
		assertEquals( lineDash, drawObjectStyle.getLineDash() );
		assertEquals( lineWidth, drawObjectStyle.getLineWidth() );
		assertEquals( lineCap, drawObjectStyle.getLineCap() );
		assertEquals( matrix, drawObjectStyle.getMatrix() );		
		assertEquals(EStyleType.PATTERN, drawObjectStyle.getStrokeStyle().getStyleType());
	}
		
	/**
	 * test initialize constructor with null line dash should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullLineDashShouldThrowNullPointerException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		LineDash lineDash = null;
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with Null matrix should throw NUllPointerException 
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullMatrixShouldThrowNullPointerException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = null;
		DrawObjectStyle drawObjectStyle = null;

		boolean exception = false;
		try {
			drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test fill style with null
	 */
	@Test
	void testFillStyleWithNull() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newFillStyle = null;
		boolean exception = false;
		try {
			drawObjectStyle.setFillStyle(newFillStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newFillStyle == drawObjectStyle.getFillStyle() );
	}
	
	/**
	 * test fill style with color
	 */
	@Test
	void testFillStyleWithColor() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newFillStyle = new ColorStyle(254);
		boolean exception = false;
		try {
			drawObjectStyle.setFillStyle(newFillStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newFillStyle != drawObjectStyle.getFillStyle() );
		assertEquals(newFillStyle, drawObjectStyle.getFillStyle());
		assertEquals(EStyleType.COLOR, drawObjectStyle.getFillStyle().getStyleType());
	}
	
	/**
	 * test fill style with gradient
	 */
	@Test
	void testFillStyleWithGradient() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newFillStyle = new GradientStyle();
		boolean exception = false;
		try {
			drawObjectStyle.setFillStyle(newFillStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newFillStyle != drawObjectStyle.getFillStyle() );
		assertEquals(newFillStyle, drawObjectStyle.getFillStyle());
		assertEquals(EStyleType.GRADIENT, drawObjectStyle.getFillStyle().getStyleType());
	}
	
	/**
	 * test fill style with pattern
	 */
	@Test
	void testFillStyleWithPattern() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newFillStyle = new PatternStyle();
		boolean exception = false;
		try {
			drawObjectStyle.setFillStyle(newFillStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newFillStyle != drawObjectStyle.getFillStyle() );
		assertEquals(newFillStyle, drawObjectStyle.getFillStyle());
		assertEquals(EStyleType.PATTERN, drawObjectStyle.getFillStyle().getStyleType());
	}
	
	/**
	 * test stroke style with null should throw IllegalArgumentException
	 */
	@Test
	void testStrokeStyleWithNullShouldThrowIllegalArgumentException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newStrokeStyle = null;
		boolean exception = false;
		try {
			drawObjectStyle.setStrokeStyle(newStrokeStyle);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test stroke style with color
	 */
	@Test
	void testStrokeStyleWithColor() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newStrokeStyle = new ColorStyle(254);
		boolean exception = false;
		try {
			drawObjectStyle.setStrokeStyle(newStrokeStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newStrokeStyle != drawObjectStyle.getStrokeStyle() );
		assertEquals(newStrokeStyle, drawObjectStyle.getStrokeStyle());
		assertEquals(EStyleType.COLOR, drawObjectStyle.getStrokeStyle().getStyleType());
	}
	
	/**
	 * test stroke style with gradient
	 */
	@Test
	void testStrokeStyleWithGradient() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newStrokeStyle = new GradientStyle();
		boolean exception = false;
		try {
			drawObjectStyle.setStrokeStyle(newStrokeStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newStrokeStyle != drawObjectStyle.getStrokeStyle() );
		assertEquals(newStrokeStyle, drawObjectStyle.getStrokeStyle());
		assertEquals(EStyleType.GRADIENT, drawObjectStyle.getStrokeStyle().getStyleType());
	}
	
	/**
	 * test fill style with pattern
	 */
	@Test
	void testStrokeStyleWithPattern() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;
		
		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);

		IStyle newStrokeStyle = new PatternStyle();
		boolean exception = false;
		try {
			drawObjectStyle.setStrokeStyle(newStrokeStyle);
		} catch (Exception e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newStrokeStyle != drawObjectStyle.getStrokeStyle() );
		assertEquals(newStrokeStyle, drawObjectStyle.getStrokeStyle());
		assertEquals(EStyleType.PATTERN, drawObjectStyle.getStrokeStyle().getStyleType());
	}
	
	/**
	 * test setLineDash 
	 */
	@Test
	void testSetLineDash() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
		);
		
		List<Integer> segments2 = new ArrayList<Integer>();
		segments2.add(4);
		segments2.add(7);
		
		LineDash newLineDash = new LineDash("", segments);
		boolean exception = false;
		try {
			drawObjectStyle.setLineDash(newLineDash);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newLineDash != drawObjectStyle.getLineDash() );
		assertEquals( newLineDash, drawObjectStyle.getLineDash() );
	}
	
	/**
	 * test setLineDash with null should throw NullPointerException 
	 */
	@Test
	void testSetLineDashWithNULLShouldThrowNullPointerException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		drawObjectStyle = new DrawObjectStyle(
				fillStyle, 
				strokeStyle,
				lineDash,
				lineCap,
				lineWidth,
				matrix
		);
		
		LineDash newlineDash = null;
		boolean exception = false;
		try {
			drawObjectStyle.setLineDash(newlineDash);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test setLineWidth 
	 */
	@Test
	void testSetLineWidth() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
		);
		
		List<Integer> segments2 = new ArrayList<Integer>();
		segments2.add(4);
		segments2.add(7);
		
		int newLineWidth = 23;
		boolean exception = false;
		try {
			drawObjectStyle.setLineWidth(newLineWidth);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertEquals( newLineWidth, drawObjectStyle.getLineWidth() );
	}
	
	/**
	 * test setLine with less than 1 should throw an IllegalArgumentException 
	 */
	@Test
	void testSetLineDashWithLessThan1ShouldThrowIllegalArgumentException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
		);
		
		List<Integer> segments2 = new ArrayList<Integer>();
		segments2.add(4);
		segments2.add(7);
		
		int newLineWidth = 0;
		boolean exception = false;
		try {
			drawObjectStyle.setLineWidth(newLineWidth);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		assertTrue(exception);
	}	
	
	/**
	 * test setMatrix 
	 */
	@Test
	void testSetMatrix() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
		);
		
		Matrix newMatrix = new Matrix();
		newMatrix.setA(1);
		newMatrix.setB(2);
		newMatrix.setC(3);
		newMatrix.setD(4);
		newMatrix.setE(5);
		newMatrix.setF(6);
		
		boolean exception = false;
		try {
			drawObjectStyle.setMatrix(newMatrix);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertFalse(exception);
		
		assertTrue( newMatrix != drawObjectStyle.getMatrix() );
		assertEquals( newMatrix, drawObjectStyle.getMatrix() );
	}
	
	/**
	 * test setMatrix with NULL should throw an NullPointerException 
	 */
	@Test
	void testSetMatrixWithNULLShouldThrowAnNullPointerException() {
		IStyle fillStyle = new ColorStyle(222);
		IStyle strokeStyle = new ColorStyle(125);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(5);
				
		LineDash lineDash = new LineDash("", segments);
		ELineCap lineCap = ELineCap.ROUND;
		int lineWidth = 6;
		Matrix matrix = new Matrix();
		DrawObjectStyle drawObjectStyle = null;

		drawObjectStyle = new DrawObjectStyle(
					fillStyle, 
					strokeStyle,
					lineDash,
					lineCap,
					lineWidth,
					matrix
		);
		
		Matrix newMatrix = null;
		boolean exception = false;
		try {
			drawObjectStyle.setMatrix(newMatrix);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}

}
