package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * this are the test function for the <code>Association</code>
 */
class AssociationTest {
	
	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		Association association = new Association();
		
		assertNotNull(association);
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = new Arrow();
		Point point = new Point(20, 30);
		
		Association association = new Association(uuid, arrow, point);
		
		assertTrue( arrow != association.getArrow() );
		assertTrue( point != association.getPoint() );
		assertEquals( arrow, association.getArrow() );
		assertEquals(uuid, association.getUUID() );
		assertEquals(point, association.getPoint() );
	}
	
	/**
	 * test initialize constructor with null Arrow 
	 */
	@Test
	void testInitializeConstructorWithNullArrow() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = null;
		Point point = new Point(20, 30);
		boolean exception = false;
		Association association = null;
		
		try {
			association = new Association(uuid, arrow, point);
		} catch (Exception e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( point != association.getPoint() );
		assertNull(association.getArrow());
		assertEquals(uuid, association.getUUID() );
		assertEquals(point, association.getPoint() );

	}
	
	/**
	 * test initialize constructor with null Point Should throw NullPointerException
	 */
	@Test
	void testInitializeConstructorWithNullPointShouldThrowNullPointerException() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = new Arrow();
		Point point = null;
		boolean exception = false;
		Association association = null;
		
		try {
			association = new Association(uuid, arrow, point);
		} catch (Exception e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( arrow != association.getArrow() );
		assertNull(association.getPoint());
		assertEquals(uuid, association.getUUID() );
		assertEquals(arrow, association.getArrow() );

	}
	
	/**
	 * test copy constructor
	 */
	@Test
	void testCopyConstructor() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = new Arrow();
		Point point = new Point(20, 30);
		Association association = null;
		Association copyAssociation = null;
		boolean exception = false;
		
		try {
			association = new Association(uuid, arrow, point);
			copyAssociation = new Association(association);
		} catch (Exception e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( association.getArrow() != copyAssociation.getArrow() );
		assertTrue( association.getPoint() != copyAssociation.getPoint() );
		assertEquals( association.getArrow(), copyAssociation.getArrow() );
		assertEquals( association.getUUID(), copyAssociation.getUUID() );
		assertEquals(point, association.getPoint() );
	}
	
	/**
	 * test setArrow
	 */
	@Test
	void testSetArrow() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = new Arrow();
		Point point = new Point(20, 30);
		
		Association association = new Association(uuid, arrow, point);
		
		Arrow newArrow = new Arrow();
		association.setArrow(newArrow);
		
		assertTrue( newArrow != association.getArrow() );
		assertEquals( newArrow, association.getArrow() );
	}
	
	/**
	 * test setArrow with null
	 */
	@Test
	void testSetArrowWithNull() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = new Arrow();
		Point point = new Point(20, 30);
		
		Association association = new Association(uuid, arrow, point);
		
		Arrow newArrow = null;
		association.setArrow(newArrow);
		
		assertTrue( newArrow == association.getArrow() );
	}
	
	/**
	 * test setUUID
	 */
	@Test
	void testSetUUID() {
		UUID uuid = UUID.randomUUID();
		Arrow arrow = new Arrow();
		Point point = new Point(20, 30);
		
		Association association = new Association(uuid, arrow, point);
		
		UUID newUUID = UUID.randomUUID();
		association.setUUID(newUUID);
		
		assertTrue( newUUID == association.getUUID() );
	}
	
}
