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
 * test function for <code>PatternStyle</code>
 */
class PatternTest {

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		String newfilename = "new filename";
		String originalFilename = "org filename";
		EPatternRepeat repeat = EPatternRepeat.REPEAT_X;
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
		
		Pattern pattern = new Pattern();
		
		pattern.setNewFilename(newfilename);
		pattern.setOriginalFilename(originalFilename);
		pattern.setRepeat(repeat);
		pattern.setMatrix(matrix);
		
		Pattern newPattern = pattern.clone();
		
		assertTrue( pattern != newPattern );
		assertTrue( pattern.getMatrix() != newPattern.getMatrix() );
		assertEquals( pattern, newPattern );
		
	}

}
