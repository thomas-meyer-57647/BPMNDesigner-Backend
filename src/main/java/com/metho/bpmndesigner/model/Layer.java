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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Field;

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

	@NotBlank
    @Size(max=100)	
	private String name;									// the name of layer
	
    @Size(max=100)	
	private String title;									// the title of layer
	
	private String description;								// the description of layer
	
	@NotNull
	@Field("draw_objects")	
	private List<IGroupable> drawobjects = new ArrayList<IGroupable>();

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
	 * get the title of the layer
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set the title of the layer
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * get the description of the layer
	 * 
	 * @param title
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * set the description of the layer
	 * 
	 * @param title
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get the draw objects or group of this layer
	 * 
	 * @param List<IGroupable>
	 * @return void
	 */
	public List<IGroupable> getDrawobjects() {
		return drawobjects;
	}
	
	/**
	 * set the draw objects or group of this layer
	 * 
	 * @param List<AbstractDrawObject>
	 * @return void
	 */
	public void setDrawObjects(List<IGroupable> drawobjects) {
		this.drawobjects = (drawobjects == null) ? new ArrayList<IGroupable>() : drawobjects;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (align ? 1231 : 1237);
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (color_used ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((drawobjects == null) ? 0 : drawobjects.hashCode());
		result = prime * result + (glue ? 1231 : 1237);
		result = prime * result + (locked ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (printable ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Layer [name=" + name + ", title=" + title + ", description=" + description + ", drawobjects="
				+ drawobjects + ", color=" + color + ", visible=" + visible + ", active=" + active + ", locked="
				+ locked + ", glue=" + glue + ", printable=" + printable + ", color_used=" + color_used + ", align="
				+ align + "]";
	}

	
}
