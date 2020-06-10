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

import com.metho.bpmndesigner.model.DocumentEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for a <code>DocumentEntity</code>
 * 
 * Optional<DocumentEntity> findByCreatedByAndName(UserEntity creator, String name)
 * 																	find a document by his name. The index is unique
 * List<DocumentEntity> findByCreatedBy(UserEntity creator) 			find all documents by a creator
 */
@Repository
public interface DocumentRepository extends MongoRepository<DocumentEntity, Long> {
	/**
	 * find a document by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the document
	 * @return Optional<DocumentEntity>			the found names
	 */
	Optional<DocumentEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<DocumentEntity>				the found documents from the creator <code>creator</code>
	 */
	List<DocumentEntity> findByCreatedBy(UserEntity creator);
}

