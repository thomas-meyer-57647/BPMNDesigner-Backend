package com.metho.bpmndesigner.entities;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * this is a color
 */
public class Color {
	private int colorvalue;
	private int transparency;
	private String name;
	
	/**
	 * default constructor
	 * 
	 * @param colorvalue
	 * @param transparency
	 * @param name
	 */
	public Color(int colorvalue, int transparency, String name) {
		super();
		this.colorvalue = colorvalue;
		this.transparency = transparency;
		this.name = name;
	}

	//=========== Getter / Setter
	public int getColorvalue() {
		return colorvalue;
	}
	
	public void setColorvalue(int colorvalue) {
		this.colorvalue = colorvalue;
	}
	
	public int getTransparency() {
		return transparency;
	}
	
	public void setTransparency(int transparency) {
		this.transparency = transparency;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colorvalue;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + transparency;
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
		Color other = (Color) obj;
		if (colorvalue != other.colorvalue)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (transparency != other.transparency)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Color [colorvalue=" + colorvalue + ", transparency=" + transparency + ", name=" + name + "]";
	}
	
	
}
