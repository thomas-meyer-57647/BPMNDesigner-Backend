package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * this is a storable gradient
 */
@Document(collection="gradients")
public class GradientEntity extends Gradient {

}
