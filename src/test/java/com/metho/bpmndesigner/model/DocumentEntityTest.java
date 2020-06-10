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
 * test the function of <code>DocumentEntity</code>
 */
class DocumentEntityTest {

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		// initialize
		String name = "a document name";
		String author = "a author";
		String version = "a version";
		String description = "a description";
		Page page1 = new Page();
		Page page2 = new Page();
		
		// create document
		DocumentEntity document = new DocumentEntity();
		
		document.setName(name);
		document.setAuthor(author);
		document.setVersion(version);
		document.setDescription(description);
		document.getPages().add(page1);
		document.getPages().add(page2);
		
		// clone document
		DocumentEntity newDocument = document.clone();

		// check
		assertTrue( document != newDocument );
		assertTrue( document.getPages() != newDocument.getPages() );
		assertEquals( document, newDocument );
	}

}
