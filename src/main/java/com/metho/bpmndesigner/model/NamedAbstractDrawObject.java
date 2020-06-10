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
 * this is the class for all drived, named draw objects
 */
public class NamedAbstractDrawObject extends AbstractDrawObject implements INameable {
	
	@NotBlank
    @Size(max=100)	
	private String name;
	
	/**
	 * default constructor
	 */
	public NamedAbstractDrawObject() {
		super();
	}

	/**
	 * initialize constructor
	 * 
	 * If <code>points</code>  or <code>drawObjectStyle</code> is null this function
	 * throws a NullPointerException
	 * 
	 * @param name
	 * @param drawType
	 * @param points
	 * @param drawObjectStyle
	 * @throws NullPointerException
	 */
	public NamedAbstractDrawObject(EDrawType drawType, String name, List<Point> points, DrawObjectStyle drawObjectStyle) {
		super(drawType, points, drawObjectStyle);
		
		this.name = name;
	}

	/**
	 * copy constructor
	 * 
	 * @param abstractDrawObject
	 */
	public NamedAbstractDrawObject(AbstractDrawObject abstractDrawObject) {
		super(abstractDrawObject);
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
	public void setName(@NotBlank @Size(max=100) String name) {
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
		NamedAbstractDrawObject other = (NamedAbstractDrawObject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NamedAbstractDrawObject [name=" + name + ", getPoints()=" + getPoints() + ", getDrawObjectStyle()="
				+ getDrawObjectStyle() + "]";
	}

}
