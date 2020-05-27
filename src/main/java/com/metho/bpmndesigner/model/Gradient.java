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

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

/**
 * a linear or radial gradient
 */
public class Gradient {
	
	/**
	 * the id of the collection
	 */
	@Id
	private int id;
	
	/**
	 * the type of the gradient
	 */
	private EGradientType gradienttype;
	
	/**
	 * name of the gradient
	 */
	private String name;
	
	/**
	 * id of the gradient
	 */
	private String idname;
	
	/**
	 * start position x
	 */
	private int x1;
	
	/**
	 * start position y
	 */
	private int y1;
	
	/**
	 * radius 1 (only for Radial Gradient)
	 */	
	private int r1;
	
	/**
	 * end position x
	 */	
	private int x2;
	
	/**
	 * end position y
	 */		
	private int y2;
	
	/**
	 * radius 2 (only for Radial Gradient)
	 */	
	private int r2;
	
	/**
	 * the colorstops
	 */
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
					+ gradienttype + ", " + name + ", " + idname + ", " + x1 + ", "
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
	public EGradientType getGradientType() {
		return gradienttype;
	}

	public void setGradientType(EGradientType type) {
		this.gradienttype = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdname() {
		return idname;
	}

	public void setIdname(String idname) {
		this.idname = idname;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getR1() {
		return r1;
	}

	public void setR1(int r1) {
		this.r1 = r1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getR2() {
		return r2;
	}

	public void setR2(int r2) {
		this.r2 = r2;
	}

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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Gradient [id=" + id + ", type=" + gradienttype + ", name=" + name + ", idname=" + idname + ", x1=" + x1
				+ ", y1=" + y1 + ", r1=" + r1 + ", x2=" + x2 + ", y2=" + y2 + ", r2=" + r2 + ", colorstops="
				+ colorstops + "]";
	}
	
}
