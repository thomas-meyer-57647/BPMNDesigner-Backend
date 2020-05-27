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
class ColorStyleTest {

	/**
	 * test getType
	 */
	@Test
	void testGetType() {
		ColorStyle color = new ColorStyle(255);
		
		assertEquals(EStyleType.COLOR, color.getStyleType());
	}

}
