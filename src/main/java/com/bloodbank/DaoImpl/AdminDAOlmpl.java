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

	static final String EMAIL = "email";
	static final String PASSWORD = "password";
	static final String WALLET = "wallet";

	@Override
	public AdminModel verificationAdmin(AdminModel adminModel) {
		AdminModel adminModel2 = null;
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try {
			connection = connectionUtil.getConnection();

			String query = "select email,password,wallet  from admin where email=? and password=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, adminModel.getEmail());
			preparedStatement.setString(2, adminModel.getPassword());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				adminModel2 = new AdminModel(resultSet.getString(EMAIL), resultSet.getString(PASSWORD),
						resultSet.getDouble(WALLET));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return adminModel2;
	}

	@Override
	public AdminModel updateWallet() {

		AdminModel adminModel = new AdminModel();
		Statement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try {
			connection = connectionUtil.getConnection();
			String query1 = "select email ,password,wallet from admin";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query1);

			if (resultSet.next()) {
				adminModel = new AdminModel(resultSet.getString(EMAIL), resultSet.getString(PASSWORD),
						resultSet.getDouble(WALLET));
			}
			double walletTotal = adminModel.getWallet() - 300;

			String query = "update admin set wallet=? where email=?";
			String commit = "commit";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, walletTotal);
			preparedStatement.setString(2, adminModel.getEmail());
			preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return adminModel;

	}

	@Override
	public int seekerPayment(double totalPrice) {

		AdminDAOlmpl adminDAOlmpl = new AdminDAOlmpl();
		AdminModel adminModel = new AdminModel();
		adminModel = adminDAOlmpl.updateWallet();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		double total = adminModel.getWallet() + totalPrice;
		int returnNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";

			String query = "update admin set wallet=? where email=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, total);
			preparedStatement.setString(2, adminModel.getEmail());
			returnNumber = preparedStatement.executeUpdate();

			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {

			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);

		}

		return returnNumber;

	}

	@Override
	public Double checkWallet() {
		double wallet = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select wallet from admin";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				wallet = resultSet.getDouble(WALLET);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {

			ConnectionUtil.closeStatement(statement, connection, resultSet);

		}

		return wallet;
	}

}
