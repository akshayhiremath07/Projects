package com.getitdone.in.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class jdbcUtil {
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws IOException, SQLException {
		
		
		 HikariConfig config=new HikariConfig("C:\\Users\\LENOVO\\Desktop\\Spring workSpace\\ineuronPractice\\StatementCrudApp\\application.properties");
		 HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();
		
	}
	public static void cleanUp(Connection connection,Statement statement,ResultSet set) throws SQLException {
		if(connection!=null) connection.close();
		if(statement!=null) statement.close();
		if(set!= null) set.close();
	}

}
