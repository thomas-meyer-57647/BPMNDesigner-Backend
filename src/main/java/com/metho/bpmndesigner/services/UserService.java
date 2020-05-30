package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metho.bpmndesigner.exception.ResourceNotFoundException;
import com.metho.bpmndesigner.model.User;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a user
 * 
 * User create(User creator, User user) 										create a new user
 * List<User> findByEmailAndPassword(String email, String password) 			find user by email and password
 * List<User> findByEmail(String email)											find a user by Email
 * List<User> findAll()															get all Users
 * List<User> findBySecret(String secret)										get a <code>User</code> by a secret key
 * Optional<User> findById(long userId)											get a <code>User</code> with the ID <code>id</code>
 * 
 * 
 * aktualisieren eines users
 * löschen eines users
 */
@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a user
     * 
     * @param User creator	 						the creator
     * @param User user								the user to save
     * @return User									the created User
     * @throws ResourceNotFoundException 
     * @throw ResourceNotFoundException				if a user exist with the email address 
     */
    public User createUser(User creator, User user) throws ResourceNotFoundException {
    	if ( creator.getId() == 0 ) {
    		userRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
    	user.setCreatedBy(creator);
    	user.setCreatedAt(LocalDateTime.now());
    	
        return userRepository.save(user);
    }
    
    /**
     * find a user by email and password
     * 
     * @param String email									the email to found
     * @param String password								the password to found
     * @return List<User>									the found users
     */
    List<User> findByEmailAndPassword(String email, String password) {
    	return userRepository.findByEmailAndPasswort(email, password);
    }
    
    /**
     * find a user by Email
     * 
     * @param String email									the email to found
     * @return List<User>									the found users
     */
    List<User> findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    /**
     * get all Users
     * 
     * @return List<User>
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    /**
     * get a <code>User</code> with the ID <code>id</code>
     * 
     * @param Long userID
     * @return Optional<User>
     */
    public Optional<User> findById(long userId) {
    	return userRepository.findById(userId);
    }
    
    /**
     * get a <code>User</code> by a secret key
     * 
     * @param String secret
     * @return Optional<User>
     */
    public List<User> findBySecret(String secret) {
    	return userRepository.findBySecret(secret);
    }
    
    /**
     * update a <code>User</code> with the id <code>userID</code> from the User 
     * <code>updaterUser</code>
     * 
     * If a <code>User</code> with the id <code>userID</code> not found this function will be
     * throw a ResourceNotFoundException
     * 
     * @param User updaterUser						the updated
     * @param Long userID							the id of the user
     * @param User userDetails						the information to update
     * @return User									the created User
     * @throws ResourceNotFoundException			if no User found with the <code>userID</code>
     */
    public final User updateUser(User updaterUser, Long userID, User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userID)
        		.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userID));
        
        user.setUpdatedBy(updaterUser);
        user.setUpdatedAt(LocalDateTime.now());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        
        return userRepository.save(user);
    }
    
    /**
     * delete a User update a User with the ID <code>id</code>
     * 
     * @return ResponseEntity<User>
     * @throws ResourceNotFoundException
     */
    public void deleteUser(long userID) throws ResourceNotFoundException {
        User user = userRepository.findById(userID)
        		.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userID));
        
        userRepository.delete(user);
    }
    
}
