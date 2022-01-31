package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.Dao.SeekerDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.SeekerDetails;

public class SeekerDAOlmpl implements SeekerDAO {

	public int insertSeekerDetails(SeekerDetails seekerDetails) {
		int returnNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String query = "insert into seeker_details (first_name,last_name,address,phone_number,password,patient_id,hospital_name,blood_type)"
				+ "values(?,?,?,?,?,?,?,?)";
		String commit = "commit";
		try {
			connection = connectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, seekerDetails.getFirstName());
			preparedStatement.setString(2, seekerDetails.getLastName());
			preparedStatement.setString(3, seekerDetails.getAddress());
			preparedStatement.setLong(4, seekerDetails.getPhoneNumber());
			preparedStatement.setString(5, seekerDetails.getPassword());
			preparedStatement.setLong(6, seekerDetails.getPatientId());
			preparedStatement.setString(7, seekerDetails.getHospitalName());
			preparedStatement.setString(8, seekerDetails.getBloodType());

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

	public int seekerIdFind(SeekerDetails seekerDetails) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;
		int seekerId = 0;
		try {
			connection = connectionUtil.getConnection();
			String query = "select ID  from seeker_details where PHONE_NUMBER=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, seekerDetails.getPhoneNumber());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				seekerId = resultSet.getInt(1);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return seekerId;
	}

	public SeekerDetails seekerObject(String password, Long phoneNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();

		SeekerDetails seekerDetails = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE  from seeker_details where PASSWORD=? and PHONE_NUMBER=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, phoneNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				seekerDetails = new SeekerDetails(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getLong(4), resultSet.getString(5), resultSet.getLong(6),
						resultSet.getString(7), resultSet.getString(8));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return seekerDetails;

	}

	public SeekerDetails findSeekerId(int seekerId) {

		SeekerDetails seekerDetails = null;
		ResultSet resultSet = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE  from seeker_details";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				seekerDetails = new SeekerDetails(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getLong(4), resultSet.getString(5), resultSet.getLong(6),
						resultSet.getString(7), resultSet.getString(8));
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return seekerDetails;

	}

	public SeekerDetails findSeekerObjectId(long phoneNumber) {

		SeekerDetails seekerDetails = null;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE from seeker_details where PHONE_NUMBER =?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				seekerDetails = new SeekerDetails(resultSet.getString(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getLong(4), resultSet.getString(5), resultSet.getLong(6),
						resultSet.getString(7), resultSet.getString(8));
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return seekerDetails;

	}

	public Long phoneNumberValid(long phoneNumber) {

		Long returnPhoneNumber = null;
		ResultSet resultset = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select PHONE_NUMBER from seeker_details where PHONE_NUMBER =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				returnPhoneNumber = resultset.getLong(1);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultset);
		}

		return returnPhoneNumber;

	}

	public int forgotPassword(Long phoneNumber, String password) {
		int returnNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();

			String query = "update  seeker_details  set PASSWORD=?  where PHONE_NUMBER=?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, password);

			preparedStatement.setLong(2, phoneNumber);

			returnNumber = preparedStatement.executeUpdate();

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
}
