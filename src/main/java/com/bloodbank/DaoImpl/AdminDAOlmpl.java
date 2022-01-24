package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.Dao.AdminDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.AdminModel;

public class AdminDAOlmpl implements AdminDAO {
	

	public AdminModel verificationAdmin(AdminModel adminModel) {
		AdminModel model = null;
		PreparedStatement preparedStatement=null;
		Connection con=null;
		ConnectionUtil connection = new ConnectionUtil();
		try {
			 con = connection.getConnection();

			String query = "select EMAIL ,PASSWORD,WALLET  from admin where email=? and password=?";
			 preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, adminModel.getEmail());
			preparedStatement.setString(2, adminModel.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				model = new AdminModel(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    finally {
    	 ConnectionUtil.closePreparedStatement(preparedStatement, con);
    }
		
		return model;
	}

	public AdminModel updateWallet() {

		

		AdminModel admin = null;
		Statement statement=null;		
		Connection con=null;
		ConnectionUtil connection = new ConnectionUtil();
		try {
		  con = connection.getConnection();
			String query1 = "select EMAIL ,PASSWORD,WALLET from admin";
		    statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query1);

			while (resultSet.next()) {
				admin = new AdminModel(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3));
			}
			// System.out.println(id);
			double walletTotal = admin.getWallet() - 300;

			// System.out.println(walletTotal);
			String query = "update admin set wallet=? where email=?";
			// String commit="commit";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setDouble(1, walletTotal);
			preparedStatement.setString(2, admin.getEmail());
              preparedStatement.executeUpdate();
			// pstmt.executeQuery(commit);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			 ConnectionUtil.closeStatement(statement, con);
			
		}
		return admin;

	}

	public int seekerPayment(double totalPrice) {

		AdminDAOlmpl adminDao = new AdminDAOlmpl();
		AdminModel admin = new AdminModel();
		admin = adminDao.updateWallet();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		double total = admin.getWallet() + totalPrice;
		int returnNumber = 0;
		ConnectionUtil connection = new ConnectionUtil();
		try {
		     con = connection.getConnection();
			String commit = "commit";
			
			String query = "update admin set wallet=? where email=?";
		    preparedStatement = con.prepareStatement(query);
			preparedStatement.setDouble(1, total);
			preparedStatement.setString(2, admin.getEmail());
			returnNumber = preparedStatement.executeUpdate();
			
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			 ConnectionUtil.closePreparedStatement(preparedStatement, con);
		}

		return returnNumber;

	}

	public Double CheckWallet() {
		double wallet = 0;
		
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		Statement statement=null;
		try {
			
			 con = connection.getConnection();
			String query = "select wallet from admin";
			 statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				wallet = resultSet.getDouble(1);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			ConnectionUtil.closeStatement(statement, con);
			
		}

		return wallet;
	}

}
