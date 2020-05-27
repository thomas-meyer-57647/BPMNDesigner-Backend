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
	private IFillStyle fillStyle = null; 							     // will be only used for closed objects
	private IFillStyle strokeStyle = new ColorFillStyle(1);				 // the style for open objects (e.g. line)
	private LineDash lineDash = new LineDash(new ArrayList<Integer>());  // solid line dash 
	private ELineCap lineCap = ELineCap.BUTT;							 // line caps: BUTT
	private int lineWidth = 1;											 // the line width
	private List<Pair<String, String>> params;							 // additional information 
	
}
