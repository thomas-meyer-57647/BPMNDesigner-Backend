package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * this is a color for the fill style
 */
public class ColorStyle extends Color implements IStyle {

	private EStyleType type = EStyleType.COLOR;

	/**
	 * default constructor
	 */
	public ColorStyle() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 * @param transparency
	 * @param name
	 */
	public ColorStyle(@Min(0) int colorvalue, @Min(0) @Max(1) Float transparency, String name) {
		super(colorvalue, transparency, name);
	}

	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 * @param transparency
	 */
	public ColorStyle(@Min(0) int colorvalue, @Min(0) @Max(1) Float transparency) {
		super(colorvalue, transparency);
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 */
	public ColorStyle(@Min(0) int colorvalue) {
		super(colorvalue);
	}
	
	/**
	 * copy constructor
	 * 
	 * @param ColorStyle color
	 */
	public ColorStyle(ColorStyle color) {
		super(color);
	}

	// Getter
	/**
	 * get the style type
	 * 
	 * @return EStyleType
	 */
	@Override
	public EStyleType getStyleType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ColorStyle other = (ColorStyle) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColorStyle [type=" + type + ", getColorValue()=" + getColorValue() + ", getTransparency()="
				+ getTransparency() + ", getName()=" + getName() + "]";
	}

}
