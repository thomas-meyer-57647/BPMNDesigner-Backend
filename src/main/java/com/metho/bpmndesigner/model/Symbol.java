package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is a symbol
 *
 * String name												name of the draw object
 * String text												text of the draw object
 * TextDecoration textDecoration							the text decoration
 * Point textPosition										the position of the text
 * UUID uuid												the UUID
 */
public class Symbol extends GroupAbstractDrawObject implements ITextable, INameable, IGroupable, IConnectable  {

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
	public Symbol() {
		super();
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
	}
	
	/**
	 * initialize cnstructor
	 * 
	 * This constructor throws a NullPointerException if <code>textDecoration</code>,
	 * <code>textPosition</code> or <code>drawobjects</code> is null
	 * 
	 * NOTE
	 * The constructor create a copy of <code>TextDecoration</code>, <code>textPosition</code>,
	 * and <code>drawObjects</code>
	 * 
	 * @param Symbol symbol
	 * @throws NullPointerException 
	 */
	public Symbol(String name, String text, TextDecoration textDecoration, Point textPosition, List<AbstractDrawObject> drawobjects) {
		super(drawobjects);
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
		
		this.setName(name);
		this.setText(text);
		this.setTextDecoration(textDecoration);
		this.setTextPosition(textPosition);
	}
	
	/**
	 * copy constructor
	 * 
	 * this constructor throw a NullPointerException, if <code>symbol</code> is
	 * null
	 * 
	 * @param Symbol symbol
	 * @throws NullPointerException - if <code>symbol</code> is null
	 */
	public Symbol(Symbol symbol) {
		this(
			symbol.name, 
			symbol.text, 
			symbol.textDecoration, 
			symbol.textPosition, 
			symbol.getDrawObjects()				
		);
	}

	/**
	 * get the uuid of this draw object
	 * 
	 * @return uuid
	 */
	@Override
	public UUID getUUID() {
		return this.uuid;
	}
	
	/**
	 * get the name of this draw object
	 * 
	 * @return String
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * set the name of this draw object
	 * 
	 * @param String name
	 * @return void
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the text of this draw object
	 * 
	 * @return String
	 */
	@Override
	public String getText() {
		return this.text;
	}
	
	/**
	 * set the text of this draw object
	 * 
	 * @param String text
	 * @return void
	 */
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * get the text decoration of this draw object
	 * 
	 * @return TextDecoration
	 */
	@Override
	public TextDecoration getTextDecoration() {
		return this.textDecoration;
	}
	
	/**
	 * set the text decoration of this draw object
	 * 
	 * @param TextDecoration
	 * @return void
	 */
	@Override
	public void setTextDecoration(TextDecoration textDecoration) {
		this.textDecoration = new TextDecoration(textDecoration);
	}
	
	/**
	 * get the text position of this draw object
	 * 
	 * @return Point
	 */
	@Override
	public Point getTextPosition() {
		return this.textPosition;
	}
	
	/**
	 * set the text position of this draw object
	 * 
	 * @param Point textPosition
	 * @return void
	 */
	@Override
	public void setTextPosition(Point textPosition) {
		this.textPosition = new Point(textPosition);
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
		Symbol other = (Symbol) obj;
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
		return "Symbol [name=" + name + ", text=" + text + ", textDecoration=" + textDecoration + ", textPosition="
				+ textPosition + ", uuid=" + uuid + ", getDrawObjects()=" + getDrawObjects() + "]";
	}

}
