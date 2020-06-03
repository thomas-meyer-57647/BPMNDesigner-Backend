package com.metho.bpmndesigner.model;
import java.util.ArrayList;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * a linear or radial gradient
 * 
 * EGradientType gradienttype;				the type of the gradient
 * String name								the name of the gradient (not blank and max 100 chars)
 * String idname							idname of the gradient
 * int x1									start position x
 * int y1									start position y
 * int r1									radius 1 (only for Radial Gradient)
 * int x2									end position x
 * int y2									end position y
 * int r2;									radius 2 (only for Radial Gradient)
 * List<ColorStop> colorstops 				the colorstops	
 */
public class Gradient {
	
	private EGradientType gradienttype;				// the type of the gradient

	@NotBlank
    @Size(max=100)	
	private String name;							// the name of the gradient

	private String idname;							// idname of the gradient
	private int x1;									// start position x
	private int y1;									// start position y
	private int r1;									// radius 1 (only for Radial Gradient)
	private int x2;									// end position x
	private int y2;									// end position y
	private int r2;									// radius 2 (only for Radial Gradient)
	
	// the colorstops
	@NotNull
	private List<ColorStop> colorstops = new ArrayList<ColorStop>();

	/**
	 * default constructor
	 */
	public Gradient() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * If the <code>List<ColorStop> colorstops</code> null or empty this 
	 * function throw an IllegalArgumentException
	 * 
	 * @param type						LINEARGRADIENT | RADIALGRADIENT
	 * @param name
	 * @param idname
	 * @param x1
	 * @param y1
	 * @param r1
	 * @param x2
	 * @param y2
	 * @param r2
	 * @param colorstops
	 * @throws IllegalArgumentException - if the colorstops null or empty list
	 */
	public Gradient(EGradientType gradienttype, String name, String idname, int x1, int y1, int r1, int x2, int y2, int r2,
			@NotNull List<ColorStop> colorstops) {
		super();
		
		if ( colorstops == null || colorstops.size() == 0) {
			throw new IllegalArgumentException("Gradient::constructor(" 
					+ gradienttype + ", " + idname + ", " + x1 + ", "
					+ y1 + ", " + r1 + ", " + x2 + ", " + y2 + ", " + r2 + ", "
					+ colorstops + "): Last Param colorstops could not be null or empty");
		}
		
		this.gradienttype = gradienttype;
		this.name = name;
		this.idname = idname;
		this.x1 = x1;
		this.y1 = y1;
		this.r1 = r1;
		this.x2 = x2;
		this.y2 = y2;
		this.r2 = r2;
		this.colorstops = colorstops;
	}

	// Getter / Setter
	/**
	 * get the type of the gradient
	 * 
	 * the return value could be 
	 *		  
	 *		- EGradientType.LINEARGRADIENT				linear gradient
	 *	    - EGradientType.RADIALGRADIENT				radial gradient 
	 *
	 * @return EGradientType
	 */
	public EGradientType getGradientType() {
		return gradienttype;
	}
	
	/**
	 * set the type of the gradient
	 * 
	 * the param value could be 
	 *		  
	 *		- EGradientType.LINEARGRADIENT				linear gradient
	 *	    - EGradientType.RADIALGRADIENT				radial gradient 
	 *
	 * @param EGradientType
	 * @return void
	 */
	public void setGradientType(EGradientType type) {
		this.gradienttype = type;
	}
	
	/**
	 * get the name of the gradient
	 * 
	 * @return LocalDateTime
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the gradient
	 * 
	 * @return LocalDateTime
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the <code>id<code> name of a css or svg marker
	 * 
	 * @return String
	 */
	public String getIdname() {
		return idname;
	}
	
	/**
	 * set the <code>id<code> name of a css or svg marker
	 * 
	 * @return String
	 */
	public void setIdname(String idname) {
		this.idname = idname;
	}
	
	/**
	 * get the start position x for the gradient
	 * 
	 * @return int
	 */
	public int getX1() {
		return x1;
	}
	
	/**
	 * set the start position x for the gradient
	 * 
	 * @param int
	 * @return void
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	/**
	 * get the start position y for the gradient
	 * 
	 * @return int
	 */
	public int getY1() {
		return y1;
	}
	
	/**
	 * set the start position y for the gradient
	 * 
	 * @param int
	 * @return void
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	/**
	 * get the radius 1 (only for Radial Gradient)
	 * 
	 * @return int
	 */
	public int getR1() {
		return r1;
	}
	
	/**
	 * set the radius 1 (only for Radial Gradient)
	 * 
	 * @param int
	 * @return void
	 */
	public void setR1(int r1) {
		this.r1 = r1;
	}
	
	/**
	 * get the end position x for the gradient
	 * 
	 * @return int
	 */
	public int getX2() {
		return x2;
	}
	
	/**
	 * set the end position x for the gradient
	 * 
	 * @return int
	 */
	public void setX2(int x2) {
		this.x2 = x2;
	}
	
	/**
	 * get the end position y for the gradient
	 * 
	 * @return int
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * set the end position y for the gradient
	 * 
	 * @param int
	 * @return void
	 */
	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	/**
	 * get the radius 2 (only for Radial Gradient)
	 * 
	 * @return int
	 */
	public int getR2() {
		return r2;
	}
	
	/**
	 * set the radius 2 (only for Radial Gradient)
	 * 
	 * @param int
	 * @return void
	 */
	public void setR2(int r2) {
		this.r2 = r2;
	}
	
	/**
	 * get a list of <code>ColorStop</code> for a gradient
	 * 
	 * @param int
	 * @return List<ColorStop>
	 */

	public List<ColorStop> getColorStops() {
		return colorstops;
	}

	/**
	 * set ColorStops 
	 * 
	 * If the <code>List<ColorStop> colorstops</code> null or empty this 
	 * function throw an IllegalArgumentException
	 * 
	 * @param List<ColorStop> colorstops
	 * @return void
	 * @throws IllegalArgumentException - if the list is empty
	 */
	public void setColorStops(@NotNull List<ColorStop> colorstops) {
		if ( colorstops == null || colorstops.size() == 0) {
			throw new IllegalArgumentException("Gradient::setColorStops(" + colorstops + "): Could not be null or empty");
		}
		
		this.colorstops = colorstops;
	}

	/**
	 * clone this gradient
	 * 
	 * NOTE
	 * 		e.g.
	 * 			Gradient gradient = new Gradient();
	 * 			Gradient newGradient = gradient.clone();
	 * 
	 * gets a empty colorstop list but the gradient must have one or more <code>ColorStop</code>
	 * 
	 * @return Gradient
	 */
	public Gradient clone() {
		Gradient newGradient = new Gradient();
		
		newGradient.gradienttype = this.gradienttype;
		newGradient.name = this.name;
		newGradient.idname = this.idname;
		newGradient.x1 = this.x1;
		newGradient.y1 = this.y1;
		newGradient.r1 = this.r1;
		newGradient.x2 = this.x2;
		newGradient.y2 = this.y2;
		newGradient.r2 = this.r2;
		
		for(int index=0; index<this.colorstops.size(); index++) {
			newGradient.colorstops.add(this.colorstops.get(index).clone());
		}
		
		return newGradient;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorstops == null) ? 0 : colorstops.hashCode());
		result = prime * result + ((gradienttype == null) ? 0 : gradienttype.hashCode());
		result = prime * result + ((idname == null) ? 0 : idname.hashCode());
		result = prime * result + r1;
		result = prime * result + r2;
		result = prime * result + x1;
		result = prime * result + x2;
		result = prime * result + y1;
		result = prime * result + y2;
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
		Gradient other = (Gradient) obj;
		if (colorstops == null) {
			if (other.colorstops != null)
				return false;
		} else if (!colorstops.equals(other.colorstops))
			return false;
		if (gradienttype != other.gradienttype)
			return false;
		if (idname == null) {
			if (other.idname != null)
				return false;
		} else if (!idname.equals(other.idname))
			return false;
		if (r1 != other.r1)
			return false;
		if (r2 != other.r2)
			return false;
		if (x1 != other.x1)
			return false;
		if (x2 != other.x2)
			return false;
		if (y1 != other.y1)
			return false;
		if (y2 != other.y2)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gradient [gradienttype=" + gradienttype + ", name=" + name + ", idname=" + idname + ", x1=" + x1
				+ ", y1=" + y1 + ", r1=" + r1 + ", x2=" + x2 + ", y2=" + y2 + ", r2=" + r2 + ", colorstops="
				+ colorstops + "]";
	}

	
}
