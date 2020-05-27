package com.metho.bpmndesigner.model;
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
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * this is a palette
 */
@Document(collection="palettes")
public class PaletteEntity {
	
	/**
	 * the id of the collection
	 */
	@Id
	private int id;
	
	/**
	 * the name of the palette
	 */
	private String name;
		
	/**
	 * the colors of the palette
	 */
	@NotNull
	private List<Color> colors;

	/**
	 * initialize constructor
	 * 
	 * @param name
	 * @param colors
	 */
	public PaletteEntity(String name, @NotNull List<Color> colors) {
		super();
		
		this.name = name;
		this.colors = colors;
	}

	/**
	 * initialize constructor
	 * 
	 * @param colors
	 */
	public PaletteEntity(@NotNull List<Color> colors) {
		this(null, colors);
	}
	
	/**
	 * get id of the palette
	 * 
	 * @return int
	 * @public
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * get name of the palette
	 * 
	 * @return int
	 * @public
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set name of the palette
	 * 
	 * @param String name
	 * @return void
	 * @public
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get colors of the palette
	 * 
	 * @return List<Color>
	 * @public
	 */
	public List<Color> getColors() {
		return colors;
	}
	
	/**
	 * set colors of the palette
	 * The <code>colors</code> could not be null
	 * 
	 * @param List<Color>
	 * @return void
	 * @public
	 */
	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Palette [id=" + id + ", name=" + name + ", colors=" + colors + "]";
	}	
}
