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
 * a | b | c
 * d | e | f
 * 0 | 0 | 1
 * 
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

	/**
	 * clone this martix
	 * 
	 * @return newMatrix
	 */
	public Matrix clone() {
		Matrix newMatrix = new Matrix();
		
		newMatrix.a = this.a;
		newMatrix.b = this.b;
		newMatrix.c = this.c;
		newMatrix.d = this.d;
		newMatrix.e = this.e;
		newMatrix.f = this.f;
		
		return newMatrix;
	}
	
	@Override
	public String toString() {
		return "Matrix [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + "]";
	}

	
}
