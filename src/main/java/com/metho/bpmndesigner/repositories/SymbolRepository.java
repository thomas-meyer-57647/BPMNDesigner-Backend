package com.metho.bpmndesigner.repositories;
import java.util.List;
import java.util.Optional;

/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.metho.bpmndesigner.model.SymbolEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for an <code>SymbolEntity</code>
 * 
 * Optional<SymbolEntity> findByCreatedByAndName(UserEntity creator, String name)
 * 																	find a symbol by his name. The index is unique
 * List<SymbolEntity> findByCreatedBy(UserEntity creator) 			find all by a creator
 */
@Repository
public interface SymbolRepository extends MongoRepository<SymbolEntity, Long> {
	
	/**
	 * find a symbol by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the symbol
	 * @return Optional<SymbolEntity>			the found names
	 */
	Optional<SymbolEntity> findByCreatedByAndName(UserEntity creator, String name);
	
	/**
	 * find all by a creator
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @return List<SymbolEntity>				the found symbol from the creator <code>creator</code>
	 */
	List<SymbolEntity> findByCreatedBy(UserEntity creator);

}
