package com.metho.bpmndesigner.model;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The entity stores the the auto-incremented sequence for other collections
 * 
 * id;									id 
 * long sequence;						the auto-incremented sequence
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;									// id 
    private long sequence;								// the auto-incremented sequence

    /**
     * default constructor
     * 
     * @return void
     */
    public DatabaseSequence() {}

    /**
     * get the id of this database sequence
     * 
     * @return String
     */
    public String getId() {
        return id;
    }
    
    /**
     * set the id of this database sequence
     * 
     * @param id
     * @return id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * get the sequence
     * 
     * @return String
     */
    public long getSequence() {
        return this.sequence;
    }

    /**
     * set the sequence
     * 
     * @param sequence
     * @return void
     */
    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}