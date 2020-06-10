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
 * this are test function for <code>Symbol</code>
 */
class SymbolTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		Symbol symbol = new Symbol();
	 
		assertNotNull(symbol);
		assertTrue( symbol.getUUID().toString().length() > 0 );
	}

	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		
		boolean exception = false;
		try {
			symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(textDecoration != symbol.getTextDecoration());
		assertTrue(textPosition != symbol.getTextPosition());
		assertTrue(drawobjects != symbol.getDrawObjects());
		assertEquals(name, symbol.getName());
		assertEquals(text, symbol.getText());
		assertEquals(textDecoration, symbol.getTextDecoration());
		assertEquals(textPosition, symbol.getTextPosition());
		assertEquals(drawobjects, symbol.getDrawObjects());
		assertTrue( symbol.getUUID().toString().length() > 0 );
	}
	
	/**
	 * test initialize constructor with text decoration null should throw a NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithTextDecorationNullShouldThrowANullPointerExceptioin() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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

		TextDecoration textDecoration = null; /* new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		); */
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		
		boolean exception = false;
		try {
			symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with text position null should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithTextPositionNullShouldThrowNullPointerException() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = null; // new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		
		boolean exception = false;
		try {
			symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null drawobject list should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullDrawObjectListShouldThrowNullPointerException() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = null; // new ArrayList<AbstractDrawObject>();
	//	drawobjects.add(drawobject1);
	//	drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		
		boolean exception = false;
		try {
			symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
/*		
		assertTrue(textDecoration != symbol.getTextDecoration());
		assertTrue(textPosition != symbol.getTextPosition());
		assertTrue(drawobjects != symbol.getDrawObjects());
		assertEquals(name, symbol.getName());
		assertEquals(text, symbol.getName());
		assertEquals(textDecoration, symbol.getTextDecoration());
		assertEquals(textPosition, symbol.getTextPosition());
		assertEquals(drawobjects, symbol.getDrawObjects());
*/		
	}
	
	/**
	 * test copy constructor
	 */
	@Test
	void testCopyConstructor() {
		// create symbol
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);

		Symbol symbol = null;
		
		boolean exception = false;
		try {
			symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		
		// create copy symbol
		Symbol symbol2 = null;
		
		exception = false;
		try {
			symbol2 = new Symbol(symbol);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);		
		
		assertTrue(symbol.getTextDecoration() != symbol2.getTextDecoration());
		assertTrue(symbol.getTextPosition() != symbol2.getTextPosition());
		assertTrue(symbol.getDrawObjects() != symbol2.getDrawObjects());
		assertEquals(symbol.getName(), symbol2.getName());
		assertEquals(symbol.getName(), symbol2.getName());
		assertEquals(symbol.getTextDecoration(), symbol2.getTextDecoration());
		assertEquals(symbol.getTextPosition(), symbol2.getTextPosition());
		assertEquals(symbol.getDrawObjects(), symbol2.getDrawObjects());
		assertTrue( symbol2.getUUID().toString().length() > 0 );
		assertTrue( symbol.getUUID() != symbol2.getUUID() );
	}
	
	/**
	 * test setTextDecoration
	 */
	@Test
	void testSetTextDecoration() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		
		TextDecoration newTextDecoration = new TextDecoration();
		
		boolean exception = false;
		try {
			symbol.setTextDecoration(newTextDecoration);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(newTextDecoration != symbol.getTextDecoration());
		assertEquals(newTextDecoration, symbol.getTextDecoration());
	}
	
	/**
	 * test setTextDecoration with Null should throw NUllPointerException
	 */
	@Test
	void testSetTextDecorationWithNullShouldThrowNullPointerException() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		
		TextDecoration newTextDecoration = null; // new TextDecoration();
		
		boolean exception = false;
		try {
			symbol.setTextDecoration(newTextDecoration);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
	}
	
	/**
	 * test setTextPosition
	 */
	@Test
	void testSetTextPosition() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		
		Point newTextPosition = new Point();
		
		boolean exception = false;
		try {
			symbol.setTextPosition(newTextPosition);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(newTextPosition != symbol.getTextPosition());
		assertEquals(newTextPosition, symbol.getTextPosition());
	}
	
	/**
	 * test setTextPosition with Null should throw NUllPointerException
	 */
	@Test
	void testSetTextPositionWithNullShouldThrowNullPointerException() {
		String name = "a symbol";
		String text = "a text for a symbol";
		
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
		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Symbol symbol = null;
		symbol = new Symbol(name, text, textDecoration, textPosition, drawobjects);
		
		Point newTextPosition = null; // new Point();
		
		boolean exception = false;
		try {
			symbol.setTextPosition(newTextPosition);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
	}

}
