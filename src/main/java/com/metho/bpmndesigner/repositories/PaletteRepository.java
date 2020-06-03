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

import com.metho.bpmndesigner.model.PaletteEntity;
import com.metho.bpmndesigner.model.UserEntity;

/**
 * the repository for a palette
 */
@Repository
public interface PaletteRepository extends MongoRepository<PaletteEntity, Long> {
	
	/**
	 * find a Palette by his name. The index is unique
	 * 
	 * @param UserEntity creator				the person who create this entity
	 * @param String name						the name of the palette
	 * @return List<PaletteEntity>				the found names
	 */
	Optional<PaletteEntity> findByCreatedByAndName(UserEntity creator, String name);
}
