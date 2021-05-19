package com.autowire.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.autowire.bean.Student;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CustomeRepositoryImpl implements CustomRepository{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public UpdateResult updateStudentSection(int age, String section) {
		Query query = new Query(Criteria.where("age").gt(age));
        Update update = new Update();
        update.set("section", section);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Student.class);
        System.out.println("%%%%%%%%%%%%%"+result);
		return result;

		
	}

}
