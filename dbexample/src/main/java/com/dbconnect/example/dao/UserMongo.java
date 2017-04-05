package com.dbconnect.example.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserMongo {

	@Id
	private String id;
	@Indexed
	private int userid;
	private int accountbalance;
	private String username;
	private String firstname;
	private String lastname;

	public UserMongo(){}
	
	public UserMongo(String id, int userid, int accountbalance, String username, String firstname, String lastname) {
		this.id = id;
		this.userid = userid;
		this.accountbalance = accountbalance;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "UserMongo [id=" + id + ", userid=" + userid + ", accountbalance=" + accountbalance + ", username="
				+ username + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
