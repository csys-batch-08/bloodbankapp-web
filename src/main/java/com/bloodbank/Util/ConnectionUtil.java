package com.bloodbank.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		return con;
	}
	
public  static void closePreparedStatement(PreparedStatement preparedStatement,Connection con) {
	try {
	if(preparedStatement!=null) {
		
		preparedStatement.close();
	}if(con!=null) {
		con.close();
		
	}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	 public  static void closeStatement(Statement statement,Connection con) {
	try {
	if(statement!=null) {
		
		statement.close();
		
	 }if(con!=null) {
		con.close();
		
	}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
