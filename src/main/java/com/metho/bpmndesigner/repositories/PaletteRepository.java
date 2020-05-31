package com.metho.bpmndesigner.repositories;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.metho.bpmndesigner.model.PaletteEntity;

/**
 * the repository for a palette
 */
public interface PaletteRepository extends MongoRepository<PaletteEntity, Long>{
	
	/**
	 * find a Palette by his name
	 */
	List<PaletteEntity> findByName(String name);
}
