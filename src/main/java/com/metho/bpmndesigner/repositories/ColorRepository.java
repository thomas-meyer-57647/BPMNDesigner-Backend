package com.metho.bpmndesigner.repositories;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.metho.bpmndesigner.model.Color;

/**
 * the repository for the color
 */
@Repository
public interface ColorRepository extends MongoRepository<Color, String>{

}
