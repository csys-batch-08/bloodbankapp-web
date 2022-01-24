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
	public int insertDonor(Donor donor) {
		ConnectionUtil connection = new ConnectionUtil();
		int tempNumber = 0;
		
		Connection con=null;
		PreparedStatement  preparedStatement=null;
		try {

			 con = connection.getConnection();
			String query = "insert into donor_details values(?,?,?,?,?,?,?)";
			String commit = "commit";
			  preparedStatement = con.prepareStatement(query);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, con);
		}
		return tempNumber;
	}

	public Donor validAadharcardNumber(Long aadharcard) {
		Donor donor = null;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con =null;
		PreparedStatement  preparedStatement=null;
		try {

			 con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,AADHARCARD,PHONE,DONOR_DATE,BLOOD_TYPE from donor_details where aadharcard=?";
			 preparedStatement=con.prepareStatement(query);
			preparedStatement.setLong(1, aadharcard);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				donor = new Donor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getLong(5),
						resultSet.getDate(6), resultSet.getString(7));
			}

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
		return donor;
	}

	public int updateDonor(Donor donor) {
		ConnectionUtil connection = new ConnectionUtil();
		int returnNumber = 0;
		Connection con=null;
		PreparedStatement  preparedStatement=null;
		
		try {
			 con = connection.getConnection();
			String commit = "commit";
			String query = "update donor_details set address=?,age=?,phone=? where aadharcard=?";
			  preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, donor.getAddress());
			preparedStatement.setDate(2, new java.sql.Date(donor.getDonorDate().getTime()));
			preparedStatement.setLong(3, donor.getNumber());
			preparedStatement.setLong(4, donor.getAadharcard());
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

	public List<Donor> showDonor() {
		List<Donor> donorList = null;
		ConnectionUtil connection = new ConnectionUtil();
		donorList = new ArrayList<Donor>();
		Connection con=null;
		PreparedStatement  preparedStatement =null;
		try {
			 con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,AADHARCARD,PHONE,DONOR_DATE,BLOOD_TYPE from donor_details";

		  preparedStatement = con.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Donor donor = new Donor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getLong(5),
						resultSet.getDate(6), resultSet.getString(7));
				donorList.add(donor);
				// donorList=rs.getInt(1),rs.getString(2),rs.getString(3),
				// rs.getString(4),rs.getLong(5),rs.getLong(6),rs.getInt(7), rs.getString(8);
			}

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
		return donorList;

	}

	public Long aadharcardNumber(Donor donor) {
		Long aadharcardNumber = null;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();
			String query = "select AADHARCARD from donor_details where PHONE=? and FIRST_NAME=? and LAST_NAME=?";
			 preparedStatement = con.prepareStatement(query);

			preparedStatement.setLong(1, donor.getNumber());
			preparedStatement.setString(2, donor.getFirstName());
			preparedStatement.setString(3, donor.getLastName());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				aadharcardNumber = resultSet.getLong(4);
			}

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
		return aadharcardNumber;
	}

	public Donor validNumber(Long aadharcardNumber) {
		Donor donor1 = null;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,AADHARCARD,PHONE,DONOR_DATE,BLOOD_TYPE from donor_details where aadharcard=?";
			 preparedStatement=con.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				donor1 = new Donor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4), resultSet.getLong(5),
						resultSet.getDate(6), resultSet.getString(7));
			}

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
		return donor1;
	}

}
