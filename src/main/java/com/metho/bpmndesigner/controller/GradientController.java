package com.metho.bpmndesigner.controller;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metho.bpmndesigner.entities.Gradient;

/**
 * this is the controller for gradients
 */
@RestController
public class GradientController {
	
	/**
	 * get the gradient with the given name <code>name</code>
	 * 
	 */
	@GetMapping(path="/gradient/load")
	public Gradient getGradient() {
		return new Gradient();
	}
	
	/**
	 * save the gradient <code>gradient</code> with the given name <code>name</code>
	 * 
	 */

	/**
	 * get all Names of the gradient
	 * 
	 */
	
}
