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

/**
 * test the function of an <code>AbstractDrawObject</code>
 */
class GroupAbstractDrawObjectTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		GroupAbstractDrawObject groupAbstractDrawObject = new GroupAbstractDrawObject();
		
		assertEquals( 0, groupAbstractDrawObject.getDrawObjects().size() );
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		AbstractDrawObject abstractDrawObject1 = new AbstractDrawObject();
		AbstractDrawObject abstractDrawObject2 = new AbstractDrawObject();
		
		List<AbstractDrawObject> abstractDrawObjectList = new ArrayList<AbstractDrawObject>();
		abstractDrawObjectList.add(abstractDrawObject1);
		abstractDrawObjectList.add(abstractDrawObject2);
		
		GroupAbstractDrawObject groupAbstractDrawObject = new GroupAbstractDrawObject(abstractDrawObjectList);
		
		assertTrue( abstractDrawObjectList != groupAbstractDrawObject.getDrawObjects());
		assertEquals( abstractDrawObjectList, groupAbstractDrawObject.getDrawObjects() );
	}
	
	/**
	 * test initialize constructor with null should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullShouldThrowNullPointerException() {
		
		List<AbstractDrawObject> abstractDrawObjectList = null;
		boolean exception = false;
		
		try {
			GroupAbstractDrawObject groupAbstractDrawObject = new GroupAbstractDrawObject(abstractDrawObjectList);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	

}
