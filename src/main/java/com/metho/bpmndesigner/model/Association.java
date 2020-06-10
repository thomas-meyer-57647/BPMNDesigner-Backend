package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.UUID;

import javax.validation.constraints.NotNull;

/**
 * this is an association side of two draw objects
 * 
 * UUID uuid					the associated draw object
 */
public class Association {
	@NotNull
	private UUID uuid;						// the associated draw object
	
	private Arrow arrow = new Arrow();		// the kind of arrow
	
	@NotNull
	private Point point;					// the point at the connected draw object
	
	/**
	 * default constructor
	 */
	public Association() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param uuid
	 * @param arrow
	 * @throws NullPointerException - if arrow is null
	 */
	public Association(@NotNull UUID uuid, Arrow arrow, @NotNull Point point) {
		super();
		
		this.setUUID(uuid);
		this.setArrow(arrow);
		this.setPoint(point);
	}

	/**
	 * copy constructor
	 * 
	 * @throws NullPointerException - if <code>association</code> is null
	 */
	public Association(Association association) {
		this( association.uuid, association.arrow, association.point );
	}

	/**
	 * get the UUID of the assoziated object
	 * 
	 * @return UUID
	 */
	public UUID getUUID() {
		return uuid;
	}
	
	/**
	 * set the UUID of the assoziated object
	 * 
	 * @return UUID
	 */
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * get the Arrow of the assoziation
	 * 
	 * @return Arrow
	 */
	public Arrow getArrow() {
		return arrow;
	}
	
	/**
	 * set the Arrow of the assoziation
	 * 
	 * @param Arrow
	 * @return void
	 * @throws NullPointerException - if arrow is null
	 */
	public void setArrow(Arrow arrow) {
		this.arrow = (arrow == null) ? null : new Arrow(arrow);
	}

	/**
	 * get the point at the uuid object
	 * 
	 * @return
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * set the point at the uuid object
	 * 
	 * @param point
	 * @throws NullPointerException - if point is null
	 */
	public void setPoint(Point point) {
		this.point = new Point(point);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrow == null) ? 0 : arrow.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
		Association other = (Association) obj;
		if (arrow == null) {
			if (other.arrow != null)
				return false;
		} else if (!arrow.equals(other.arrow))
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
		return "Association [uuid=" + uuid + ", arrow=" + arrow + "]";
	}	
}
