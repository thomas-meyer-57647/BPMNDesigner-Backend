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
import com.metho.bpmndesigner.model.UserEntity;
import com.metho.bpmndesigner.repositories.UserRepository;

/**
 * this is the service for a user
 * 
 * User create(User creator, User user) 										create a new user
 * Optional<User> findByEmailAndPassword(String email, String password) 		find user by email and password
 * Optional<User> findByEmail(String email)										find a user by Email
 * List<User> findAll()															get all Users
 * Optional<User> findById(long userId)											get a <code>User</code> with the ID <code>id</code>
 * Optional<User> findBySecret(String secret)									get a <code>User</code> by a secret key
 * final UserEntity updateUser(UserEntity updaterUser, Long userID, UserEntity userDetails)
 *																				update a user
 * void deleteUser(long userID)													delete a user
 */
@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    /**
     * the sequenceGeneratorService for the auto-increment
     */
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    
    /**
     * create a user
     * 
     * @param UserEntity creator	 						the creator
     * @param UserEntity user								the user to save
     * @return User									the created User
     * @throws ResourceNotFoundException 
     * @throw ResourceNotFoundException				if a user exist with the email address 
     */
    public UserEntity createUser(UserEntity creator, UserEntity user) throws ResourceNotFoundException {
    	if ( creator != null ) {
    		userRepository.findById(creator.getId())
    			.orElseThrow(() -> new ResourceNotFoundException("Creator not found with the id :: " + creator.getId()));
    	}
    	
    	user.setId(sequenceGeneratorService.generateSequence(UserEntity.SEQUENCE_NAME));
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
    Optional<UserEntity> findByEmailAndPassword(String email, String password) {
    	return userRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * find a user by Email
     * 
     * @param String email									the email to found
     * @return List<User>									the found users
     */
    Optional<UserEntity> findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    /**
     * get all Users
     * 
     * @return List<User>
     */
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    
    /**
     * get a <code>User</code> with the ID <code>id</code>
     * 
     * @param Long userID
     * @return Optional<User>
     */
    public Optional<UserEntity> findById(long userId) {
    	return userRepository.findById(userId);
    }
    
    /**
     * get a <code>User</code> by a secret key
     * 
     * @param String secret
     * @return Optional<User>
     */
    public Optional<UserEntity> findBySecret(String secret) {
    	return userRepository.findBySecret(secret);
    }
    
    /**
     * update a <code>User</code> with the id <code>userID</code> from the User 
     * <code>updaterUser</code>
     * 
     * If a <code>User</code> with the id <code>userID</code> not found this function will be
     * throw a ResourceNotFoundException
     * 
     * @param UserEntity updaterUser						the updated
     * @param Long userID							the id of the user
     * @param UserEntity userDetails						the information to update
     * @return User									the created User
     * @throws ResourceNotFoundException			if no User found with the <code>userID</code>
     */
    public final UserEntity updateUser(UserEntity updaterUser, Long userID, UserEntity userDetails) throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userID)
        		.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userID));
        
        user.setUpdatedBy(updaterUser);
        user.setUpdatedAt(LocalDateTime.now());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setSecret(userDetails.getSecret());
        
        return userRepository.save(user);
    }
    
    /**
     * delete a User update a User with the ID <code>id</code>
     * 
     * @return ResponseEntity<User>
     * @throws ResourceNotFoundException
     */
    public void deleteUser(long userID) throws ResourceNotFoundException {
        UserEntity user = userRepository.findById(userID)
        		.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userID));
        
        userRepository.delete(user);
    }
    
}
