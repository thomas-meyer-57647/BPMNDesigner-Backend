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
import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * the test function for <code>Connector</code>
 */
class ConnectorTest {

	/**
	 * test constructor
	 */
	@Test
	void testConstructor() {
		Connector connector = new Connector();
		
		assertNotNull(connector);
		assertTrue(connector.getUUID().toString().length() > 0 );
	}
	
	/**
	 * test initialize constructor
	 */
	@Test
	void testInitializeConstructor() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		assertNotNull(connector);
		assertTrue(connector.getUUID().toString().length() > 0 );
		assertTrue(startAssociation != connector.getStartAssociation());
		assertTrue(endAssociation != connector.getEndAssociation());
		assertTrue(points != connector.getPoints());
		assertTrue(textPosition != connector.getTextPosition());
		assertTrue(drawObjectStyle != connector.getDrawObjectStyle());
		assertTrue(textDecoration != connector.getTextDecoration());

		assertEquals(drawType, connector.getDrawType());
		assertEquals(name, connector.getName());
		assertEquals(startAssociation, connector.getStartAssociation());
		assertEquals(endAssociation, connector.getEndAssociation());
		assertEquals(points, connector.getPoints());
		assertEquals(textPosition, connector.getTextPosition());
		assertEquals(drawObjectStyle, connector.getDrawObjectStyle());
		assertEquals(text, connector.getText());
		assertEquals(textDecoration, connector.getTextDecoration());
	}
	
	/**
	 * test initialize constructor with null start associton should throw NullPointerException
	 */
	@Test
	void testInitializeConstructorWithNullStartPositionShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = null; // new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		boolean exception = false;
		try {
			@SuppressWarnings("unused")
			Connector connector = new Connector(
					drawType, 
					name,
					startAssociation, 
					endAssociation, 
					points, 
					textPosition,
					drawObjectStyle,
					text,
					textDecoration
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null end associton should throw NullPointerException
	 */
	@Test
	void testInitializeConstructorWithNullEndPositionShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = null; // new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		boolean exception = false;
		try {
			@SuppressWarnings("unused")
			Connector connector = new Connector(
					drawType, 
					name,
					startAssociation, 
					endAssociation, 
					points, 
					textPosition,
					drawObjectStyle,
					text,
					textDecoration
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null points should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullPointsShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = null; // new ArrayList<Point>();
//		points.add(new Point(1, 2));
//		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		boolean exception = false;
		try {
			Connector connector = new Connector(
					drawType, 
					name,
					startAssociation, 
					endAssociation, 
					points, 
					textPosition,
					drawObjectStyle,
					text,
					textDecoration
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null text position should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullTextPositionShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = null; // new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		boolean exception = false;
		try {
			Connector connector = new Connector(
					drawType, 
					name,
					startAssociation, 
					endAssociation, 
					points, 
					textPosition,
					drawObjectStyle,
					text,
					textDecoration
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null draw object style should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullDrawObjectStyleShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = null; // new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		boolean exception = false;
		try {
			Connector connector = new Connector(
					drawType, 
					name,
					startAssociation, 
					endAssociation, 
					points, 
					textPosition,
					drawObjectStyle,
					text,
					textDecoration
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test initialize constructor with null text decoration should throw NullPointerException
	 */
	@SuppressWarnings("unused")
	@Test
	void testInitializeConstructorWithNullTextDecorationShouldThrowNullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = null; // new TextDecoration();
		
		boolean exception = false;
		try {
			Connector connector = new Connector(
					drawType, 
					name,
					startAssociation, 
					endAssociation, 
					points, 
					textPosition,
					drawObjectStyle,
					text,
					textDecoration
			);
		} catch (NullPointerException e) {
			exception = true;
		}
		assertTrue(exception);
	}
	
	/**
	 * test copy constructor
	 */
	@Test
	void testCopyConstructor() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);

		Connector copyConnector = new Connector(connector);
		
		assertNotNull(copyConnector);
		assertTrue(copyConnector.getUUID().toString().length() > 0 );
		assertTrue(connector.getStartAssociation() != copyConnector.getStartAssociation());
		assertTrue(connector.getEndAssociation() != copyConnector.getEndAssociation());
		assertTrue(connector.getPoints() != copyConnector.getPoints());
		assertTrue(connector.getTextPosition() != copyConnector.getTextPosition());
		assertTrue(connector.getDrawObjectStyle() != copyConnector.getDrawObjectStyle());
		assertTrue(connector.getTextDecoration() != copyConnector.getTextDecoration());

		assertEquals(connector.getDrawType(), copyConnector.getDrawType());
		assertEquals(connector.getName(), copyConnector.getName());
		assertEquals(connector.getStartAssociation(), copyConnector.getStartAssociation());
		assertEquals(connector.getEndAssociation(), copyConnector.getEndAssociation());
		assertEquals(connector.getPoints(), copyConnector.getPoints());
		assertEquals(connector.getTextPosition(), copyConnector.getTextPosition());
		assertEquals(connector.getDrawObjectStyle(), copyConnector.getDrawObjectStyle());
		assertEquals(connector.getText(), copyConnector.getText());
		assertEquals(connector.getTextDecoration(), copyConnector.getTextDecoration());
	}

	/**
	 * test SetStartAssociation
	 */
	@Test
	void testSetStartAssociation() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		UUID uuid = UUID.randomUUID();
		String arrow_name = "a arrow name";
		AbstractDrawObject abstractDrawObject1 = new AbstractDrawObject();
		AbstractDrawObject abstractDrawObject2 = new AbstractDrawObject();
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(abstractDrawObject1);
		drawobjects.add(abstractDrawObject2);
		
		Point point = new Point(20, 30);
		Arrow arrow = new Arrow(arrow_name, drawobjects);
		
		boolean exception = false;
		Association newAssociation = new Association(uuid, arrow, point);
		
		try {
			connector.setStartAssociation(newAssociation);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( newAssociation != connector.getStartAssociation());
		assertEquals(newAssociation, connector.getStartAssociation());
	}
	
	/**
	 * test SetStartAssociation with null should throw a NullPointerException
	 */
	@Test
	void testSetStartAssociationWithNullShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		boolean exception = false;
		Association newAssociation = null; 
		
		try {
			connector.setStartAssociation(newAssociation);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	/**
	 * test SetEndAssociation
	 */
	@Test
	void testSetEndAssociation() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		UUID uuid = UUID.randomUUID();
		String arrow_name = "a arrow name";
		AbstractDrawObject abstractDrawObject1 = new AbstractDrawObject();
		AbstractDrawObject abstractDrawObject2 = new AbstractDrawObject();
		List<AbstractDrawObject> drawobjects = new ArrayList<AbstractDrawObject>();
		drawobjects.add(abstractDrawObject1);
		drawobjects.add(abstractDrawObject2);
		
		Arrow arrow = new Arrow(arrow_name, drawobjects);
		boolean exception = false;
		
		Point point = new Point(20, 30);
		Association newAssociation = new Association(uuid, arrow, point);
		
		try {
			connector.setEndAssociation(newAssociation);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue( newAssociation != connector.getEndAssociation());
		assertEquals(newAssociation, connector.getEndAssociation());
	}
	
	/**
	 * test SetEndAssociation with null should throw a NullPointerException
	 */
	@Test
	void testSetEndAssociationWithNullShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		boolean exception = false;
		Association newAssociation = null; 
		
		try {
			connector.setEndAssociation(newAssociation);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test setTextPostion constructor
	 */
	@Test
	void testSetTextPositon() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);

		Point newTextPosition = new Point(55, 44);
		boolean exception = false;
		
		try {
			connector.setTextPosition(newTextPosition);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue(newTextPosition != connector.getTextPosition());
		assertEquals(newTextPosition, connector.getTextPosition());
	}
	
	/**
	 * test setTextPostion with null should throw a NullPointerException
	 */
	@Test
	void testSetTextPositonWithNullShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);

		Point newTextPosition = null;
		boolean exception = false;
		
		try {
			connector.setTextPosition(newTextPosition);
		} catch (NullPointerException e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	/**
	 * test set text decoration
	 */
	@Test
	void testSetTextDecoration() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		String text_decoration_name = "a text decoration";
		String font = "font";
		ETextAlign align = ETextAlign.END;
		ETextBaseline baseline = ETextBaseline.HANGING;
		ETextDirection direction = ETextDirection.LTR;
		
		Matrix matrix = new Matrix();
		matrix.setA(a);
		matrix.setB(b);
		matrix.setC(c);
		matrix.setD(d);
		matrix.setE(e);
		matrix.setF(f);
		
		TextDecoration newTextDecoration = new TextDecoration(
				text_decoration_name, 
				matrix, 
				font,
				align, 
				baseline, 
				direction	
			);
		boolean exception = false;
		
		try {
			connector.setTextDecoration(newTextDecoration);
		} catch (NullPointerException exc) {
			exception = true;
		}
		
		assertFalse(exception);
		assertTrue(newTextDecoration != connector.getTextDecoration());
		assertEquals(newTextDecoration, connector.getTextDecoration());
	}
	
	/**
	 * test set text decoration with null should throw a NullPointerException
	 */
	@Test
	void testSetTextDecorationWithNullShouldThrowANullPointerException() {
		EDrawType drawType = EDrawType.CIRCLE;
		String name = "a Connector";
		Association startAssociation = new Association();
		Association endAssociation = new Association();
		
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		Point textPosition = new Point(5, 6);
		DrawObjectStyle drawObjectStyle = new DrawObjectStyle();
		String text = "a text";
		TextDecoration textDecoration = new TextDecoration();
		
		Connector connector = new Connector(
				drawType, 
				name,
				startAssociation, 
				endAssociation, 
				points, 
				textPosition,
				drawObjectStyle,
				text,
				textDecoration
		);
		
		TextDecoration newTextDecoration = null;
		boolean exception = false;
		
		try {
			connector.setTextDecoration(newTextDecoration);
		} catch (NullPointerException exc) {
			exception = true;
		}
		
		assertTrue(exception);
	}

}
