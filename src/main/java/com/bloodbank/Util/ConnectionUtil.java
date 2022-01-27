package com.bloodbank.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		return con;
	}
	
public  static void closePreparedStatement(PreparedStatement preparedStatement,Connection connection,ResultSet resultSet) {
	try {
		if(resultSet!=null) {
			resultSet.close();
		}
	if(preparedStatement!=null) {
		
		preparedStatement.close();
	}if(connection!=null) {
		connection.close();
		
	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	 public  static void closeStatement(Statement statement,Connection connection,ResultSet resultSet) {
	try {
		if(resultSet!=null) {
			resultSet.close();
		}
	if(statement!=null) {
		
		statement.close();
		
	 }if(connection!=null) {
		 connection.close();
		
	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
