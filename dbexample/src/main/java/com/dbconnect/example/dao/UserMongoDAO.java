package com.dbconnect.example.dao;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	
	// get MongoTemplate
	public MongoTemplate getMongoTemplate(){
		return mongoTemplate; 
	}
	
	// get all users
	public List<UserMongo> getAllUsers() {
		return mongoTemplate.findAll(UserMongo.class);
	}
	
	// get one user: unique constraint exists on userId
	public UserMongo getOneUser(int userId){
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(userId));
		try{
			return mongoTemplate.find(query, UserMongo.class).get(0);
		} catch(Exception exp) {
			System.out.println("return type not expected");
			System.out.println(exp);
			return null;
		}
	}

	// insert all users
	public void insertAllUsers(List<UserMongo> usersMongo){
		Collection<UserMongo> collection = usersMongo;
		mongoTemplate.insert(collection, UserMongo.class);
	}
	
	// insert one user
	public void insertOneUser(UserMongo userMongo) {
		try{
			mongoTemplate.save(userMongo);
		} catch(Exception exp){
			System.out.println("cannot add user");
			System.out.println(exp);
		}
	}
	
}
