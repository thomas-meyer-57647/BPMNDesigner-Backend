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
 * this is a group of <code>DrawObject</code>
 */
public class Group {
	String name;
	private List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
	
	/**
	 * initialize constructor
	 * 
	 * if <code>drawobjects</code> is null or size 0 the function will be thrown a
	 * IllegalArgumentException
	 * 
	 * @param drawojbects
	 */
	public Group(List<AbstractDrawObject> drawobjects) {
		super();
		
		if ( drawobjects == null || drawobjects.size() == 0) {
			throw new IllegalArgumentException("Group::constructor(" + drawobjects + ": could not be null and must be have a drawobject");
		}
		
		this.drawobjects = drawobjects;
	}

	// GETTER / SETTER
	/**
	 * get the Name of the group
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the Name of the group
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the drawobjects in the group
	 * 
	 * @return String
	 */
	public List<AbstractDrawObject> getDrawobjects() {
		return drawobjects;
	}
	
	/**
	 * set the drawobjects in the group
	 * 
	 * If <code>drawobjects</code> null or it has no drawobject, than will this function
	 * throw an IllegalArgumentException
	 * 
	 * @return String
	 */
	public void setDrawobjects(List<AbstractDrawObject> drawobjects) {
		if ( drawobjects == null || drawobjects.size() == 0) {
			throw new IllegalArgumentException("Group::constructor(" + drawobjects + ": could not be null and must be have a drawobject");
		}
		
		this.drawobjects = drawobjects;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", drawobjects=" + drawobjects + "]";
	}
	
	
}
