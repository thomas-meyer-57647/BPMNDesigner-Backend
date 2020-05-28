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
	private String Name;									// the name of layer
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

	// GETTER / SETTER
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<AbstractDrawObject> getDrawobjects() {
		return drawobjects;
	}

	public void setDrawobjects(List<AbstractDrawObject> drawobjects) {
		this.drawobjects = drawobjects;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isGlue() {
		return glue;
	}

	public void setGlue(boolean glue) {
		this.glue = glue;
	}

	public boolean isPrintable() {
		return printable;
	}

	public void setPrintable(boolean printable) {
		this.printable = printable;
	}

	public boolean isColor_used() {
		return color_used;
	}

	public void setColor_used(boolean color_used) {
		this.color_used = color_used;
	}

	public boolean isAlign() {
		return align;
	}

	public void setAlign(boolean align) {
		this.align = align;
	}

	@Override
	public String toString() {
		return "Layer [Name=" + Name + ", drawobjects=" + drawobjects + ", color=" + color + ", visible=" + visible
				+ ", active=" + active + ", locked=" + locked + ", glue=" + glue + ", printable=" + printable
				+ ", color_used=" + color_used + ", align=" + align + "]";
	}
	
	
}
