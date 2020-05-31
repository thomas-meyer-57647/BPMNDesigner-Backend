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
 * this are the test functions for the team entity
 */
class TeamEntityTest {
	
	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		DocumentEntity document = new DocumentEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		documentList.add(document);
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
	}
	
	/**
	 * test constructor with null users
	 */
	@Test
	void testConstructorWithNullUsers() {
		boolean exception = false;
		DocumentEntity document = new DocumentEntity();
		
		List<UserEntity> userList = null;
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		documentList.add(document);
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test constructor with null documents
	 */
	@Test
	void testConstructorWithNullDocuments() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		List<DocumentEntity> documentList = null;
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test constructor with empty users list
	 */
	@Test
	void testConstructorWithEmptyUsersList() {
		boolean exception = false;
		DocumentEntity document = new DocumentEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		documentList.add(document);
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test constructor with empty document list
	 */
	@Test
	void testConstructorWithEmptyDocumentList() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

	/**
	 * test get / set users
	 */
	@Test
	void testGetSetUser() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		DocumentEntity document = new DocumentEntity();
		
		List<UserEntity> userList1 = new ArrayList<UserEntity>();
		userList1.add(user);
		
		List<UserEntity> userList2 = new ArrayList<UserEntity>();
		userList2.add(user);
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		documentList.add(document);
		
		try {
			TeamEntity team = new TeamEntity(userList1, documentList);
			team.setUsers(userList2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
	}
	
	/**
	 * test set users with null
	 */
	@Test
	void testSetUserWithNull() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		DocumentEntity document = new DocumentEntity();

		List<UserEntity> userList1 = new ArrayList<UserEntity>();
		userList1.add(user);

		List<UserEntity> userList2 = null;
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		documentList.add(document);
		
		TeamEntity team = new TeamEntity(userList1, documentList);
		
		
		try {
			team.setUsers(userList2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test set users with empty list
	 */
	@Test
	void testSetUsersWithEmptyList() {
		boolean exception = false;
		UserEntity user1 = new UserEntity();
		DocumentEntity document = new DocumentEntity();

		List<UserEntity> userList1 = new ArrayList<UserEntity>();
		userList1.add(user1);

		List<UserEntity> userList2 = new ArrayList<UserEntity>();
		
		List<DocumentEntity> documentList = new ArrayList<DocumentEntity>();
		documentList.add(document);
		
		TeamEntity team = new TeamEntity(userList1, documentList);
		
		try {
			team.setUsers(userList2);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test get / set documents
	 */
	@Test
	void testGetSetDocuments() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		DocumentEntity document1 = new DocumentEntity();
		DocumentEntity document2 = new DocumentEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		List<DocumentEntity> documentList1 = new ArrayList<DocumentEntity>();
		documentList1.add(document1);
		
		List<DocumentEntity> documentList2 = new ArrayList<DocumentEntity>();
		documentList2.add(document2);
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList1);
			team.setDocuments(documentList2); 
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertFalse(exception);
	}
	
	/**
	 * test set documents with null documents
	 */
	@Test
	void testSetDocumentsWithNullDocumentList() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		DocumentEntity document1 = new DocumentEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		List<DocumentEntity> documentList1 = new ArrayList<DocumentEntity>();
		documentList1.add(document1);
		
		List<DocumentEntity> documentList2 = null;
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList1);
			team.setDocuments(documentList2); 
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test set documents with empty list
	 */
	@Test
	void testSetDocumentsWithEmptyList() {
		boolean exception = false;
		UserEntity user = new UserEntity();
		DocumentEntity document1 = new DocumentEntity();
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		List<DocumentEntity> documentList1 = new ArrayList<DocumentEntity>();
		documentList1.add(document1);
		
		List<DocumentEntity> documentList2 = new ArrayList<DocumentEntity>();
		
		try {
			TeamEntity team = new TeamEntity(userList, documentList1);
			team.setDocuments(documentList2); 
		} catch (IllegalArgumentException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

}
