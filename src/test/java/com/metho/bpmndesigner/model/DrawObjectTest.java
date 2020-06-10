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
import org.springframework.data.util.Pair;

/**
 * test function for <code>DrawObject</code>
 */
class DrawObjectTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		DrawObject drawObject = new DrawObject();
		
		assertNotNull(drawObject);
		assertTrue(drawObject.getUUID().toString().length() > 0 );
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		assertTrue(points != drawObject.getPoints());
		assertTrue(drawObjectStyle != drawObject.getDrawObjectStyle());
		assertTrue(textDecoration != drawObject.getTextDecoration());
		assertTrue(textPosition != drawObject.getTextPosition());
		assertTrue(params != drawObject.getParams());
		
		assertEquals(drawType, drawObject.getDrawType());
		assertEquals(name, drawObject.getName());
		assertEquals(text, drawObject.getText());
		assertEquals(points, drawObject.getPoints());
		assertEquals(drawObjectStyle, drawObject.getDrawObjectStyle());
		assertEquals(textDecoration, drawObject.getTextDecoration());
		assertEquals(textPosition, drawObject.getTextPosition());
		assertEquals(params, drawObject.getParams());
	}
	
	/**
	 * test initialize constructor with null point list should throw a NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullPointListShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					null, // points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (NullPointerException e2) {
			exception = true;
		}

		assertTrue(exception);
	}
	/**
	 * test initialize constructor with null text decoration should throw a NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullTextDecorationShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					null, // textDecoration,
					textPosition,
					params 
			);
		} catch (NullPointerException e2) {
			exception = true;
		}

		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null text position should throw a NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullTextPositionShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					null, // textPosition,
					params 
			);
		} catch (NullPointerException e2) {
			exception = true;
		}

		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null params list should throw a NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullParamListShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					null // params 
			);
		} catch (NullPointerException e2) {
			exception = true;
		}

		assertTrue(exception);
	}
	
	/**
	 * test setTextDecoration
	 */
	@Test
	void testSetTextDecoration() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		TextDecoration newTextDecoration = new TextDecoration();
		
		exception = false;
		try {
			drawObject.setTextDecoration(newTextDecoration);
		} catch (NullPointerException e2) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( newTextDecoration != drawObject.getTextDecoration() );
		assertEquals( newTextDecoration, drawObject.getTextDecoration() );
	}
	
	/**
	 * test setTextDecoration with Null should throw NullPonterException
	 */
	@Test
	void testSetTextDecorationWithNullShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		TextDecoration newTextDecoration = null; // new TextDecoration();
		
		exception = false;
		try {
			drawObject.setTextDecoration(newTextDecoration);
		} catch (NullPointerException e2) {
			exception = true;
		}
		
		assertTrue(exception);
		// assertTrue( newTextDecoration != drawObject.getTextDecoration() );
		// assertEquals( newTextDecoration, drawObject.getTextDecoration() );
	}
	
	/**
	 * test setTextPosition
	 */
	@Test
	void testSetTextPosition() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		Point newTextPosition = new Point(54, 95);
		
		exception = false;
		try {
			drawObject.setTextPosition(newTextPosition);
		} catch (NullPointerException e2) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( newTextPosition != drawObject.getTextPosition() );
		assertEquals( newTextPosition, drawObject.getTextPosition() );
	}
	
	/**
	 * test setTextPosition with Null should throw NullPonterException
	 */
	@Test
	void testSetTextPositionWithNullShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		Point newTextPosition = null; 
		
		exception = false;
		try {
			drawObject.setTextPosition(newTextPosition);
		} catch (NullPointerException e2) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setParams
	 */
	@Test
	void testSetParams() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		List<Pair<String, Object>> newParams = new ArrayList<Pair<String, Object>>();
		
		exception = false;
		try {
			drawObject.setParams(newParams);
		} catch (NullPointerException e2) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( newParams != drawObject.getParams() );
		assertEquals( newParams, drawObject.getParams() );
	}
	
	/**
	 * test setParams with Null should throw NullPonterException
	 */
	@Test
	void testSetParamsWithNullShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		String text = "this is a bezier draw object";
		
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
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix text_decoration_matrix = new Matrix();
		text_decoration_matrix.setA(a);
		text_decoration_matrix.setB(b);
		text_decoration_matrix.setC(c);
		text_decoration_matrix.setD(d);
		text_decoration_matrix.setE(e);
		text_decoration_matrix.setF(f);

		TextDecoration textDecoration = new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
		
		Point textPosition = new Point(25, 33);
		
		Pair<String, Object> param1 = Pair.of("first", "second");
		Pair<String, Object> param2 = Pair.of("third", "fourth");
		List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>(); 
		params.add(param1);
		params.add(param2);

		DrawObject drawObject = null;
		boolean exception = false;
		try {
			drawObject = new DrawObject(
					drawType, 
					name, 
					text,
					points, 
					drawObjectStyle,
					textDecoration,
					textPosition,
					params 
			);
		} catch (Exception e2) {
			exception = true;
		}

		assertFalse(exception);
		List<Pair<String, Object>> newParams = null;
		
		exception = false;
		try {
			drawObject.setParams(newParams);
		} catch (NullPointerException e2) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
/*	
	@Test
	void testClone() {
		// initialize params
		EDrawType drawType = EDrawType.BEZIER;
		String name = "a bezier draw object";
		Point p1 = new Point(1, 2);
		Point p2 = new Point(3, 4);

		List<Point> points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		
		List<Integer> segments = new ArrayList<Integer>();
		segments.add(1);
		segments.add(2);
		
		String text = "a text";
		
		Pair<String, String> pair1 = Pair.of("first", "second");
		Pair<String, String> pair2 = Pair.of("third", "forth");
		List<Pair<String, String>> params = new ArrayList<Pair<String, String>>();
		params.add(pair1);
		params.add(pair2);
		
		// create DrawObject
		DrawObject drawObject = new DrawObject();

		drawObject.setDrawType(drawType);
		drawObject.setName(name);
		drawObject.setPoints(points);
		drawObject.setText(text);
		drawObject.setParams(params);

		// check
		DrawObject newDrawObject = drawObject.clone();
		
		assertTrue( drawObject != newDrawObject );
		assertTrue( drawObject.getStlye() != newDrawObject.getStlye() );
		assertTrue( drawObject.getPoints() != newDrawObject.getPoints() );
		assertTrue( drawObject.getParams() != newDrawObject.getParams() );
		
		assertEquals( drawObject, newDrawObject );
	}
*/
}
