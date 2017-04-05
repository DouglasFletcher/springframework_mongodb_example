package com.dbconnect.example.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dbconnect.example.service.UserService;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/dbconnect/example/beans/bean.xml");
		
		// create user object
		System.out.println("creating test data...");
		UserMongo userMongo1 = new UserMongo("1", 1, 0, "ddfletcher", "douglas", "fletcher");
				
		// get users from user service
		UserService userService = (UserService)context.getBean("userService");
		
		userService.insertUser(userMongo1);
		
		// get users
		/*
		List<UserMongo> users = userService.getAllUsers();

		System.out.println(users);
		// print users
		for(UserMongo user: users){
			System.out.println(user);
		}
		*/	
		// close context path
		((ClassPathXmlApplicationContext)context).close();
	
	
	}
	
}
