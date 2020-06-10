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
 * 
 * EPatternRepeat repeat						the repeat for the PatternStyle
 */
public class Pattern extends AbstractImage {
	
	private EPatternRepeat repeat = EPatternRepeat.REPEAT;			// the repeat for the PatternStyle
	
	/**
	 * default constructor
	 */
	public Pattern() {
		super();
	}
	
    /**
     * initialize constructor
     * 
     * @param newFilename
     * @param originalFilename
     * @param repeat
     * @param matrix
     * @throw NullPointerException
     */
	public Pattern(String newFilename, String originalFilename, EPatternRepeat repeat, Matrix matrix) {
		super(newFilename, originalFilename, matrix);
		
		this.repeat = repeat;
	}

	/**
	 * copy constructor
	 * 
	 * @param Pattern pattern
	 * @throws NullPointerException - if pattern is null
	 */
	public Pattern(Pattern pattern) {
		super(pattern);
		
		this.repeat = pattern.repeat;
	}

	// Getter / Setter
	/**
	 * get the repeating of the pattern
	 * 
	 * @return EPatternRepeat
	 */
	public EPatternRepeat getRepeat() {
		return repeat;
	}
	
	/**
	 * set the repeating of the pattern
	 * 
	 * @param EPatternRepeat
	 * @return void
	 */
	public void setRepeat(EPatternRepeat repeat) {
		this.repeat = repeat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((repeat == null) ? 0 : repeat.hashCode());
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
		Pattern other = (Pattern) obj;
		if (repeat != other.repeat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pattern [repeat=" + repeat + ", getNewFilename()=" + getNewFilename() + ", getOriginalFilename()="
				+ getOriginalFilename() + ", getMatrix()=" + getMatrix() + "]";
	}
}
