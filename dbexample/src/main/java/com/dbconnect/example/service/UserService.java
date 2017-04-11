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

	public UserMongoDAO getUserDao() {
		return userDao;
	}

	// get all users
	public List<UserMongo> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	// get one user
	public UserMongo getOneUser(int userId) {
		return userDao.getOneUser(userId);
	}
		
	// insert user
	public void insertUser(UserMongo userMongo) {
		userDao.insertOneUser(userMongo);
	}
	
	// insert users
	public void insertManyUsers(List<UserMongo> usersMongo){
		userDao.insertAllUsers(usersMongo);
	}
	
	/*	
	@Autowired
	private UserOracleDAO userDao;
		
	public List<UserOracle> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public UserOracle getOneUser(int userId) {
		return userDao.getOneUser(userId);
	};
	
	public void insertUser(UserOracle userOracle){
		userDao.insertOneUser(userOracle);
	}
	
	public void insertManyUsers(List<UserOracleDAO> usersOracle) {
		userDao.insertAllUsers(usersOracle);
	}
	*/
}
