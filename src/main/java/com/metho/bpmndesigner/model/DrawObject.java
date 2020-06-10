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
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.util.Pair;

/**
 * a draw object
 * 
 * String text;									text
 * TextDecoration decoration			 	 	the decoration for the text
 * Point textPosition							the text position
 * UUID uuid									internal reference number
 * List<Pair<String, String>> params			additional information 
 */
public class DrawObject extends NamedAbstractDrawObject implements ITextable, IConnectable, IGroupable {
	
	private String text;												 	 			// text

	@NotNull
	@Field("text_decoration")
	private TextDecoration textDecoration = new TextDecoration();			 	 		// the decoration for the text

	@NotNull
	@Field("text_position")
	private Point textPosition;
	
	private UUID uuid = null;															// internal reference number
	
	@NotNull
	private List<Pair<String, Object>> params = new ArrayList<Pair<String, Object>>();	// additional information 
		
	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public DrawObject() {
		super();
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
	}
	
	/**
	 * initialize constructor
	 * 
	 * This function throw a NullPointerException if the list 
	 * <code>points</code>, <code>drawObjectStyle</code>, <code>textDecoration</code>,
	 * <code>textPosition</code> or params is null
	 * 
	 * @param drawType
	 * @param name
	 * @param text
	 * @param points
	 * @param drawObjectStyle
	 * @param textDecoration
	 * @param textPosition
	 * @param params
	 * @throw NullPointerException			
	 */
	public DrawObject(
			EDrawType drawType, 
			String name, 
			String text,
			List<Point> points, 
			DrawObjectStyle drawObjectStyle,
			TextDecoration textDecoration,
			Point textPosition,
			List<Pair<String, Object>> params 
			
	) {
		super(drawType, name, points, drawObjectStyle);
		
		this.setText(text);
		this.setTextDecoration(textDecoration);
		this.setTextPosition(textPosition);
		this.setParams(params);
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
	}
	
	/**
	 * copy constructor
	 * 
	 * This function throw a NullPointerException if the list 
	 * <code>points</code>, <code>drawObjectStyle</code>, <code>textDecoration</code>,
	 * <code>textPosition</code> or params is null
	 * 
	 * @param drawObject
	 * @throw NullPointerException			
	 */
	public DrawObject(DrawObject drawObject) {
		this(
			drawObject.getDrawType(), 
			drawObject.getName(),
			drawObject.text,
			drawObject.getPoints(),
			drawObject.getDrawObjectStyle(),
			drawObject.textDecoration,
			drawObject.textPosition,
			drawObject.params 
		);
	}


	// GETTER / SETTER
	/**
	 * get the text of the draw object
	 * 
	 * @return String
	 */
	@Override
	public String getText() {
		return this.text;
	}
	
	/**
	 * set the text of the draw object
	 * 
	 * @param String
	 * @return
	 */
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * get the text decoration of the draw object
	 * 
	 * @return TextDecoration
	 */
	@Override
	public TextDecoration getTextDecoration() {
		return this.textDecoration;
	}
	
	/**
	 * set the text decoration of the draw object
	 * 
	 * If <code>decoration</code> null this function throws a 
	 * IllegalArgumentException
	 * 
	 * Note
	 * This function create a copy of <code>textDecoration</code>
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 * @throws IllegalArgumentException		- if param is null
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
	 * if <code>textPosition</code> null this function throw a NullPointerException
	 * 
	 * NOTE
	 * This function create a copy of <code>textPosition</code>
	 * 
	 * @param Point
	 * @return void
	 */
	@Override
	public void setTextPosition(Point textPosition) {
		this.textPosition = new Point(textPosition);
	}
	
	/**
	 * get additonal information of the draw object
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 */
	public List<Pair<String, Object>> getParams() {
		return this.params;
	}
	
	/**
	 * set additonal information of the draw object
	 * 
	 * If <code>params</code> is null this function throws a 
	 * IllegalArgumentException
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 * @throws IllegalArgumentException			- if param is null
	 */
	public void setParams(List<Pair<String, Object>> params) {
		List<Pair<String, Object>> newParamList = new ArrayList<Pair<String, Object>>();
		
		for(int index=0; index<params.size(); index++) {
			newParamList.add( Pair.of(params.get(index).getFirst(), params.get(index).getSecond()));
		}
		
		this.params = newParamList;
	}
	
	/**
	 * get the uuid of this object
	 * 
	 * @return UUID
	 */
	public UUID getUUID() {
		return this.uuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((params == null) ? 0 : params.hashCode());
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
		DrawObject other = (DrawObject) obj;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
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
		return "DrawObject [text=" + text + ", textDecoration=" + textDecoration + ", textPosition=" + textPosition
				+ ", uuid=" + uuid + ", params=" + params + ", getName()=" + getName() + ", getDrawType()="
				+ getDrawType() + ", getPoints()=" + getPoints() + ", getDrawObjectStyle()=" + getDrawObjectStyle()
				+ "]";
	}
}
