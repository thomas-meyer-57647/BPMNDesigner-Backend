package com.metho.bpmndesigner.services;
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
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.DocumentEntity;
import com.metho.bpmndesigner.model.TeamEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * test function for the team service
 */
@SpringBootTest
class TeamServiceTest {

	@Autowired 
	TeamService teamService;
	
	/**
	 * test create
	 * 
	 * @throws ResourceNotFoundException 
	 */
	@Test
	void testCreate() throws ResourceNotFoundException {
		String name = "team 1";

		UserEntity user = new UserEntity();
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		DocumentEntity document = new DocumentEntity();
		List<DocumentEntity> docurmentList = new ArrayList<DocumentEntity>();
		docurmentList.add(document);
		
		TeamEntity team = new TeamEntity(userList, docurmentList);
		team.setName(name);
		
		boolean exception = false;
		
		try {
			teamService.createTream(null, team);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);

		Optional<TeamEntity> foundTeam = teamService.findById(team.getId());
		
		assertTrue( foundTeam.isPresent() );
		assertEquals(name, foundTeam.get().getName());

		// clean up
		teamService.deleteTeam(team.getId());
	}
	
	/**
	 * test findById
	 * @throws ResourceNotFoundException 
	 */
/*	
	@Test
	void testFindById() throws ResourceNotFoundException {
		String name = "team 1";

		UserEntity user = new UserEntity();
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		DocumentEntity document = new DocumentEntity();
		List<DocumentEntity> docurmentList = new ArrayList<DocumentEntity>();
		docurmentList.add(document);
		
		TeamEntity team = new TeamEntity(userList, docurmentList);
		team.setName(name);
		
		boolean exception = false;
		
		try {
			teamService.createTream(null, team);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);

		Optional<TeamEntity> foundTeam = teamService.findById(team.getId());
		assertTrue( foundTeam.isPresent() );
		
		// clean up
		teamService.deleteTeam(team.getId());
	}
*/
	/**
	 * test update
	 * @throws ResourceNotFoundException 
	 */	
/*	
	@Test
	void testUpdate() throws ResourceNotFoundException {
		String name1 = "team 1";
		String name2 = "test 2";

		UserEntity user1 = new UserEntity();
		List<UserEntity> userList1 = new ArrayList<UserEntity>();
		userList1.add(user1);
		
		DocumentEntity document1 = new DocumentEntity();
		List<DocumentEntity> docurmentList1 = new ArrayList<DocumentEntity>();
		docurmentList1.add(document1);
		
		TeamEntity team = new TeamEntity(userList1, docurmentList1);
		team.setName(name1);
		
		boolean exception = false;
		
		try {
			teamService.createTream(null, team);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
		
		Optional<TeamEntity> foundTeam = teamService.findById(team.getId());
		assertTrue( foundTeam.isPresent() );

		foundTeam.get().setName(name2);
		
		try {
			teamService.updateTeam(null, foundTeam.get().getId(), foundTeam.get());
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
		
		Optional<TeamEntity> foundTeam2 = teamService.findById(team.getId());
		assertTrue( foundTeam2.isPresent() );
		assertEquals(name2, foundTeam2.get().getName());
		
		// clean up
		teamService.deleteTeam(team.getId());
	}	
*/	
	/**
	 * test delete
	 * @throws ResourceNotFoundException 
	 */
/*	
	@Test
	void testDelete() throws ResourceNotFoundException {
		String name = "test";

		UserEntity user = new UserEntity();
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList.add(user);
		
		DocumentEntity document = new DocumentEntity();
		List<DocumentEntity> docurmentList = new ArrayList<DocumentEntity>();
		docurmentList.add(document);
		
		TeamEntity team = new TeamEntity(userList, docurmentList);
		team.setName(name);
		
		boolean exception = false;
		
		try {
			teamService.createTream(null, team);
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		assertFalse(exception);
		
		Optional<TeamEntity> foundTeam = teamService.findById(team.getId());
		assertTrue( foundTeam.isPresent() );

		try {
			teamService.deleteTeam(foundTeam.get().getId());
		} catch (ResourceNotFoundException e) {
			exception = true;
			e.printStackTrace();
		}
		
		Optional<TeamEntity> foundTeam2 = teamService.findById(team.getId());
		assertFalse( foundTeam2.isPresent() );
		
	}	
*/
}
