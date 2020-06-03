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
 * this are the test cases for a matrix
 */
class MatrixTest {

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		Matrix matrix = new Matrix();
		matrix.setA(1);
		matrix.setB(2);
		matrix.setC(3);
		matrix.setD(4);
		matrix.setE(5);
		matrix.setF(6);
		
		Matrix clonedMatrix = matrix.clone();
		
		assertNotEquals(matrix, clonedMatrix);
		assertEquals(matrix.getA(), clonedMatrix.getA());
		assertEquals(matrix.getB(), clonedMatrix.getB());
		assertEquals(matrix.getC(), clonedMatrix.getC());
		assertEquals(matrix.getD(), clonedMatrix.getD());
		assertEquals(matrix.getE(), clonedMatrix.getE());
		assertEquals(matrix.getF(), clonedMatrix.getF());
	}

}
