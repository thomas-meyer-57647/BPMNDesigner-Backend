package com.metho.bpmndesigner.repositories;
import java.util.List;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.metho.bpmndesigner.model.LineDashEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * this is the repository for the line dash
 * 
 * Optional<LineDashEntity> findByCreatedByAndName(UserEntity creator, String name)
 * 																	find a line dash by his name. The index is unique
 * List<LineDashEntity> findByCreatedBy(UserEntity creator) 		find all line dashes from the user <code>creator</code>
 */
@Repository
public interface LineDashRepository extends MongoRepository<LineDashEntity, Long> {
	
	/**
	 * find a linedash by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the linedash
	 * @return Optional<LineDashEntity>			the found named linedash
	 */
	Optional<LineDashEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<LineDashEntity>				the found line dashes from the creator <code>creator</code>
	 */
	List<LineDashEntity> findByCreatedBy(UserEntity creator);
	
}
