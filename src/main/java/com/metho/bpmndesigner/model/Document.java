package com.metho.bpmndesigner.model;

import java.util.ArrayList;
import java.util.List;

/**
 * a documents contains one or more <code>Page</code>s
 * 
 * @author tomth
 *
 */
public class Document {
	String name;										// the name of the dokument
	String author;										// the author of the dokument
	String version;										// the version
	String description;									// a detail description of the document
	List<Page> pages = new ArrayList<Page>();			// the pages

}
