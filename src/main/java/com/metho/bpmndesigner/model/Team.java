package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * a team is a group of person, how works on one or more dokuments
 */
@Document(collection="teams")
public class Team {
	/**
	 * the id of the collection
	 * 
	 * @var int
	 */
	@Id
	private Integer id;
	
	/**
	 * name of the team
	 * 
	 * var String
	 */
	private String name;
	
	/**
	 * the users who work together
	 * 
	 * var List<User>
	 */
	List<User> users;

	/**
	 * the documents that are being worked on together
	 * 
	 * var List<Documents>
	 */
	
	/**
	 * default constructor
	 * 
	 * return void
	 */
	public Team() {
		super();
	}

	// GETTER / SETTER
	/**
	 * get the id of the team
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * set the id of the team
	 * 
	 * @param Integer
	 * @return void
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * get the name of the team
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set the name of the team
	 * 
	 * @param String
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the users who works together
	 * 
	 * @return List<User>
	 */
	public List<User> getUsers() {
		return users;
	}
	
	/**
	 * set the users who works together
	 * 
	 * @param List<User>
	 * @return void
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

}
