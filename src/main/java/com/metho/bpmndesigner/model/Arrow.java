package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * this is an arrow for a connector
 * 
 * EDrawType drawType;					the draw type
 * List<Point> points				 	the points of the vector it must be minimal 2 points 
 * DrawObjectStyle style 			 	the decoration for the text
 */
public class Arrow extends GroupAbstractDrawObject implements INameable {

	@NotBlank
    @Size(max=100)	
	private String name;
	
	/**
	 * default constructor
	 */
	public Arrow() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param drawobjects
	 * @throws NullPointerException - if <code>drawobjects</code> is null
	 */
	public Arrow(String name, List<AbstractDrawObject> drawobjects) {
		super(drawobjects);
		
		this.name = name;
	}
	
	/**
	 * copy constructor
	 * 
	 * @param groupAbstractDrawObject
	 * @throws NullPointerException - if <code>groupAbstractDrawObject</code> is null
 	 */
	public Arrow(Arrow arrow) {
		super(arrow.getDrawObjects());
		
		this.name = arrow.name; 
	}
	
	/**
	 * get the name of the draw object
	 * 
	 * @return String
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * set the name of the draw object
	 * 
	 * @return String
	 */
	@Override
	public void setName( String name ) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arrow other = (Arrow) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Arrow [name=" + name + ", getDrawObjects()=" + getDrawObjects() + "]";
	}
	
}
