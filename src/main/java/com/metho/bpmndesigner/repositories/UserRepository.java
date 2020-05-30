package com.metho.bpmndesigner.repositories;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.metho.bpmndesigner.model.User;

/**
 * the repository for a user
 * 
 * List<User> findByEmailAndPasswort(String email, String passwort)			find a user by email and password
 * List<User> findByEmail(String email)										find a user by email
 * List<User> findBySecret(String secret)									find a user by his secret key
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	/**
	 * find a user by his email and password
	 * 
	 * @param String email
	 * @param String passwort
	 * @return List<User>
	 */
	List<User> findByEmailAndPasswort(String email, String password);
	
	/** 
	 * find a user by his password
	 * 
	 * @param String email
	 * @return List<User>
	 */
	List<User> findByEmail(String email);
	
	/** 
	 * find a user by his secret key
	 * 
	 * @param String secret								the secret key
	 * @return List<User>
	 */
	List<User> findBySecret(String secret);
	
}