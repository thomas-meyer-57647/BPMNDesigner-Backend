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
import org.springframework.boot.test.context.SpringBootTest;

/**
 * test function for the GradientFillStyle class
 */
@SpringBootTest
class GradientStyleTest {

	/**
	 * get getFillStyleType()
	 */
	@Test
	void testGetFillStyleType() {
		GradientStyle gradientFillStyle = new GradientStyle();
		
		assertEquals(EStyleType.GRADIENT, gradientFillStyle.getStyleType());
	}
	
}
