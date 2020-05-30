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

/**
 * The layer can be owned by any number of AbstractDrawObjects 
 */
public class Layer {
	private String name;									// the name of layer
	private List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
	private Color color = null;								// the color for <code>color_used</code>
	private boolean visible = true;							// visible of the drawobjects on this layer
	private boolean active = true;							// drawobjects can be selected
	private boolean locked = false;							// prevent or allow changes to the DrawObjects
	private boolean glue = false;							// ensures that connectors remain attached to DrawObjects
	private boolean printable = true;						// the layer is printable
	private boolean color_used = false;						// applies the assigned color to all DrawObjects on a layer
	private boolean align = true;							// align with the grid 
	
	/**
	 * default constructor
	 */
	public Layer() {
		super();
	}
	
	/**
	 * intialize constructor
	 * 
	 * @param String
	 */
	public Layer(String name) {
		super();
		
		this.name = name;
	}

	// GETTER / SETTER
	/**
	 * get the name of the layer
	 * 
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * set the name of the layer
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the draw objects or group of this layer
	 * 
	 * @param List<AbstractDrawObject>
	 * @return void
	 */
	public List<AbstractDrawObject> getDrawobjects() {
		return drawobjects;
	}
	
	/**
	 * set the draw objects or group of this layer
	 * 
	 * @param List<AbstractDrawObject>
	 * @return void
	 */
	public void setDrawobjects(List<AbstractDrawObject> drawobjects) {
		this.drawobjects = drawobjects;
	}
	
	/**
	 * get the color for this layer
	 * 
	 * @return Color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * set the color for this layer
	 * 
	 * @return Color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * is this layer visible
	 * 
	 * @return boolean
	 */
	public boolean isVisible() {
		return visible;
	}
	
	/**
	 * hidde (false) or show (true) this layer
	 * 
	 * @param boolean
	 * @return void
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	/**
	 * are the drawobjects selectable
	 * 
	 * @return boolean
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * make the draw objects selectable?
	 * 
	 * @param boolean
	 * @return void
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * are the draw objects preventable or allow changes to this?
	 * 
	 * @return boolean
	 */
	public boolean isLocked() {
		return locked;
	}
	
	/**
	 * prevent or allow changes to the DrawObjects
	 * 
	 * @param boolean
	 * @return void
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	/**
	 * ensures that connectors remain attached to DrawObjects
	 * 
	 * @param boolean
	 * @return void
	 */
	public boolean isGlue() {
		return glue;
	}
	
	/**
	 * set ensures that connectors remain attached to DrawObjects
	 * 
	 * @param boolean
	 * @return void
	 */
	public void setGlue(boolean glue) {
		this.glue = glue;
	}
	
	/**
	 * is the layer printable?
	 * 
	 * @return boolean
	 */
	public boolean isPrintable() {
		return printable;
	}
	
	/**
	 * set the layer printable
	 * 
	 * @param boolean
	 * @return void
	 */
	public void setPrintable(boolean printable) {
		this.printable = printable;
	}
	
	/**
	 * is the color <code>color</code> used as default color for a new draw object?
	 * 
	 * @return boolean
	 */
	public boolean isColorUsed() {
		return color_used;
	}
	
	/**
	 * set the color <code>color</code> used as color for a new draw object?
	 * 
	 * @return boolean
	 */
	public void setColorUsed(boolean color_used) {
		this.color_used = color_used;
	}
	
	/**
	 * align with the grid?
	 * 
	 * @return boolean
	 */
	public boolean isAlign() {
		return align;
	}
	
	/**
	 * set draw object alignable to the grid
	 * 
	 * @param boolean
	 * @return void
	 */
	public void setAlign(boolean align) {
		this.align = align;
	}

	@Override
	public String toString() {
		return "Layer [Name=" + name + ", drawobjects=" + drawobjects + ", color=" + color + ", visible=" + visible
				+ ", active=" + active + ", locked=" + locked + ", glue=" + glue + ", printable=" + printable
				+ ", color_used=" + color_used + ", align=" + align + "]";
	}
	
	
}
