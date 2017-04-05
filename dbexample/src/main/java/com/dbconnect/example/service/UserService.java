package com.dbconnect.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbconnect.example.dao.UserOracle;
import com.dbconnect.example.dao.UserOracleDAO;
import com.dbconnect.example.dao.UserMongo;
import com.dbconnect.example.dao.UserMongoDAO;

@Service("userService")
public class UserService {

	
	@Autowired
	private UserMongoDAO userDao;

	// get users
	public List<UserMongo> getAllUsers() {
		return userDao.getUsers();
	}
	
	// insert user
	public void insertUser(UserMongo userMongo) {
		userDao.save(userMongo);
	}
	
	/*
	@Autowired
	private UserOracleDAO userDao;
		
	public List<UserOracle> getAllUsers() {
		return userDao.getUsers();
	}
	*/
}