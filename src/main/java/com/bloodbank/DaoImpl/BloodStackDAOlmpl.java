package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BloodStackDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.RequestModel;

public class BloodStackDAOlmpl implements BloodStackDAO {
	static final String QUANTITY = "quantity";
	static final String BLOODTYPE = "blood_type";
	static final String UNITPRICE = "unit_price";

	public int updateStack(BloodStack bloodStack) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int returnNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();

			int quantity = checkOfQuantity(bloodStack.getBloodType().toLowerCase());

			String query = "update blood_stack set quantity=? where blood_type=?";
			preparedStatement = connection.prepareStatement(query);
			String commit = "commit";
			preparedStatement.setInt(1, quantity + bloodStack.getQuantity());
			preparedStatement.setString(2, bloodStack.getBloodType());
			returnNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}
		return returnNumber;
	}

	public List<BloodStack> showStack() {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		BloodStack bloodStack = null;
		List<BloodStack> stockDetails = new ArrayList();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {

			String query = "select blood_type,quantity,unit_price from blood_stack";

			connection = connectionUtil.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				bloodStack = new BloodStack(resultSet.getInt(QUANTITY), resultSet.getString(BLOODTYPE),
						resultSet.getDouble(UNITPRICE));
				stockDetails.add(bloodStack);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return stockDetails;
	}

	public int checkOfQuantity(String bloodtype) {
		ConnectionUtil connectionUtil = new ConnectionUtil();

		int returnNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select quantity from  blood_stack where blood_type=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bloodtype);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				returnNumber = resultSet.getInt(QUANTITY);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return returnNumber;
	}

	public int updateStackReduce(String bloodType, int unit) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int returnNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();

			String query = "update blood_stack set quantity=? where blood_type=?";
			preparedStatement = connection.prepareStatement(query);
			String commit = "commit";
			int totalUnit = checkOfQuantity(bloodType) - unit;
			preparedStatement.setInt(1, totalUnit);
			preparedStatement.setString(2, bloodType);
			returnNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}
		return returnNumber;
	}

	public double findPrice(String bloodType) {
		double unitPrice = 0;
		ResultSet resultSet = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select unit_price from blood_stack where blood_type=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, bloodType);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				unitPrice = resultSet.getDouble(UNITPRICE);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return unitPrice;
	}

	public int bloodPriceChange(String bloodtype, double bloodPrice) {
		int returnNumber = 0;
	
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();
			String query = "update blood_stack set unit_price=? where blood_type=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, bloodPrice);
			preparedStatement.setString(2, bloodtype);
			returnNumber = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}

		return returnNumber;
	}
}
