package com.codepressed.urlShortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.codepressed.urlShortener.model.Sequence;



import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class MongoUtilsServiceImpl implements MongoUtilsService {

    @Autowired
    private MongoOperations mongo;

    /**
     * Mongo autoincremental
     * @param sequenceId Name of the sequence / document
     * @return sequenceID next value
     */
    public Long getNextValue(String sequenceId) {
        //https://docs.mongodb.com/v3.0/tutorial/create-an-auto-incrementing-field/
        final Sequence sequence = mongo.findAndModify(
                query(where("_id").is(sequenceId)),
                new Update().inc("value",1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        return sequence != null ? sequence.getValue() : null;
    }


}
