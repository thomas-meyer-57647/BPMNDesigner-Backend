package com.metho.bpmndesigner.model;

import java.util.UUID;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is a image
 *
 * String name												name of the draw object
 * String text												text of the draw object
 * TextDecoration textDecoration							the text decoration
 * Point textPosition										the position of the text
 * UUID uuid												the UUID
 */
public class Image extends AbstractImage implements IConnectable, IGroupable, INameable, ITextable {

	@NotBlank
    @Size(max=100)	
	String name;												// name of the draw object
	String text;												// text of the draw object
	
	@Field("text_decoration")
	TextDecoration textDecoration = new TextDecoration();		// the text decoration

	@Field("text_position")
	Point textPosition = new Point(0, 0);						// the position of the text
	
	UUID uuid;													// the UUID
	
	/**
	 * default constructor
	 */
	public Image() {
		super();
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
	}
	
	/**
	 * initialize constructor
	 * 
	 * This construtor throw a NullPointerException if <code>textDecoration</code>,
	 * <code>textPosition</code> or <code>matrix</code> is null
	 * 
	 * NOTE
	 * This constructor create a copy of <code>textDecoration</code>,
	 * <code>textPosition</code> and <code>matrix</code>
	 * 	
	 * @param name
	 * @param text
	 * @param textDecoration
	 * @param textPosition
	 * @param newFilename
	 * @param originalFilename
	 * @param matrix
	 * @throw NullPointerException 
	 */
	public Image(String name, String text, TextDecoration textDecoration, Point textPosition, String newFilename, String originalFilename, Matrix matrix) {
		super(newFilename, originalFilename, matrix);
		
		this.setName(name);
		this.setText(text);
		this.setTextDecoration(textDecoration);
		this.setTextPosition(textPosition);
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
	}
	
	/**
	 * copy constructor
	 * 
	 * Details see initialize constructor
	 * 
	 * @param abstractImage
	 * @throws NullPointerException - if abstractImage is null
	 */
	public Image(AbstractImage abstractImage) {
		super(abstractImage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the text of this image
	 * 
	 * @return String
	 */
	@Override
	public String getText() {
		return this.text;
	}
	
	/**
	 * set the text of this image
	 * 
	 * @return String
	 */
	@Override
	public void setText(String text) {
		this.text = text;

	}
	
	/**
	 * get the text decoration of this image
	 * 
	 * @return String
	 */
	@Override
	public TextDecoration getTextDecoration() {
		return this.textDecoration;
	}

	/**
	 * set the text decoration of this image
	 * 
	 * If <code>textDecoation</code> null this function throw a NullPointerException
	 * 
	 * NOTE
	 * This function create a copy of the textDecoration
	 * 
	 * @param TextDecoartion textDecoation
	 * @return void
	 */
	@Override
	public void setTextDecoration(TextDecoration textDecoration) {
		this.textDecoration = new TextDecoration(textDecoration);
	}

	/**
	 * get the text position
	 * 
	 * @return Point
	 */
	@Override
	public Point getTextPosition() {
		return this.textPosition;
	}
	
	/**
	 * set the text position
	 * 
	 * If <code>point</code> is null this function throw a NullPointerException
	 * 
	 * NOTE
	 * This function create a copy of the point
	 * 
	 * @return Point
	 * @throws NullPointerException
	 */
	@Override
	public void setTextPosition(Point point) {
		this.textPosition = new Point(point);
	}

	/**
	 * get the name
	 * 
	 * @return String
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * set the name
	 * 
	 * @param String name
	 * @return void
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the uuid of this image
	 * 
	 * @return UUID
	 */
	@Override
	public UUID getUUID() {
		return this.uuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((textDecoration == null) ? 0 : textDecoration.hashCode());
		result = prime * result + ((textPosition == null) ? 0 : textPosition.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (textDecoration == null) {
			if (other.textDecoration != null)
				return false;
		} else if (!textDecoration.equals(other.textDecoration))
			return false;
		if (textPosition == null) {
			if (other.textPosition != null)
				return false;
		} else if (!textPosition.equals(other.textPosition))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Image [name=" + name + ", text=" + text + ", textDecoration=" + textDecoration + ", textPosition="
				+ textPosition + ", uuid=" + uuid + ", getNewFilename()=" + getNewFilename()
				+ ", getOriginalFilename()=" + getOriginalFilename() + ", getMatrix()=" + getMatrix() + "]";
	}

}
