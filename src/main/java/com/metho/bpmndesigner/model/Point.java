package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * a point of a draw object
 */
public class Point {
	private int x;
	private int y;
	
	/**
	 * default constructor
	 */
	public Point() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		super();
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * copy constructor
	 * 
	 * @param Point
	 * @throws NullPointerException
	 */
	public Point(Point point) {
		super();
		
		this.x = point.x;
		this.y = point.y;
	}

	/**
	 * get x value
	 * 
	 * @return int
	 */
	public int getX() {
		return x;
	}

	/**
	 * set x value
	 * 
	 * @param int x
	 * @return void
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * get y value
	 * 
	 * @return int
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * set y value
	 * 
	 * @param int y
	 * @return void
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}
