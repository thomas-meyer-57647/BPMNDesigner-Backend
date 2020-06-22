package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * this is a Matrix for Transforming
 * 
 * float a
 * float b
 * float c
 * float d
 * float e
 * float f
 * 
 * the matrix is build by:
 * 
 * a | c | e
 * b | d | f
 * 0 | 0 | 1
 * 
 * a (m11)				Horizontal scaling. A value of 1 results in no scaling.
 * b (m12)				Vertical skewing.
 * c (m21)				Horizontal skewing.
 * d (m22)				Vertical scaling. A value of 1 results in no scaling.
 * e (dx)				Horizontal translation (moving).
 * f (dy)				Vertical translation (moving).
 *   
 * @see https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/transform
 */
public class Matrix {
	private float a;
	private float b;
	private float c;
	private float d;
	private float e;
	private float f;
	
	/**
	 * default constructor
	 */
	public Matrix() {
		super();
	}

	/**
	 * copy constructor
	 * 
	 * @param Matrix matrix
	 * @throws NullPointerException - if matrix is null
	 */
	public Matrix(Matrix matrix) {
		this.a = matrix.a;
		this.b = matrix.b;
		this.c = matrix.c;
		this.d = matrix.d;
		this.e = matrix.e;
		this.f = matrix.f;
	}
	
	// Getter / Setter
	/**
	 * get segment a of the matrix
	 * 
	 * @return float
	 */
	public float getA() {
		return a;
	}
	
	/**
	 * set segment a of the matrix
	 * 
	 * @param float
	 * @return void
	 */
	public void setA(float a) {
		this.a = a;
	}
	
	/**
	 * get segment b of the matrix
	 * 
	 * @return float
	 */
	public float getB() {
		return b;
	}
	
	/**
	 * set segment b of the matrix
	 * 
	 * @param float
	 * @return void
	 */
	public void setB(float b) {
		this.b = b;
	}
	
	/**
	 * get segment c of the matrix
	 * 
	 * @return float
	 */
	public float getC() {
		return c;
	}
	
	/**
	 * set segment c of the matrix
	 * 
	 * @param float
	 * @return void
	 */
	public void setC(float c) {
		this.c = c;
	}
	
	/**
	 * get segment d of the matrix
	 * 
	 * @return float
	 */
	public float getD() {
		return d;
	}
	
	/**
	 * set segment d of the matrix
	 * 
	 * @param float
	 * @return void
	 */
	public void setD(float d) {
		this.d = d;
	}
	
	/**
	 * get segment e of the matrix
	 * 
	 * @return float
	 */
	public float getE() {
		return e;
	}
	
	/**
	 * set segment e of the matrix
	 * 
	 * @param float
	 * @return void
	 */
	public void setE(float e) {
		this.e = e;
	}
	
	/**
	 * get segment f of the matrix
	 * 
	 * @return float
	 */
	public float getF() {
		return f;
	}
	
	/**
	 * set segment f of the matrix
	 * 
	 * @param float
	 * @return void
	 */
	public void setF(float f) {
		this.f = f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(a);
		result = prime * result + Float.floatToIntBits(b);
		result = prime * result + Float.floatToIntBits(c);
		result = prime * result + Float.floatToIntBits(d);
		result = prime * result + Float.floatToIntBits(e);
		result = prime * result + Float.floatToIntBits(f);
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
		Matrix other = (Matrix) obj;
		if (Float.floatToIntBits(a) != Float.floatToIntBits(other.a))
			return false;
		if (Float.floatToIntBits(b) != Float.floatToIntBits(other.b))
			return false;
		if (Float.floatToIntBits(c) != Float.floatToIntBits(other.c))
			return false;
		if (Float.floatToIntBits(d) != Float.floatToIntBits(other.d))
			return false;
		if (Float.floatToIntBits(e) != Float.floatToIntBits(other.e))
			return false;
		if (Float.floatToIntBits(f) != Float.floatToIntBits(other.f))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matrix [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + "]";
	}

	
}
