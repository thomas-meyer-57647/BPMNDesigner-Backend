package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * test function for the layer
 */
class LayerTest {

	/**
	 * test clone
	 */
	@Test
	void testClone() {
		// initialize values
		String name = "a layer";
		Color color = new Color(255);
		boolean visible = false;
		boolean active = false;
		boolean locked = true;
		boolean glue = true;
		boolean printable = false;
		boolean color_used = true;
		boolean align = false;
		
		DrawObject drawobject1 = new DrawObject();
		DrawObject drawobject2 = new DrawObject();
		
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(drawobject1);
		drawobjects.add(drawobject2);
		
		// create a layer
		Layer layer = new Layer();
		layer.setName(name);
		layer.setColor(color);
		layer.setVisible(visible);
		layer.setActive(active);
		layer.setLocked(locked);
		layer.setGlue(glue);
		layer.setPrintable(printable);
		layer.setColorUsed(color_used);
		layer.setAlign(align);
		
		// clone layer
		Layer newLayer = layer.clone();
		
		// check
		assertTrue( layer != newLayer );
		assertTrue( layer.getColor() != newLayer.getColor() );
		assertTrue( layer.getDrawobjects() != newLayer.getDrawobjects());
		assertEquals(layer, newLayer);
	}

}
