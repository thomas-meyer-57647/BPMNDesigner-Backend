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
 * 
 * String name									the name of layer
 * List<AbstractDrawObject> drawobjects			the objects on the layer
 * Color color									the color for <code>color_used</code>
 * boolean visible = true						visible of the drawobjects on this layer
 * boolean active = true						drawobjects can be selected
 * boolean locked = false						prevent or allow changes to the DrawObjects
 * boolean glue = false							ensures that connectors remain attached to DrawObjects
 * boolean printable = true						the layer is printable
 * boolean color_used = false					applies the assigned color to all DrawObjects on a layer
 * boolean align = true							align with the grid 
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
	 * If <code>drawobjects</code> is null this function will be throw
	 * an IllegalArgumentException
	 * 
	 * @param List<AbstractDrawObject>
	 * @return void
	 */
	public void setDrawobjects(List<AbstractDrawObject> drawobjects) {
		if ( drawobjects == null ) {
			throw new IllegalArgumentException("Layer::setDrawObjects(" + drawobjects + ": can not be null");
		}
		
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

	/**
	 * clone this layer
	 * 
	 * @return Layer
	 */
	public Layer clone() {
		Layer newLayer = new Layer();
		
		newLayer.name = this.name;
		newLayer.color = ( this.color == null) ? null : this.color.clone();
		newLayer.visible = this.visible;
		newLayer.active = this.active;
		newLayer.locked = this.locked;
		newLayer.glue = this.glue;
		newLayer.printable = this.printable;
		newLayer.color_used = this.color_used;
		newLayer.align = this.align;

		for( int index=0; index<this.drawobjects.size(); index++) {
			newLayer.drawobjects.add( this.drawobjects.get(index).clone() );
		}
		
		return newLayer; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (align ? 1231 : 1237);
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (color_used ? 1231 : 1237);
		result = prime * result + ((drawobjects == null) ? 0 : drawobjects.hashCode());
		result = prime * result + (glue ? 1231 : 1237);
		result = prime * result + (locked ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (printable ? 1231 : 1237);
		result = prime * result + (visible ? 1231 : 1237);
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
		Layer other = (Layer) obj;
		if (active != other.active)
			return false;
		if (align != other.align)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (color_used != other.color_used)
			return false;
		if (drawobjects == null) {
			if (other.drawobjects != null)
				return false;
		} else if (!drawobjects.equals(other.drawobjects))
			return false;
		if (glue != other.glue)
			return false;
		if (locked != other.locked)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (printable != other.printable)
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Layer [Name=" + name + ", drawobjects=" + drawobjects + ", color=" + color + ", visible=" + visible
				+ ", active=" + active + ", locked=" + locked + ", glue=" + glue + ", printable=" + printable
				+ ", color_used=" + color_used + ", align=" + align + "]";
	}
	
	
}
