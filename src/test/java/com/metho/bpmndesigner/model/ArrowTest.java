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
 * this are the test function for the <code>Arrow</code>
 */
class ArrowTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		Arrow arrow = new Arrow();
		
		assertNotNull(arrow);
	}

}
