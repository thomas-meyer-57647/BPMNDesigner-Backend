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

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * this is a connector between two DrawObjects
 * 
 * Association startAssociation					the uuid of the draw object at the start point
 * Association endAssociation;					the uuid of the draw object at the end point
 * String text									text
 * TextDecoration textDecoration				the decoration for the text
 * Point textPosition							the text position relativ to the center
 * UUID uuid									the UUID of this connector
 */
public class Connector extends NamedAbstractDrawObject implements ITextable, IConnectable {
	@Field("start_association")
	Association startAssociation;					// the uuid of the draw object at the start point

	@Field("end_association")
	Association endAssociation;					    // the uuid of the draw object at the end point

	private String text;							// text

	@NotNull
	@Field("text_decoration")
	private TextDecoration textDecoration = new TextDecoration();	// the decoration for the text

	@NotNull
	@Field("text_position")
	private Point textPosition = new Point();		// the text position relativ to the center

	@NotNull
	private UUID uuid = null;						// the UUID of this connector
	
	/**
	 * default constructor 
	 */
	public Connector() {
		super();
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}		
	}

	/**
	 * initialize constructor
	 * 
	 * If <code>startAssociation</code>, <code>endAssociation</code>, <code>points</code>,
	 * <code>textPosition</code>, <code>drawObjectStyle</code> or <code>textDecoration</code>
	 * is null this function throws a NullPointerException
	 * 
	 * @param drawType
	 * @param name
	 * @param startAssociation
	 * @param endAssociation
	 * @param points
	 * @param textPosition
	 * @param drawObjectStyle
	 * @param text
	 * @param textDecoration
	 * @throws NullPointerException
	 */
	public Connector(
			EDrawType drawType, 
			String name,
			Association startAssociation, 
			Association endAssociation, 
			List<Point> points, 
			Point textPosition,
			DrawObjectStyle drawObjectStyle,
			String text,
			TextDecoration textDecoration
			) {
		super(drawType, name, points, drawObjectStyle);
		
		this.setStartAssociation(startAssociation);
		this.setEndAssociation(endAssociation);
		this.setTextPosition(textPosition);
		this.setTextDecoration(textDecoration);
		this.text = text;
		
		if ( this.uuid == null ) {
			uuid = UUID.randomUUID();
		}
	}

	/**
	 * copy constructor
	 */
	public Connector(Connector connector) {
		this(
			connector.getDrawType(),
			connector.getName(),
			connector.getStartAssociation(),
			connector.getEndAssociation(),
			connector.getPoints(),
			connector.getTextPosition(),
			connector.getDrawObjectStyle(),
			connector.getText(),
			connector.getTextDecoration()
		);
	}
	
	/**
	 * get the uuid of the start draw object
	 * 
	 * @return Association
	 */
	public Association getStartAssociation() {
		return this.startAssociation;
	}

	/**
	 * get the uuid of the start draw object
	 * 
	 * @param Association startAssociation
	 * @return void
	 * @throw NullPointerException - if <code>startAssociation</code> is null
	 */
	public void setStartAssociation(Association startAssociation) {
		this.startAssociation = new Association(startAssociation);
	}
	
	/**
	 * get the uuid of the end draw object
	 * 
	 * @return Association
	 */
	public Association getEndAssociation() {
		return this.endAssociation;
	}
	
	/**
	 * get the uuid of the end draw object
	 * 
	 * @param Association endAssociation
	 * @throw NullPointerException - if <code>endAssociation</code> is null
	 */
	public void setEndAssociation(Association endAssociation) {
		this.endAssociation = new Association(endAssociation);
	}
	
	/**
	 * get the uuid of this connector
	 * 
	 * @return UUID
	 */
	@Override
	public UUID getUUID() {
		return this.uuid;
	}
	
	/**
	 * get the text of this connector
	 * 
	 * @return text
	 */
	@Override
	public String getText() {
		return this.text;
	}
	
	/**
	 * set the text of this connector
	 *
	 * @param String text
	 * @retun void
	 **/
	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * get the text decoration of the text from this drawing object
	 * 
	 * @return TextDecoration 
	 */
	@Override
	public TextDecoration getTextDecoration() {
		return this.textDecoration;
	}

	/**
	 * set the text decoration of the text from this drawing object
	 * 
	 * If <code>textDecoration</code> null this function throw a NullPointerException
	 * 
	 * NOTE
	 * This function create a copy of the given <code>textDecoration</code>
	 * 
	 * @param TextDecoration textDecoration
	 * @return void
	 * @throw NullPointerException
	 */
	@Override
	public void setTextDecoration(TextDecoration textDecoration) {
		this.textDecoration = new TextDecoration(textDecoration);
	}

	/**
	 * get the position of the text from this drawing object
	 * 
	 * @return Point
	 */
	@Override
	public Point getTextPosition() {
		return this.textPosition;
	}

	/**
	 * set the position of the text from this drawing object
	 * 
	 * If <code>point</code> null this function throw a NullPointerException
	 * 
	 * NOTE
	 * This function create a copy of <code>point</code> for this draw object
	 * 
	 * @param Point point
	 * @return void
	 * @throws NullPointerException
	 */
	@Override
	public void setTextPosition(Point point) {
		this.textPosition = new Point(point);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endAssociation == null) ? 0 : endAssociation.hashCode());
		result = prime * result + ((startAssociation == null) ? 0 : startAssociation.hashCode());
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
		Connector other = (Connector) obj;
		if (endAssociation == null) {
			if (other.endAssociation != null)
				return false;
		} else if (!endAssociation.equals(other.endAssociation))
			return false;
		if (startAssociation == null) {
			if (other.startAssociation != null)
				return false;
		} else if (!startAssociation.equals(other.startAssociation))
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
		return "Connector [startAssociation=" + startAssociation + ", endAssociation=" + endAssociation + ", text="
				+ text + ", textDecoration=" + textDecoration + ", textPosition=" + textPosition + ", uuid=" + uuid
				+ ", getName()=" + getName() + ", getDrawType()=" + getDrawType() + ", getPoints()=" + getPoints()
				+ ", getDrawObjectStyle()=" + getDrawObjectStyle() + "]";
	}
}
