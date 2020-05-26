package com.metho.bpmndesigner.entities;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.List;

public class Palette {
	private List<Color> palette = new ArrayList<Color>();		// the list of the colors
	
	/**
	 * default constructor
	 */
	public Palette(List<Color> palette) {
		super();
		this.palette = palette;
	}

	/**
	 * add color <code>color</code>
	 * 
	 * @param color: Color;
	 * @return int
	 */
	public int addColor(Color color) {
		return 20;
	}
	
}
