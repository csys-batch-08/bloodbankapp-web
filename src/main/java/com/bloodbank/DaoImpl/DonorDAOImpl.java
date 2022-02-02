package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.DonorDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.Donor;

public class DonorDAOImpl implements DonorDAO {
	
	static final String FIRSTNAME="first_name";
	static final String LASTNAME="last_name";
	static final String ADDRESS="address";
	static final String AADHARCARDNUMBER="aadharcard_number";
	static final String PHONENUMBER="phone_number";
	static final String DONORBIO="donor_bio";
	static final String BLOODTYPE="blood_type";
	
	
	public int insertDonor(Donor donor) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int tempNumber = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "insert into donor_details values(?,?,?,?,?,?,?)";
			String commit = "commit";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, donor.getFirstName());
			preparedStatement.setString(2, donor.getLastName());
			preparedStatement.setString(3, donor.getAddress());
			preparedStatement.setLong(4, donor.getAadharcard());
			preparedStatement.setLong(5, donor.getNumber());
			preparedStatement.setDate(6, new java.sql.Date(donor.getDonorDate().getTime()));
			preparedStatement.setString(7, donor.getBloodType());
			tempNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}
		return tempNumber;
	}

	public Donor validAadharcardNumber(Long aadharcard) {
		Donor donor = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select first_name,last_name,address,aadharcard_number,phone_number,donor_bio,blood_type from donor_details where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcard);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				donor = new Donor(resultSet.getString(FIRSTNAME), resultSet.getString(LASTNAME), resultSet.getString(ADDRESS),
						resultSet.getLong(AADHARCARDNUMBER), resultSet.getLong(PHONENUMBER), resultSet.getDate(DONORBIO), resultSet.getString(BLOODTYPE));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return donor;
	}

	public int updateDonor(Donor donor) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int returnNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";
			String query = "update donor_details set address=?,donor_bio=?,phone_number=? where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, donor.getAddress());
			preparedStatement.setDate(2, new java.sql.Date(donor.getDonorDate().getTime()));
			preparedStatement.setLong(3, donor.getNumber());
			preparedStatement.setLong(4, donor.getAadharcard());
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

	public List<Donor> showDonor() {
		List<Donor> donorList = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		donorList = new ArrayList();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select first_name,last_name,address,aadharcard_number,phone_number,donor_bio,blood_type from donor_details";

			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Donor donor = new Donor(resultSet.getString(FIRSTNAME), resultSet.getString(LASTNAME), resultSet.getString(ADDRESS),
						resultSet.getLong(AADHARCARDNUMBER), resultSet.getLong(PHONENUMBER), resultSet.getDate(DONORBIO), resultSet.getString(BLOODTYPE));
				donorList.add(donor);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();

		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return donorList;

	}

	public Long aadharcardNumber(Donor donor) {
		Long aadharcardNumber = null;
		ResultSet resultSet = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select aadharcard_number from donor_details where phone_number=? and first_name=? and last_name=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setLong(1, donor.getNumber());
			preparedStatement.setString(2, donor.getFirstName());
			preparedStatement.setString(3, donor.getLastName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				aadharcardNumber = resultSet.getLong(4);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return aadharcardNumber;
	}

	public Donor validNumber(Long aadharcardNumber) {
		Donor donor = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select first_name,last_name,address,aadharcard_number,phone_number,donor_bio,blood_type from donor_details where aadharcard=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				donor = new Donor(resultSet.getString(FIRSTNAME), resultSet.getString(LASTNAME), resultSet.getString(ADDRESS),
						resultSet.getLong(AADHARCARDNUMBER), resultSet.getLong(PHONENUMBER), resultSet.getDate(DONORBIO), resultSet.getString(BLOODTYPE));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return donor;
	}

}
