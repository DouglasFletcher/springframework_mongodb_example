package com.dbconnect.example.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class UserOracle {

	@Indexed
	@Id
	private int userid;
	private int accountbalance;
	private String username;
	private String firstname;
	private String lastname;

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

	@Override
	public String toString() {
		return "User [userid=" + userid + ", accountbalance=" + accountbalance + ", username=" + username
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
