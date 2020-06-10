package com.metho.bpmndesigner.repositories;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.metho.bpmndesigner.model.TeamEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for a team
 */
@Repository
public interface TeamRepository extends MongoRepository<TeamEntity, Long> {
	/**
	 * find a team by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the team
	 * @return Optional<DocumentEntity>			the found names
	 */
	Optional<TeamEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<DocumentEntity>				the found documents from the creator <code>creator</code>
	 */
	List<TeamEntity> findByCreatedBy(UserEntity creator);
}
