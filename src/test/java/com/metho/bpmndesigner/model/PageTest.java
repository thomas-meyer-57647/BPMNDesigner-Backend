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
 * test function for <code>Page</code> class
 */
class PageTest {

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		String name = "a page";
		String description = "a description";
		Layer layer1 = new Layer();
		Layer layer2 = new Layer();

		Page page = new Page();
		page.setName(name);
		page.setDescription(description);
		page.getLayers().add(layer1);
		page.getLayers().add(layer2);
		
		Page newPage = page.clone();
		
		assertTrue( page != newPage );
		assertTrue( page.getLayers() != newPage.getLayers() );
		assertEquals( page, newPage );
	}

}
