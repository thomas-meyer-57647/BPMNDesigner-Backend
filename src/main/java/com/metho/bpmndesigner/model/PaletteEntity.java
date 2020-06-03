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
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * this is a palette
 * 
 * int id;													the id of the collection
 * String name;												the name of the palette
 * List<Color> colors;										the colors of the palette
 */
@Document(collection="palettes")
@CompoundIndexes({
    @CompoundIndex(name = "user_palette", def = "{'createdBy.id' : 1, 'name': 1}, {unique: true}")
})
public class PaletteEntity implements IStoreable {
	
	@Transient
    public static final String SEQUENCE_NAME = "palette_sequence";
	
	@Id
	private long id;									// the id of the collection
	@Field("created_at")
	private LocalDateTime createdAt;					// the created date
	
	@DBRef
	@Field("created_by")
	private UserEntity createdBy;						// the creator
	
	@Field("updated_at")
	private LocalDateTime updatedAt;					// the last update date
	
	@DBRef
	@Field("update_by")
	private UserEntity updatedBy;						// the updater
	
	@Indexed
	private String name;								// the name of the palette
		
	@NotNull
	private List<Color> colors;							// the colors of the palette
	
	/**
	 * default constructor
	 */
	@PersistenceConstructor	
	public PaletteEntity() {
		super();
	}

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
	 * @return long
	 * @public
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set id of the palette
	 * 
	 * @param long
	 * @return void
	 * @public
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * get the first creation date
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * set the first creation date
	 * 
	 * @param LocalDateTime
	 * @return void
	 */
	public void setCreatedAt(LocalDateTime created_at) {
		this.createdAt = created_at;
	}
	
	/**
	 * get the first creator
	 * 
	 * @return User
	 */
	public UserEntity getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * set the first creator
	 * 
	 * @param UserEntity
	 * @return void
	 */
	public void setCreatedBy(UserEntity created_by) {
		this.createdBy = created_by;
	}
	
	/**
	 * get the last update
	 * 
	 * @return LocalDateTime
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * set the last update
	 * 
	 * @param LocalDateTime
	 * @return
	 */
	public void setUpdatedAt(LocalDateTime updated_at) {
		this.updatedAt = updated_at;
	}
	
	/**
	 * get the last updater
	 * 
	 * @return LocalDateTime
	 */
	public UserEntity getUpdatedBy() {
		return updatedBy;
	}
	
	/**
	 * set the last updater
	 * 
	 * @return LocalDateTime
	 */
	public void setUpdatedBy(UserEntity updated_by) {
		this.updatedBy = updated_by;
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
