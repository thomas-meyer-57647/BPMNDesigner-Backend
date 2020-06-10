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
 * this is a class for grouping AbstractDrawObject
 * 
 * List<AbstractDrawObject> drawobjects				this list of abstract draw object
 */
public class GroupAbstractDrawObject {
	
	private List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();		// this list of abstract draw object

	/**
	 * default constructor
	 */
	public GroupAbstractDrawObject() {
		super();
	}

	/**
	 * initialize constructor
	 * 
	 * @param drawobjects
	 * @throws NullPointerException - if <code>drawobjects</code> is null
	 */
	public GroupAbstractDrawObject(List<AbstractDrawObject> drawobjects) {
		super();
		
		this.setDrawObjects(drawobjects);
	}

	/**
	 * copy constructor
	 * 
	 * @param drawobjects
	 * @throws NullPointerException - if <code>groupAbstractDrawObject</code> is null
	 */
	public GroupAbstractDrawObject(GroupAbstractDrawObject groupAbstractDrawObject) {
		this(groupAbstractDrawObject.drawobjects);
	}

	/**
	 * get list of abstract draw objects
	 * 
	 * @return List<AbstractDrawObject>
	 */
	public List<AbstractDrawObject> getDrawObjects() {
		return drawobjects;
	}

	/**
	 * set list of abstract draw objects
	 * 
	 * @param drawobjects
	 * @throws NullPointerException - if <code>drawobjects</code> is null
	 */
	public void setDrawObjects(List<AbstractDrawObject> drawobjects) {
		List<AbstractDrawObject> newDrawObjects = new ArrayList<AbstractDrawObject>();
		
		for ( int index=0; index<drawobjects.size(); index++ ) {
			newDrawObjects.add(new AbstractDrawObject(drawobjects.get(index)));
		}
		
		this.drawobjects = newDrawObjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drawobjects == null) ? 0 : drawobjects.hashCode());
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
		GroupAbstractDrawObject other = (GroupAbstractDrawObject) obj;
		if (drawobjects == null) {
			if (other.drawobjects != null)
				return false;
		} else if (!drawobjects.equals(other.drawobjects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupAbstractDrawObject [drawobjects=" + drawobjects + "]";
	}	
}
