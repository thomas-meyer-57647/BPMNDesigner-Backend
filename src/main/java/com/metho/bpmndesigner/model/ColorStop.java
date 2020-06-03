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
 * 
 * double offset		the offset of the colorstop. It must be between 0 and 1
 * Color color			the color. It could not be null
 */
public class ColorStop {
	
	@Min(0)
	@Max(1)
	private double offset;					// the offset of the colorstop
	
	@NotNull								
	private Color color;					// the color
	
	/**
	 * default constructor
	 */
	public ColorStop() {
		super();
	}
	
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
	
	/**
	 * clone this colorstop
	 * 
	 * @return ColorStop
	 * @public
	 */
	public ColorStop clone() {
		ColorStop newColorStop = new ColorStop();
		
		newColorStop.color = this.color.clone();
		newColorStop.offset = this.offset;
		
		return newColorStop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(offset);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ColorStop other = (ColorStop) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(offset) != Double.doubleToLongBits(other.offset))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColorStop [offset=" + offset + ", color=" + color + "]";
	}	
}
