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
	static final String FIRSTNAME = "first_name";
	static final String LASTNAME = "last_name";
	static final String ADDRESS = "address";
	static final String PHONENUMBER = "phone_number";
	static final String PASSWORD = "password";
	static final String PATIENTID = "patient_id";
	static final String HOSPITALNAME = "hospital_name";
	static final String BLOODTYPE = "blood_type";

	/**
	 * Insert the seeker details
	 */
	@Override
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

	/**
	 * Find the seekerid
	 */
	@Override
	public int seekerIdFind(SeekerDetails seekerDetails) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;
		int seekerId = 0;
		try {
			connection = connectionUtil.getConnection();
			String query = "select id  from seeker_details where phone_number=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, seekerDetails.getPhoneNumber());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				seekerId = resultSet.getInt("ID");
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

	/**
	 * The seeker validation to get the seeker object
	 */
	@Override
	public SeekerDetails seekerObject(String password, Long phoneNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();

		SeekerDetails seekerDetails = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select first_name,last_name,address,phone_number,password,patient_id,hospital_name,blood_type  from seeker_details where password=? and phone_number=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, phoneNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				seekerDetails = new SeekerDetails(resultSet.getString(FIRSTNAME), resultSet.getString(LASTNAME),
						resultSet.getString(ADDRESS), resultSet.getLong(PHONENUMBER), resultSet.getString(PASSWORD),
						resultSet.getLong(PATIENTID), resultSet.getString(HOSPITALNAME),
						resultSet.getString(BLOODTYPE));
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

	/**
	 * The seeker id to get the seeker details
	 */
	@Override
	public SeekerDetails findSeekerId(int seekerId) {

		SeekerDetails seekerDetails = null;
		ResultSet resultSet = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select first_name,last_name,address,phone_number,password,patient_id,hospital_name,blood_type  from seeker_details";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				seekerDetails = new SeekerDetails(resultSet.getString(FIRSTNAME), resultSet.getString(LASTNAME),
						resultSet.getString(ADDRESS), resultSet.getLong(PHONENUMBER), resultSet.getString(PASSWORD),
						resultSet.getLong(PATIENTID), resultSet.getString(HOSPITALNAME),
						resultSet.getString(BLOODTYPE));
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

	/**
	 * The phone number to find the seeker object
	 */
	@Override
	public SeekerDetails findSeekerObjectId(long phoneNumber) {

		SeekerDetails seekerDetails = null;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select first_name,last_name,address,phone_number,password,patient_id,hospital_name,blood_type from seeker_details where phone_number =?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				seekerDetails = new SeekerDetails(resultSet.getString(FIRSTNAME), resultSet.getString(LASTNAME),
						resultSet.getString(ADDRESS), resultSet.getLong(PHONENUMBER), resultSet.getString(PASSWORD),
						resultSet.getLong(PATIENTID), resultSet.getString(HOSPITALNAME),
						resultSet.getString(BLOODTYPE));
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

	/**
	 * The seeker phone number validation
	 */
	@Override
	public Long phoneNumberValid(long phoneNumber) {

		Long returnPhoneNumber = null;
		ResultSet resultset = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select phone_number from seeker_details where phone_number =?";
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

	/**
	 * The seeker change password
	 */
	@Override
	public int forgotPassword(Long phoneNumber, String password) {
		int returnNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();

			String query = "update  seeker_details  set password=?  where phone_number=?";

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
