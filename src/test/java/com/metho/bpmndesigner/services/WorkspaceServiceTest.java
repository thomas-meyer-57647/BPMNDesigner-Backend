package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkspaceServiceTest {
	
	@Autowired
	WorkspaceService workspaceService;
	
	/**
	 * test get base directory name
	 */
	@Test
	void testGetBaseDirectoryName() {
		assertEquals( "test", workspaceService.getBaseDirectoryName() );
	}
	
	/**
	 * test getWorkspaceDirectoryName with null
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithNull() {
		assertEquals( "test", workspaceService.getWorkspaceDirectoryName(null) );
	}
	
	/**
	 * test getWorkspaceDirectoryName with empty string
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithEmptyString() {
		assertEquals( "test", workspaceService.getWorkspaceDirectoryName("") );
	}
	
	/**
	 * test getWorkspaceDirectoryName with blank string
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithBlankString() {
		assertEquals( "test", workspaceService.getWorkspaceDirectoryName("     ") );
	}
	
	/**
	 * test getWorkspaceDirectoryName with "\\" string
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithEscapeString() {
		assertEquals( "test", workspaceService.getWorkspaceDirectoryName("\\") );
	}
	
	/**
	 * test getWorkspaceDirectoryName with "/" string
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithBracesString() {
		assertEquals( "test", workspaceService.getWorkspaceDirectoryName("/") );
	}
	
	/**
	 * test getWorkspaceDirectoryName with "metho\\" string
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithMethoEscapeString() {
		assertEquals( "test\\metho", workspaceService.getWorkspaceDirectoryName("metho\\") );
	}
	
	/**
	 * test getWorkspaceDirectoryName with "metho/" string
	 */
	@Test
	void testGetWorkspaceDirectoryNameWithMethoBracesString() {
		assertEquals( "test\\metho", workspaceService.getWorkspaceDirectoryName("metho/") );
	}
	
	/**
	 * test initialize(metho) 
	 */
/*	
	@Test
	void testInitialize() {
		try {
			workspaceService.initialize("metho");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(true);
	}
*/	
	/**
	 * test delete(metho) 
	 */
/*	
	@Test
	void testDelete() {
		try {
			workspaceService.deleteWorkspace("metho"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(true);
	}
*/	
}
