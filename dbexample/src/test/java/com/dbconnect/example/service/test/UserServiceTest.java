package com.dbconnect.example.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbconnect.example.dao.UserMongo;
import com.dbconnect.example.service.UserService;

@ActiveProfiles("dev")
@ContextConfiguration(locations={
	"file:src/test/java/com/dbconnect/example/service/config/dao-tests.xml"
	, "file:src/main/java/com/dbconnect/example/beans/dao-context.xml"}
)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	private List<UserMongo> users;
	
	@Before
	public void init() {
		
		// drop collection
		MongoTemplate mongoTemplate = userService.getUserDao().getMongoTemplate();
		if (mongoTemplate.collectionExists("userMongo")){
			System.out.println("resetting collection");
			mongoTemplate.dropCollection("userMongo");
		}
		
		// create test data
		UserMongo userMongo0 = new UserMongo(0, 20, "bbjean", "Billy", "Jean");
		UserMongo userMongo1 = new UserMongo(1, 40, "theshaq", "Shaquille", "O'Neal");
		UserMongo userMongo2 = new UserMongo(2, 50, "mjay", "michael", "jackson");
		UserMongo userMongo3 = new UserMongo(3, 20, "90sdude", "michael", "Jordan");
		UserMongo userMongo4 = new UserMongo(4, 10, "heresjonny", "Hocus", "Pocus");

		// create test users
		List<UserMongo> users = new ArrayList<UserMongo>();
		users.add(userMongo0);
		users.add(userMongo1);
		users.add(userMongo2);
		users.add(userMongo3);
		users.add(userMongo4);
		
		// insert test users
		this.users = users;
	}
	
	
	@Test
	public void testInsertGetOneUser() {

		System.out.println("testing insert & get one user:");
				
		// expected Result
		List<UserMongo> expectedResult = this.users; 
		UserMongo expectedResult0 = expectedResult.get(0); 
		UserMongo expectedResult1 = expectedResult.get(1); 
		
		// actual Result
		userService.insertUser(expectedResult0);
		userService.insertUser(expectedResult1);
		UserMongo result0 = userService.getOneUser(expectedResult0.getUserid());
		UserMongo result1 = userService.getOneUser(expectedResult1.getUserid());
		
		// test: correct query
		assertEquals("query one user: insert & get true", expectedResult0, result0);
		System.out.println("expected result true test:");
		System.out.println(expectedResult0);
		System.out.println("expected result true test:");
		System.out.println(result0);
		// test: false query
		assertNotEquals("query one user: insert & get false", expectedResult0, result1);	
		System.out.println("expected result false test:");
		System.out.println(expectedResult0);
		System.out.println("expected result false test:");
		System.out.println(result1);
		System.out.println("\n");
	}

	@Test
	public void testInsertGetManyUsers() {

		System.out.println("testing insert & get many users:");

		// expected Result
		List<UserMongo> expectedResult = this.users; 
		
		// actual Result
		userService.insertManyUsers(expectedResult);
		List<UserMongo> result = userService.getAllUsers();
		
		// test: count of users
		assertEquals("query many users: equal count truth test", expectedResult.size(), result.size());
		// test: correct query
		for (int val = 0; val < expectedResult.size(); val++){
			System.out.println("expected result");
			System.out.println(expectedResult.get(val));
			System.out.println("actual result");
			System.out.println(result.get(val));
			assertEquals("query many users: insert & get truth test"
				, result.get(val), expectedResult.get(val)
			);
		}						
	}
}
