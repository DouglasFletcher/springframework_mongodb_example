package com.dbconnect.example.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component("userMongoDAO")
@Repository
public class UserMongoDAO {

	private MongoTemplate mongoTemplate;
	
	@Autowired
	@Qualifier("dataSourceMongo")
	public void setDataSource(MongoDbFactory dataSourceMongo) {
		this.mongoTemplate = new MongoTemplate(dataSourceMongo);
	};
	
	// get users
	public List<UserMongo> getUsers() {
		return mongoTemplate.findAll(UserMongo.class);
	}
	
	// save user
	public void save(UserMongo userMongo) {
		mongoTemplate.save(userMongo);
	}
	
}
