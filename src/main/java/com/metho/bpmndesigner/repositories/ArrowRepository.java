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

import com.metho.bpmndesigner.model.ArrowEntity;
import com.metho.bpmndesigner.model.UserEntity;
/**
 * the repository for an <code>ArrowEntity</code>
 * 
 * Optional<ArrowEntity> findByCreatedByAndName(UserEntity creator, String name)
 * 																	find a arrow by his name. The index is unique
 * List<ArrowEntity> findByCreatedBy(UserEntity creator) 			find all by a creator
 */
@Repository
public interface ArrowRepository extends MongoRepository<ArrowEntity, Long> {
	
	/**
	 * find a arrow by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the arrow
	 * @return Optional<ArrowEntity>			the found names
	 */
	Optional<ArrowEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<ArrowientEntity>			the found arrpw from the creator <code>creator</code>
	 */
	List<ArrowEntity> findByCreatedBy(UserEntity creator);
}
