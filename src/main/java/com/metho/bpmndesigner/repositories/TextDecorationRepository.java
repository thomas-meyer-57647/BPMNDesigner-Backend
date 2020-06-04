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

import com.metho.bpmndesigner.model.TextDecorationEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for a text deocration
 * 
 * Optional<TextDecorationEntity> findByCreatedByAndName(UserEntity creator, String name)
 * 																		find a text deocration by his name. The index is unique
 * List<TextDecorationEntity> findByCreatedBy(UserEntity creator) 		find all by a creator
 */
@Repository
public interface TextDecorationRepository extends MongoRepository<TextDecorationEntity, Long> {
	/**
	 * find a text deocration by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the gradient
	 * @return Optional<TextDecorationEntity>	the found names
	 */
	Optional<TextDecorationEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<TextDecorationEntity>		the found text decoration von <code>creator</code>
	 */
	List<TextDecorationEntity> findByCreatedBy(UserEntity creator);
	
}
