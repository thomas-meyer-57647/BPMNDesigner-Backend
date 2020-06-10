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
 * this are test function for <code>Image</code>
 */
class ImageTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		Image image = new Image();
	 
		assertNotNull(image);
		assertTrue( image.getUUID().toString().length() > 0 );
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = null;
		
		boolean exception = false;
		try {
			image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(textDecoration != image.getTextDecoration());
		assertTrue(textPosition != image.getTextPosition());
		assertTrue(matrix != image.getMatrix());
		assertEquals(name, image.getName());
		assertEquals(text, image.getText());
		assertEquals(textDecoration, image.getTextDecoration());
		assertEquals(textPosition, image.getTextPosition());
		assertEquals(newFilename, image.getNewFilename());
		assertEquals(originalFilename, image.getOriginalFilename());
		assertEquals(matrix, image.getMatrix());
		assertTrue( image.getUUID().toString().length() > 0 );
	}
	
	/**
	 * test initialize constructor with textDecoration null should throw a NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithTextDecorationNullShouldThrowaNullPointerException() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
		TextDecoration textDecoration = null; /* new TextDecoration(
				text_decoration_name, 
				text_decoration_matrix, 
				font,
				align, 
				baseline, 
				direction	
		);
*/		
		Point textPosition = new Point (20, 30);
		
		AbstractDrawObject drawobject1 = new AbstractDrawObject();
		AbstractDrawObject drawobject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		Image image = null;
		
		boolean exception = false;
		try {
			image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
/*		
		assertTrue(textDecoration != image.getTextDecoration());
		assertTrue(textPosition != image.getTextPosition());
		assertTrue(matrix != image.getMatrix());
		assertEquals(name, image.getName());
		assertEquals(text, image.getText());
		assertEquals(textDecoration, image.getTextDecoration());
		assertEquals(textPosition, image.getTextPosition());
		assertEquals(newFilename, image.getNewFilename());
		assertEquals(originalFilename, image.getOriginalFilename());
		assertEquals(matrix, image.getMatrix());
		assertTrue( image.getUUID().toString().length() > 0 );
*/		
	}
	
	/**
	 * test initialize constructor with TextPosition null should throw null pointer exception
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithTextPositionNullShouldThrowNullPointerException() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = null;
		
		boolean exception = false;
		try {
			image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
/*		
		assertTrue(textDecoration != image.getTextDecoration());
		assertTrue(textPosition != image.getTextPosition());
		assertTrue(matrix != image.getMatrix());
		assertEquals(name, image.getName());
		assertEquals(text, image.getText());
		assertEquals(textDecoration, image.getTextDecoration());
		assertEquals(textPosition, image.getTextPosition());
		assertEquals(newFilename, image.getNewFilename());
		assertEquals(originalFilename, image.getOriginalFilename());
		assertEquals(matrix, image.getMatrix());
		assertTrue( image.getUUID().toString().length() > 0 );
*/		
	}
	
	/**
	 * test copy constructor
	 */
	@Test
	void testCopyConstructor() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		Image copyImage = null;
		
		boolean exception = false;
		try {
			copyImage = new Image(image);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(image.getTextDecoration() != copyImage.getTextDecoration());
		assertTrue(image.getTextPosition() != copyImage.getTextPosition());
		assertTrue(image.getMatrix() != copyImage.getMatrix());
		assertEquals(image.getName(), copyImage.getName());
		assertEquals(image.getText(), copyImage.getText());
		assertEquals(image.getTextDecoration(), copyImage.getTextDecoration());
		assertEquals(image.getTextPosition(), copyImage.getTextPosition());
		assertEquals(image.getNewFilename(), copyImage.getNewFilename());
		assertEquals(image.getOriginalFilename(), copyImage.getOriginalFilename());
		assertEquals(image.getMatrix(), copyImage.getMatrix());
		assertTrue( copyImage.getUUID().toString().length() > 0 );
		assertTrue( image.getUUID() != copyImage.getUUID());
	}
	
	/**
	 * test setTextDecoration
	 */
	@Test
	void testSetTextDecoration() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		TextDecoration newTextDecoation = new TextDecoration();
		
		boolean exception = false;
		try {
			image.setTextDecoration(newTextDecoation);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(newTextDecoation != image.getTextDecoration());
		assertEquals(newTextDecoation, image.getTextDecoration());
	}
	
	/**
	 * test setTextDecoration with NULL should throw NullPointerException
	 */
	@Test
	void testSetTextDecorationWithNullShouldThrowNullPointerException() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		TextDecoration newTextDecoation = null; // new TextDecoration();
		
		boolean exception = false;
		try {
			image.setTextDecoration(newTextDecoation);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertTrue(exception);
/*		
		assertTrue(newTextDecoation != image.getTextDecoration());
		assertEquals(newTextDecoation, image.getTextDecoration());
*/		
	}
	
	/**
	 * test setTextPosition
	 */
	@Test
	void testSetTextPosition() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		Point newTextPosition = new Point();
		
		boolean exception = false;
		try {
			image.setTextPosition(newTextPosition);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
		assertTrue(newTextPosition != image.getTextPosition());
		assertEquals(newTextPosition, image.getTextPosition());
	}
	
	/**
	 * test setTextPosition with NULL should throw NullPointerException
	 */
	@Test
	void testSetTextPositionWithNullShouldThrowNullPointerException() {
		String newFilename = "a new image filename";
		String originalFilename = "a orginal image filename";
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
		
		Matrix matrix = new Matrix(text_decoration_matrix);
		
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
		
		Image image = new Image(name, text, textDecoration, textPosition, newFilename, originalFilename, matrix);
		Point newTextPosition = null; // new Point();
		
		boolean exception = false;
		try {
			image.setTextPosition(newTextPosition);
		} catch (NullPointerException e2) {
			exception = true;
		} 
		
		assertFalse(exception);
/*		
		assertTrue(newTextPosition != image.getTextPosition());
		assertEquals(newTextPosition, image.getTextPosition());
*/		
	}


}
