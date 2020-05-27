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

import com.metho.bpmndesigner.model.Gradient;

/**
 * this is the controller for palette
 */
@RestController
public class PaletteController {
	/**
	 * get the palette with the given name <code>name</code>
	 * 
	 */
	@GetMapping(path="/palette/load")
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
