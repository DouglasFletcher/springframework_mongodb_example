package com.dbconnect.example.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/dbconnect/example/beans/dao-context.xml");
		
		// close context path
		((ClassPathXmlApplicationContext)context).close();
	
	
	}
	
}
