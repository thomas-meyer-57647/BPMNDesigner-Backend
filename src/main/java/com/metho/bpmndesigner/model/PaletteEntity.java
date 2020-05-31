package com.metho.bpmndesigner.model;
import java.time.LocalDateTime;
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
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * this is a palette
 * 
 * int id;													the id of the collection
 * String name;												the name of the palette
 * List<Color> colors;										the colors of the palette
 */
@Document(collection="palettes")
public class PaletteEntity implements IStoreable {
	
	@Transient
    public static final String SEQUENCE_NAME = "team_sequence";
	
	@Id
	private int id;										// the id of the collection
	private LocalDateTime created_at;					// the created date
	
	@DBRef
	private UserEntity created_by;						// the creator
	
	private LocalDateTime updated_at;					// the last update date
	
	@DBRef
	private UserEntity updated_by;						// the updater
	
	@Indexed
	private String name;								// the name of the palette
		
	@NotNull
	private List<Color> colors;							// the colors of the palette

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
	 * get the first creation date
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getCreatedAt() {
		return created_at;
	}
	
	/**
	 * set the first creation date
	 * 
	 * @param LocalDateTime
	 * @return void
	 */
	public void setCreatedAt(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	/**
	 * get the first creator
	 * 
	 * @return User
	 */
	public UserEntity getCreatedBy() {
		return created_by;
	}
	
	/**
	 * set the first creator
	 * 
	 * @param UserEntity
	 * @return void
	 */
	public void setCreatedBy(UserEntity created_by) {
		this.created_by = created_by;
	}
	
	/**
	 * get the last update
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getUpdatedAt() {
		return updated_at;
	}
	
	/**
	 * set the last update
	 * 
	 * @param LocalDateTime
	 * @return
	 */
	public void setUpdatedAt(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	/**
	 * get the last updater
	 * 
	 * @return LocalDateTime
	 */
	public UserEntity getUpdatedBy() {
		return updated_by;
	}
	
	/**
	 * set the last updater
	 * 
	 * @return LocalDateTime
	 */
	public void setUpdatedBy(UserEntity updated_by) {
		this.updated_by = updated_by;
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
