
package com.solvd.daoconnection;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCConnection {

	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "12345678";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/crackers_company";
	// private static final String DB_DRIVER_CLASS= "com.mysql.cj.jdbc.Driver";

	//org.gjt.mm.mysql.Driver //com.mysql.cj.jdbc.Driver

	private static BasicDataSource dataSource;

	static {
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);

		dataSource.setMinIdle(100);
		dataSource.setMaxIdle(1000);

	}
	
	public static DataSource getDataSource() { 
	return dataSource;
	}

}
