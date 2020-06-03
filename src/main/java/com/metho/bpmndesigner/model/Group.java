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
	 * default constructor
	 * 
	 * @return void
	 */
	public Group() {
		super();
	}
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drawobjects == null) ? 0 : drawobjects.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (drawobjects == null) {
			if (other.drawobjects != null)
				return false;
		} else if (!drawobjects.equals(other.drawobjects))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", drawobjects=" + drawobjects + "]";
	}
	
	
}
