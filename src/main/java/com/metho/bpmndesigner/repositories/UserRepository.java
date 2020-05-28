package com.metho.bpmndesigner.repositories;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metho.bpmndesigner.model.User;

/**
 * the repository for the users
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	/**
	 * find the user with the given email and password
	 */
	User findByEmailAndPassword(String email, String password);
	
}
