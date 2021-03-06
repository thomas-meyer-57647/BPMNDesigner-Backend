package com.metho.bpmndesigner.services;
/*-------------------------------------------------------------------------------	
 * BPMN Designer	
 *-------------------------------------------------------------------------------	
 * @author    	Thomas Meyer	
 * @copyright 	Copyright (C) 2020 Thomas Meyer. License see license.txt
 * @version		0.1.2
 --------------------------------------------------------------------------------*/
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.metho.bpmndesigner.model.DatabaseSequence;

/**
 * this service generate a sequence for a entity. It will be used for 
 * auto-increment
 */
@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    
    /**
     * generate a new sequence for the sequenceName
     * 
     * @param String seqenceName
     * @return
     */

    public long generateSequence(String seqenceName) {

        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqenceName)),
                new Update().inc("sequence",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        
        return !Objects.isNull(counter) ? counter.getSequence() : 1;

    }
}
