package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * this is the gradient for a fill style
 */
public class GradientFillStyle extends Gradient implements IFillStyle {
	
	private EFillStyleType type = EFillStyleType.GRADIENT;
	
	/**
	 * default constructor
	 */
	public GradientFillStyle() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param type								LINEARGRADIENT | RADIALGRADIENT 
	 * @param name
	 * @param idname
	 * @param x1
	 * @param y1
	 * @param r1
	 * @param x2
	 * @param y2
	 * @param r2
	 * @param colorstops
	 */
	public GradientFillStyle(EGradientType type, String name, String idname, int x1, int y1, int r1, int x2, int y2,
			int r2, @NotNull List<ColorStop> colorstops) {
		super(type, name, idname, x1, y1, r1, x2, y2, r2, colorstops);
	}

	/**
	 * get the type of fill style
	 */
	@Override
	public EFillStyleType getFillStyleType() {
		return type;
	}


}
