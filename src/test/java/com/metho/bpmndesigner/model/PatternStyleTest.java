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
class PatternStyleTest {

	/**
	 * test getStyleType
	 */
	@Test
	void testGetStyleType() {
		PatternStyle pattern = new PatternStyle();
		
		assertEquals(EStyleType.PATTERN, pattern.getStyleType());
	}

}
