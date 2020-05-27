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
 * test ColorFillStyle
 */
@SpringBootTest
class ColorFillStyleTest {

	/**
	 * test getType
	 */
	@Test
	void testGetType() {
		ColorFillStyle color = new ColorFillStyle(255);
		
		assertEquals(EFillStyleType.COLOR, color.getFillStyleType());
	}

}
