package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * this is a pattern which was used in <code>PatternFillStyle</code> for a fillStyle
 * or Stroke Style
 */
public class Pattern {
	private String newfilename;
	private String orignalFilename;
	private EPatternRepeat repeat;
	private Matrix matrix;
	
	/**
	 * default constructor
	 */
	public Pattern() {
		super();
	}

	// Getter / Setter
	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public String getOrignalFilename() {
		return orignalFilename;
	}

	public void setOrignalFilename(String orignalFilename) {
		this.orignalFilename = orignalFilename;
	}

	public EPatternRepeat getRepeat() {
		return repeat;
	}

	public void setRepeat(EPatternRepeat repeat) {
		this.repeat = repeat;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	@Override
	public String toString() {
		return "Pattern [newfilename=" + newfilename + ", orignalFilename=" + orignalFilename + ", repeat=" + repeat
				+ ", matrix=" + matrix + "]";
	}
	
}
