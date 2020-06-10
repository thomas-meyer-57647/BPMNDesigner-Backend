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
 * this are the test functions for the class <code>AbstractImage</code>
 */
class AbstractImageTest {

	/**
	 * test instialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		String new_filename = "new filename";
		String org_filename = "org filename";
		Matrix matrix = new Matrix();
		
		AbstractImage abstractImage = new AbstractImage(
				new_filename,
				org_filename,
				matrix
		);
		
		assertEquals(new_filename, abstractImage.getNewFilename());
		assertEquals(org_filename, abstractImage.getOriginalFilename());
		assertEquals(matrix, abstractImage.getMatrix());
	}
	

	/**
	 * test constructor matrix must be create new Matrix
	 */
	@Test
	void testConstructorMatrixMustBeCreateNewMatrix() {
		Matrix matrix = new Matrix();
		
		AbstractImage abstractImage = new AbstractImage(
				"new Filename",
				"org Filename",
				matrix
		);
		
		assertTrue( abstractImage.getMatrix() != matrix);
	}
	
	/**
	 * test constructor with null matrix should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testConstructorWithNullMatrixShouldThrowNullPointerException() {
		boolean exception = false;
		try {
			AbstractImage abstractImage = new AbstractImage(
					"new Filename",
					"org Filename",
					null
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
		String new_filename = "new filename";
		String org_filename = "org filename";
		Matrix matrix = new Matrix();
		
		AbstractImage abstractImage = new AbstractImage(
				new_filename,
				org_filename,
				matrix
		);
		
		AbstractImage copyAbstractImage = new AbstractImage(abstractImage);
		
		assertEquals(new_filename, copyAbstractImage.getNewFilename());
		assertEquals(org_filename, copyAbstractImage.getOriginalFilename());
		assertEquals(matrix, copyAbstractImage.getMatrix());
	}
	
	/**
	 * test setMatrix
	 */
	@Test
	void testSetMatrix() {
		String new_filename = "new filename";
		String org_filename = "org filename";
		Matrix matrix = new Matrix();
		
		AbstractImage abstractImage = new AbstractImage(
				new_filename,
				org_filename,
				matrix
		);
		
		Matrix newMatrix = new Matrix();
		newMatrix.setA(1);
		newMatrix.setB(2);
		newMatrix.setC(3);
		newMatrix.setD(4);
		newMatrix.setE(5);
		newMatrix.setF(6);
		
		abstractImage.setMatrix(newMatrix);
		assertTrue(newMatrix != abstractImage.getMatrix());
		assertEquals(newMatrix, abstractImage.getMatrix());
	}
	
	/**
	 * test setMatrix with changed values
	 */
	@Test
	void testSetMatrixWithChancedValues() {
		Matrix matrix = new Matrix();
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		AbstractImage abstractImage = new AbstractImage();
		abstractImage.setMatrix(matrix);
		assertEquals(matrix, abstractImage.getMatrix());
		
		AbstractImage newAbstractImage = new AbstractImage();
		newAbstractImage.setMatrix(matrix);
		
		abstractImage.getMatrix().setB(8);
		
		assertNotEquals(abstractImage.getMatrix().getB(), newAbstractImage.getMatrix().getB());
	}
	
	/**
	 * test setMatrix with Null should throw an NullPointerException
	 */
	@Test
	void testSetMatrixWithNullShouldThrowNullPointerException() {
		AbstractImage abstractImage = new AbstractImage();
		
		boolean exception = false;
		try {
			abstractImage.setMatrix(null);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
}
