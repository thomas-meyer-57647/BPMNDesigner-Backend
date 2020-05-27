package com.metho.bpmndesigner.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Pair;

/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

/**
 * a draw object
 */
public class DrawObject {
	private String name;												 // the name of the draw object
	private List<Point> porints = new ArrayList<Point>();				 // the points of the vector it must be minimal 2 points 
	private IStyle fillStyle = null; 							     	 // will be only used for closed objects
	private IStyle strokeStyle = new ColorStyle(1);				 		 // the style for open objects (e.g. line)
	private LineDash lineDash = new LineDash(new ArrayList<Integer>());  // solid line dash 
	private ELineCap lineCap = ELineCap.BUTT;							 // line caps: BUTT
	private int lineWidth = 1;											 // the line width
	private String text;												 // text
	private TextDecoration decoration = new TextDecoration();			 // the decoration for the text
	private List<Pair<String, String>> params;							 // additional information 
	
	/**
	 * initialize constructor
	 * 
	 * @param porints
	 */
	public DrawObject(List<Point> porints) {
		super();
		this.porints = porints;
	}

	// GETTER / SETTER
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Point> getPorints() {
		return porints;
	}

	public void setPorints(List<Point> porints) {
		this.porints = porints;
	}

	public IStyle getFillStyle() {
		return fillStyle;
	}

	public void setFillStyle(IStyle fillStyle) {
		this.fillStyle = fillStyle;
	}

	public IStyle getStrokeStyle() {
		return strokeStyle;
	}

	public void setStrokeStyle(IStyle strokeStyle) {
		this.strokeStyle = strokeStyle;
	}

	public LineDash getLineDash() {
		return lineDash;
	}

	public void setLineDash(LineDash lineDash) {
		this.lineDash = lineDash;
	}

	public ELineCap getLineCap() {
		return lineCap;
	}

	public void setLineCap(ELineCap lineCap) {
		this.lineCap = lineCap;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TextDecoration getDecoration() {
		return decoration;
	}

	public void setDecoration(TextDecoration decoration) {
		this.decoration = decoration;
	}

	public List<Pair<String, String>> getParams() {
		return params;
	}

	public void setParams(List<Pair<String, String>> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DrawObject [name=" + name + ", porints=" + porints + ", fillStyle=" + fillStyle + ", strokeStyle="
				+ strokeStyle + ", lineDash=" + lineDash + ", lineCap=" + lineCap + ", lineWidth=" + lineWidth
				+ ", text=" + text + ", decoration=" + decoration + ", params=" + params + "]";
	}
}
