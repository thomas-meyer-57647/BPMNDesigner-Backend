package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.DocumentEntity;
import com.metho.bpmndesigner.model.TeamEntity;
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.TeamRepository;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a team
 * 
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private UserRepository userRepository;

    /**
     * the sequenceGeneratorService for the auto-increment
     */
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a team
     * 
     * @param UserEntity creator	 				the creator
     * @param TeamEntity team						the user to save
     * @return Team									the created team
     * @throw ResourceNotFoundException				if a <code>creator</code> not exists
     */
    public TeamEntity createTream(UserEntity creator, TeamEntity team) throws ResourceNotFoundException {
    	if ( creator != null ) {
    		userRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	team.setId(sequenceGeneratorService.generateSequence(TeamEntity.SEQUENCE_NAME));
    	team.setCreatedBy(creator);
    	team.setCreatedAt(LocalDateTime.now());
    	
        return teamRepository.save(team);
    }
    
    /**
     * get all teams from the user <code>creator</code>
     * 
     * @return List<User>
     */
    public List<TeamEntity> findAll(UserEntity creator) {
        return teamRepository.findByCreatedBy(creator);
    }
    
    /**
     * get a <code>TeamEntity</code> with the ID <code>id</code>
     * 
     * @param Long userID
     * @return Optional<TeamEntity>
     */
    public Optional<TeamEntity> findById(long userId) {
    	return teamRepository.findById(userId);
    }
    
    /**
     * get a <code>TeamEntity</code> by his name <code>name</code>
     * 
     * @param UserEntity creator			the creator of the team
     * @param String name					the name of the team
     * @return Optional<DocumentEntity>
     */
    public Optional<TeamEntity> findByName(UserEntity creator, String name) {
    	return teamRepository.findByCreatedByAndName(creator, name);
    }
    
    /**
     * update a <code>Team</code> with the id <code>teamID</code> by the User 
     * <code>updaterUser</code>
     * 
     * If a <code>TeamEntity</code> with the id <code>teamID</code> not found this
     * function will be throw a ResourceNotFoundException
     * 
     * @param UserEntity updaterUser				the updated
     * @param Long teamID							the id of the user
     * @param TeamEntity teamDetails				the information to team
     * @return TeamEntity							the created team
     * @throws ResourceNotFoundException			if no team found with the <code>teamID</code>
     */
    public final TeamEntity updateTeam(UserEntity updaterUser, Long teamID, TeamEntity teamDetails) throws ResourceNotFoundException {
        TeamEntity team = teamRepository.findById(teamID)
        		.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + teamID));
        
        team.setUpdatedBy(updaterUser);
        team.setUpdatedAt(LocalDateTime.now());
        team.setName(teamDetails.getName());
        team.setUsers(teamDetails.getUsers());
        team.setDocuments(teamDetails.getDocuments());
        
        return teamRepository.save(team);
    }
    
    /**
     * delete a User update a User with the ID <code>id</code>
     * 
     * @param long teamID							the team with the id <code>teamID</code> 
     * @return void
     * @throws ResourceNotFoundException			if a <code>TeamEntity</code> with the <code>teamID</code> not found
     */
    public void deleteTeam(long teamID) throws ResourceNotFoundException {
        TeamEntity team = teamRepository.findById(teamID)
        		.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + teamID));
        
        teamRepository.delete(team);
    }
    
}
