package com.sample.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


public class CommonDAOImpl implements CommonDAO {

	@Autowired
	private DataSource dbDataSource;
	
	public Connection getDBConnection() {
		Connection conn=null;
		try {
			/*System.out.println("getDBConnection");*/
			conn=dbDataSource.getConnection();
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		return conn;
	}
	
	
}
