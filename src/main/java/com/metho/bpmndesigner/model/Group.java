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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is a group of <code>DrawObject</code>
 */
public class Group implements IGroupable {
	
	@NotNull
	@NotEmpty
	@Field("draw_objects")
	private List<IGroupable> drawobjects = new ArrayList<IGroupable>();
	
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
	 * NOTE
	 * the <code>drawobjects</code> can not be null or empty
	 * 
	 * @param List<IGroupable> drawojbects
	 */
	public Group(List<IGroupable> drawobjects) {
		super();

		this.setDrawObjects(drawobjects);
	}
	
	/**
	 * copy constructor
	 * 
	 * @param Group drawojbects
	 */
	public Group(Group group) {
		this(group.getDrawObjects());
	}

	// GETTER / SETTER
	/**
	 * get the drawobjects in the group
	 * 
	 * @return String
	 */
	public List<IGroupable> getDrawObjects() {
		return drawobjects;
	}
	
	/**
	 * set the drawobjects in the group
	 * 
	 * NOTE
	 * the <code>drawobjects</code> can not be null or empty
	 * 
	 * @param List<IGroupable> drawobjects
	 * @return null
	 */
	public void setDrawObjects(List<IGroupable> drawobjects) {
		this.drawobjects = drawobjects;
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
		Group other = (Group) obj;
		if (drawobjects == null) {
			if (other.drawobjects != null)
				return false;
		} else if (!drawobjects.equals(other.drawobjects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [drawobjects=" + drawobjects + "]";
	}
}
