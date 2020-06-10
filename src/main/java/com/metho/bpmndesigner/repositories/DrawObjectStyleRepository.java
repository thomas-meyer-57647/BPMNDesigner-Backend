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

import com.metho.bpmndesigner.model.DrawObjectStyleEntity;
import com.metho.bpmndesigner.model.GradientEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for a draw object style
 * 
 * Optional<DrawObjectStyleEntity> findByCreatedByAndName(UserEntity creator, String name)
 * 																	find a draw object style by his name. The index is unique
 * List<DrawObjectStyleEntity> findByCreatedBy(UserEntity creator) 	find all by a creator
 */
@Repository
public interface DrawObjectStyleRepository extends MongoRepository<DrawObjectStyleEntity, Long> {

	/**
	 * find a draw object style by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the draw object style
	 * @return Optional<DrawObjectStyleEntity>	the found names
	 */
	Optional<DrawObjectStyleEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<DrawObjectStyleEntity>		the found draw object style from the creator <code>creator</code>
	 */
	List<GradientEntity> findByCreatedBy(UserEntity creator);

}
