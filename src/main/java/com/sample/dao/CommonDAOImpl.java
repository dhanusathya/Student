package com.sample.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO {

	@Autowired
	@Qualifier("dbDataSource")
	private DataSource ds;
	
	public Connection getDBConnection() {
		Connection conn=null;
		try {
			/*System.out.println("getDBConnection");*/
			conn=ds.getConnection();
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		return conn;
	}
	
	
}
