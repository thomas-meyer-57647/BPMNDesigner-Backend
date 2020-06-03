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

import org.springframework.data.util.Pair;

/**
 * a draw object
 * 
 * String name									the name of the draw object
 * List<Point> points				 			the points of the vector it must be minimal 2 points 
 * IStyle fillStyle 						   	will be only used for closed objects
 * IStyle strokeStyle				 		 	the style for open objects (e.g. line)
 * LineDash lineDash  							solid line dash 
 * ELineCap lineCap							 	line caps: BUTT
 * int lineWidth								the line width
 * String text									text
 * TextDecoration decoration			 		the decoration for the text
 * List<Pair<String, String>> params;			additional information 
 */
public class DrawObject extends AbstractDrawObject {
	private String name;												 // the name of the draw object
	private List<Point> points = new ArrayList<Point>();				 // the points of the vector it must be minimal 2 points 
	private IStyle fillStyle = null; 							     	 // will be only used for closed objects
	private IStyle strokeStyle = new ColorStyle(1);				 		 // the style for open objects (e.g. line)
	private LineDash lineDash = new LineDash(new ArrayList<Integer>());  // solid line dash 
	private ELineCap lineCap = ELineCap.BUTT;							 // line caps: BUTT
	private int lineWidth = 1;											 // the line width
	private String text;												 // text
	private TextDecoration decoration = new TextDecoration();			 // the decoration for the text
	private List<Pair<String, String>> params;							 // additional information 
	
	/**
	 * default constructor
	 * 
	 * @return void
	 */
	public DrawObject() {
		super();
	}
	
	/**
	 * initialize constructor
	 * 
	 * @param porints
	 */
	public DrawObject(List<Point> points) {
		super();
		this.points = points;
	}

	// GETTER / SETTER
	/**
	 * get the name of the draw object
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the draw object
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the points of the draw object
	 * 
	 * @return List<Point>
	 */
	public List<Point> getPoints() {
		return points;
	}
	
	/**
	 * set the points of the draw object
	 * 
	 * @oaran List<Point>
	 * @return void
	 */
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	/**
	 * get the fill style of the draw object
	 * 
	 * @return IStyle
	 */
	public IStyle getFillStyle() {
		return fillStyle;
	}
	
	/**
	 * set the fill style of the draw object
	 * 
	 * @oaran ISyle fillStyle
	 * @return void
	 */
	public void setFillStyle(IStyle fillStyle) {
		this.fillStyle = fillStyle;
	}

	/**
	 * get the stroke style of the draw object
	 * 
	 * @return ISyle 
	 */
	public IStyle getStrokeStyle() {
		return strokeStyle;
	}
	
	/**
	 * set the stroke style of the draw object
	 * 
	 * @oaran ISyle strokeStyle
	 * @return void
	 */
	public void setStrokeStyle(IStyle strokeStyle) {
		this.strokeStyle = strokeStyle;
	}
	
	/**
	 * get the linbdash of the draw object
	 * 
	 * @return LineDash
	 */
	public LineDash getLineDash() {
		return lineDash;
	}
	
	/**
	 * set the linedash of the draw object
	 * 
	 * @oaran LineDash fillStyle
	 * @return void
	 */
	public void setLineDash(LineDash lineDash) {
		this.lineDash = lineDash;
	}
	
	/**
	 * set the line cap of the draw object
	 * 
	 * @return ELineCap
	 */
	public ELineCap getLineCap() {
		return lineCap;
	}
	
	/**
	 * set the line cap of the draw object
	 * 
	 * @oaran ISyle fillStyle
	 * @return void
	 */
	public void setLineCap(ELineCap lineCap) {
		this.lineCap = lineCap;
	}
	
	/**
	 * get the line with of the draw object
	 * 
	 * @return int
	 */
	public int getLineWidth() {
		return lineWidth;
	}
	
	/**
	 * set the line with of the draw object
	 * 
	 * @param int linewith
	 * @return void
	 */
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
	
	/**
	 * get the text of the draw object
	 * 
	 * @return String
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * set the text of the draw object
	 * 
	 * @param String
	 * @return
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * get the text decoration of the draw object
	 * 
	 * @return TextDecoration
	 */
	public TextDecoration getDecoration() {
		return decoration;
	}
	
	/**
	 * set the text decoration of the draw object
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 */
	public void setDecoration(TextDecoration decoration) {
		this.decoration = decoration;
	}
	
	/**
	 * get additonal information of the draw object
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 */
	public List<Pair<String, String>> getParams() {
		return params;
	}
	
	/**
	 * set additonal information of the draw object
	 * 
	 * @param TextDecoration decoration
	 * @return void
	 */
	public void setParams(List<Pair<String, String>> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DrawObject [name=" + name + ", points=" + points + ", fillStyle=" + fillStyle + ", strokeStyle="
				+ strokeStyle + ", lineDash=" + lineDash + ", lineCap=" + lineCap + ", lineWidth=" + lineWidth
				+ ", text=" + text + ", decoration=" + decoration + ", params=" + params + "]";
	}

}
