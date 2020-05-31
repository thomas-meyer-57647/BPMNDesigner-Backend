package com.metho.bpmndesigner.controller;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.services.UserService;

/**
 * the user controller
 * 
 * GET			/users					get all Users
 * GET			/user/{id} 				get User with the ID <code>id</code>
 * POST			/user					create a User
 * PUT			/user/{id}				update a User with the ID <code>id</code>
 * DELETE    	/employees/{id}			delete the User with the ID <code>id</code>
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
    @Autowired
    private UserService userService;
       
    /**
     * get all Users
     * 
     * @return List<User>
     */
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
    	return userService.findAll();
    }
    
    /**
     * get User with the ID <code>id</code>
     * 
     * @return ResponseEntity<User>
     * @throws ResourceNotFoundException
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity < UserEntity > getUserById(@PathVariable(value = "id") Long userID)
    throws ResourceNotFoundException {
        UserEntity user = userService.findById(userID)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userID));
        
        return ResponseEntity.ok().body(user);
    }
    
    /**
     * create a User
     * 
     * @return ResponseEntity<User>
     * @throws ResourceNotFoundException 
     */
    @PostMapping("/user")
    public UserEntity createUser(@Valid @RequestBody UserEntity user) throws ResourceNotFoundException {
        return userService.createUser(null, user);
    }
    
    /**
     * update a User with the ID <code>id</code>
     * 
     * @return ResponseEntity<User>
     * @throws ResourceNotFoundException
     */
    
    /**
     * delete the User with the ID <code>id</code>
     * 
     * @return ResponseEntity<User>
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userID)
         throws ResourceNotFoundException {
    	
    	userService.deleteUser(userID);

    	Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
