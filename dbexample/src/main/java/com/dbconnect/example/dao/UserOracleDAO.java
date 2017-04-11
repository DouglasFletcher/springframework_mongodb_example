package com.dbconnect.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("userOracleDAO")
public class UserOracleDAO {

	private JdbcTemplate jdbc;
	
	@Autowired
	@Qualifier("dataSourceOracle")
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}

	public List<UserOracle> getAllUsers(){
		
		return jdbc.query("select * from users", new RowMapper<UserOracle>(){
			
			public UserOracle mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				UserOracle user = new UserOracle();
				user.setAccountbalance(rs.getInt("accountbalance"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				
				return user;
			}
		});
		
	};
	
	public UserOracle getOneUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertOneUser(UserOracle userOracle) {
		// TODO Auto-generated method stub
	}

	public void insertAllUsers(List<UserOracleDAO> usersOracle) {
		// TODO Auto-generated method stub
	}
		
		
	
	
}
