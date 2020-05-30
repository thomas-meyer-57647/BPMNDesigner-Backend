package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.List;

/**
 * a <code>page</code> is a part of a <code>Document</code>. 
 * Every <code>page</code> contains one or more <code>layer</code> 
 * 
 * String name;										the name of the page
 * String description;								a detail description of the page
 * List<Layer> layers								the layers of the page
 */
public class Page {
	private String name;											// the name of the page
	private String description;										// a detail description of the page
	private List<Layer> layers = new ArrayList<Layer>();			// the layers of the page

	/**
	 * default constructor
	 */
	public Page() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param String name
	 */
	public Page(String name) {
		super();
		
		this.name = name;
		this.layers.add(new Layer("Main Layer"));
	}
	
	// GETTER / SETTER
	/**
	 * get the name of the page
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the page
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the description for the page
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * set the description for the page
	 * 
	 * @param String
	 * @return void
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * get the layers
	 * 
	 * @return List<Layer>
	 */
	public List<Layer> getLayers() {
		return layers;
	}
	
	/**
	 * set the layers
	 * 
	 * if the <code>layers</code> null or has no layer in the list, than this function will
	 * be thrown a IllegalArgumentException
	 * 
	 * @param List<layer>
	 * @return void
	 */
	public void setLayers(List<Layer> layers) {
		if ( layers == null) {
			throw new IllegalArgumentException("Page.setLayer(" + layers + "): the layers could not be null");
		}

		if ( layers.size() == 0) {
			throw new IllegalArgumentException("Page.setLayer(" + layers.toString() + "): the layers must contains at least one layer");
		}
		
		this.layers = layers;
	}

	@Override
	public String toString() {
		return "Page [name=" + name + ", layers=" + layers + "]";
	}
	
}
