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

import com.metho.bpmndesigner.model.GradientEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for a gradient
 */
@Repository
public interface GradientRepository extends MongoRepository<GradientEntity, Long> {
	
	/**
	 * find a gradient by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the gradient
	 * @return Optional<GradientEntity>			the found names
	 */
	Optional<GradientEntity> findByCreatedByAndName(UserEntity creator, String name);
}
