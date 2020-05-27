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
import javax.validation.constraints.NotNull;

/**
 * this is a colorstep for a gradient
 */
public class ColorStop {
	
	/**
	 * the offset of the colorstop
	 */
	@Min(0)
	@Max(1)
	private double offset;
	
	/**
	 * the color
	 */
	@NotNull
	private Color color;

	/**
	 * initialize constructor
	 * 
	 * @param offset
	 * @param color
	 */
	public ColorStop(@Min(0) @Max(1) double offset, @NotNull Color color) {
		super();
		
		this.offset = offset;
		this.color = color;
	}

	// Getter / Setter
	/**
	 * get the offset of the color stop
	 * 
	 * @return double
	 * @public
	 */
	public double getOffset() {
		return offset;
	}
	
	/**
	 * set the offset of the color stop
	 * The <code>offset</code> must between 0 and 1
	 * 
	 * @return double
	 * @public
	 */
	public void setOffset(@Min(0) @Max(1)double offset) {
		this.offset = offset;
	}
	
	/**
	 * get the color of the color stop
	 * 
	 * @return Color
	 * @public
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * set the color of the color stop
	 * The <code>color</code> could not be null
	 * 
	 * @return Color
	 * @public
	 */
	public void setColor( @NotNull Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ColorStop [offset=" + offset + ", color=" + color + "]";
	}	
}
