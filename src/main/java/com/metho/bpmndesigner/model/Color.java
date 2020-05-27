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
 * this is a color
 */
public class Color {

	/**
	 * the value of the color
	 */
	@Min(0)
	private int colorvalue;
	
	/**
	 * the transparency of the color
	 */
	@Min(0)
	@Max(1)
	private Float transparency;
	
	/**
	 * the name of the color
	 */
	private String name;
	
	/**
	 * initialize constructor
	 * 
	 * @param colorvalue				0 or greater
	 * @param transparency				null or between 0 and 1
	 * @param name
	 */
	public Color(@Min(0) int colorvalue, @Min(0) @Max(1) Float transparency, String name) {
		super();
		this.colorvalue = colorvalue;
		this.transparency = transparency;
		this.name = name;
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 * @param transparency
	 */
	public Color(@Min(0) int colorvalue, @Min(0) @Max(1) Float transparency) {
		this(colorvalue, transparency, null);
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param colorvalue
	 */
	public Color(@Min(0) int colorvalue) {
		this(colorvalue, null, null);
	}

	// Getter / Setter
	/**
	 * get the color value
	 * 
	 * @return int
	 * @public
	 */
	public int getColorValue() {
		return colorvalue;
	}
	
	/**
	 * set the color value
	 * 
	 * @param colorvalue					0 or greater
	 * @return void
	 * @public
	 */
	public void setColorvalue(@Min(0) int colorvalue) {
		this.colorvalue = colorvalue;
	}
	
	/**
	 * get the transparency of the color
	 * 
	 * @return double						
	 * @public
	 */
	public Float getTransparency() {
		return transparency;
	}
	
	/**
	 * get the transparency of the color
	 * 
	 * @return double						null or decimal between 0 and 1
	 * @public
	 */
	public void setTransparency(Float transparency) {
		this.transparency = transparency;
	}
	
	/**
	 * get the name of the color
	 * 
	 * @return String						
	 * @public
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the color
	 * 
	 * @param String
	 * @return void					
	 * @public
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Color [colorvalue=" + colorvalue + ", transparency=" + transparency + ", name=" + name + "]";
	}
}
