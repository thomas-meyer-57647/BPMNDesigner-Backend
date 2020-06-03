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
	 * test clone()
	 */
	@Test
	void testClone() {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix matrix = new Matrix();
		matrix.setA(a);
		matrix.setB(b);
		matrix.setC(c);
		matrix.setD(d);
		matrix.setE(e);
		matrix.setF(f);
		
		TextDecoration textDecoration = new TextDecoration();
		textDecoration.setMatrix(matrix);
		textDecoration.setFont(font);
		textDecoration.setAlign(align);
		textDecoration.setBaseline(baseline);
		textDecoration.setDirection(direction);
		
		TextDecoration newTextDecoration = textDecoration.clone();
		
		assertTrue(textDecoration != newTextDecoration);
		assertTrue(textDecoration.getMatrix() != newTextDecoration.getMatrix());
		
		assertEquals(textDecoration.getMatrix().getA(), newTextDecoration.getMatrix().getA());
		assertEquals(textDecoration.getMatrix().getB(), newTextDecoration.getMatrix().getB());
		assertEquals(textDecoration.getMatrix().getC(), newTextDecoration.getMatrix().getC());
		assertEquals(textDecoration.getMatrix().getD(), newTextDecoration.getMatrix().getD());
		assertEquals(textDecoration.getMatrix().getE(), newTextDecoration.getMatrix().getE());
		assertEquals(textDecoration.getMatrix().getF(), newTextDecoration.getMatrix().getF());
		
		assertEquals(textDecoration.getFont(), newTextDecoration.getFont());
		assertEquals(textDecoration.getAlign(), newTextDecoration.getAlign());
		assertEquals(textDecoration.getBaseline(), newTextDecoration.getBaseline());
		assertEquals(textDecoration.getDirection(), newTextDecoration.getDirection());
	}

}
