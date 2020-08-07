package com.supermercado.service.impl;

import org.springframework.data.mongodb.core.MongoOperations;
import com.supermercado.domain.db.DatabaseSequence;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.supermercado.service.SequenceGeneratorService;

@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

	private MongoOperations mongoOperations;
	
	
	public SequenceGeneratorServiceImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
	
	
	@Override
	public Long generateSequence(String seqName) {
		 DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	                new Update().inc("sequence",1), options().returnNew(true).upsert(true),
	                DatabaseSequence.class);
	        return !Objects.isNull(counter) ? counter.getSequence() : 1;
	}

}
