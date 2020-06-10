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
import org.springframework.boot.test.context.SpringBootTest;

/**
 * test function for the gradient test
 */
@SpringBootTest
class TextDecorationTest {
	
	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		Matrix matrix = new Matrix();
		String font = "10px sans-serif";
		ETextAlign align = ETextAlign.START;
		ETextBaseline baseline = ETextBaseline.ALPHABETIC;
		ETextDirection direction = ETextDirection.INHERIT;
		boolean exception = false;
		TextDecoration textDecoration = null;
		
		try {
			textDecoration = new TextDecoration();
		} catch (Exception e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( matrix != textDecoration.getMatrix() );
		assertEquals(matrix, textDecoration.getMatrix() );
		assertEquals(font, textDecoration.getFont() );
		assertEquals(align, textDecoration.getAlign() );
		assertEquals(baseline, textDecoration.getBaseline() );
		assertEquals(direction, textDecoration.getDirection() );
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		TextDecoration textDecoration = null;
		
		Matrix matrix = new Matrix();
		matrix.setA(a);
		matrix.setB(b);
		matrix.setC(c);
		matrix.setD(d);
		matrix.setE(e);
		matrix.setF(f);

		boolean exception = false;
		
		try {
			textDecoration = new TextDecoration(
				name, 
				matrix, 
				font,
				align, 
				baseline, 
				direction	
			);
		} catch (Exception excep) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( matrix != textDecoration.getMatrix() );
		assertEquals(matrix, textDecoration.getMatrix() );
		assertEquals(name, textDecoration.getName() );
		assertEquals(font, textDecoration.getFont() );
		assertEquals(align, textDecoration.getAlign() );
		assertEquals(baseline, textDecoration.getBaseline() );
		assertEquals(direction, textDecoration.getDirection() );
	}

	/**
	 * test initialize constructor with null matrix should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullMatrixShouldThrowNullPointerException() {
		String name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		TextDecoration textDecoration = null;
		
		Matrix matrix = null;

		boolean exception = false;
		
		try {
			textDecoration = new TextDecoration(
				name, 
				matrix, 
				font,
				align, 
				baseline, 
				direction	
			);
		} catch (Exception e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test set matrix
	 */
	@Test
	void testSetMatrix() {
		
		TextDecoration textDecoration = new TextDecoration();
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		
		Matrix matrix = new Matrix();
		matrix.setA(a);
		matrix.setB(b);
		matrix.setC(c);
		matrix.setD(d);
		matrix.setE(e);
		matrix.setF(f);

		boolean exception = false;
		try {
			textDecoration.setMatrix(matrix);
		} catch (Exception excep) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( matrix != textDecoration.getMatrix() );
		assertEquals(matrix, textDecoration.getMatrix() );
	}
	
	/**
	 * test set matrix with NULL Matrix should throw NullPointerException
	 */
	@Test
	void testSetMatrixWithNullMatrixShouldThrowNullPointerException() {
		
		TextDecoration textDecoration = new TextDecoration();
		Matrix matrix = null;

		boolean exception = false;
		try {
			textDecoration.setMatrix(matrix);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

}
