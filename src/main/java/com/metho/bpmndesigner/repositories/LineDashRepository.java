package com.metho.bpmndesigner.repositories;
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
import org.springframework.stereotype.Service;

import com.metho.bpmndesigner.model.LineDashEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * this is the repository for the line dash
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
}
