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

	public int insertSeekerDetails(SeekerDetails details) {
		int returnNumber = 0;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement  preparedStatement=null;
		
		String query = "insert into seeker_details (first_name,last_name,address,phone_number,password,patient_id,hospital_name,blood_type)"
				+ "values(?,?,?,?,?,?,?,?)";
		String commit = "commit";
		try {
			 con = connection.getConnection();
			  preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, details.getFirstName());
			preparedStatement.setString(2, details.getLastName());
			preparedStatement.setString(3, details.getAddress());
			preparedStatement.setLong(4, details.getPhoneNumber());
			preparedStatement.setString(5, details.getPassword());
			preparedStatement.setLong(6, details.getPatientId());
			preparedStatement.setString(7, details.getHospitalName());
			preparedStatement.setString(8, details.getBloodType());

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

	public int seekerIdFind(SeekerDetails seeker) {
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		int seekerId = 0;
		try {
			 con = connection.getConnection();
			String query = "select ID  from seeker_details where first_name=? and last_name=? ";
			 preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, seeker.getFirstName());
			preparedStatement.setString(2, seeker.getLastName());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				seekerId = resultSet.getInt(1);
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
		return seekerId;
	}

	public SeekerDetails seekerObject(String password, Long phoneNumber) {
		ConnectionUtil connection = new ConnectionUtil();

		SeekerDetails seeker = null;
		Connection con=null;
		PreparedStatement preparedStatement =null;
		try {
			 con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE  from seeker_details where PASSWORD=? and PHONE_NUMBER=? ";
			 preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, phoneNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			// System.out.println(bloodType);

			while (resultSet.next()) {
				seeker = new SeekerDetails(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
						resultSet.getString(5), resultSet.getLong(6), resultSet.getString(7), resultSet.getString(8));
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
		return seeker;

	}

	public SeekerDetails FindSeekerId(int seekerId) {

		SeekerDetails seeker = null;

		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		Statement statement=null;
		try {
			 con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE  from seeker_details";
			 statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				seeker = new SeekerDetails(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4),
						resultSet.getString(5), resultSet.getLong(6), resultSet.getString(7), resultSet.getString(8));
			}
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
		return seeker;

	}

	public SeekerDetails FindSeekerObjectId(long phoneNumber) {

		SeekerDetails seeker = null;

		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();
			String query = "select FIRST_NAME,LAST_NAME,ADDRESS,PHONE_NUMBER,PASSWORD,PATIENT_ID,HOSPITAL_NAME,BLOOD_TYPE from seeker_details where PHONE_NUMBER =?";
			
		 preparedStatement=con.prepareStatement(query);
		preparedStatement.setLong(1, phoneNumber);
			ResultSet resultSet = preparedStatement.executeQuery(query);
			while (resultSet.next()) {
				seeker = new SeekerDetails(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5),
						resultSet.getString(6), resultSet.getLong(7), resultSet.getString(8), resultSet.getString(9));
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
		return seeker;

	}

	public Long PhoneNumberValid(long phoneNumber) {

		Long returnPhoneNumber = null;

		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		Statement statement=null;
		try {
			 con = connection.getConnection();
			String query = "select PHONE_NUMBER from seeker_details where PHONE_NUMBER ='" + phoneNumber + "'";
			 statement = con.createStatement();
			ResultSet resultset = statement.executeQuery(query);
			
			while (resultset.next()) {
				returnPhoneNumber = resultset.getLong(1);
			}
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

		return returnPhoneNumber;

	}

	public int ForgotPassword(Long phoneNumber, String password) {
		int returnNumber = 0;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
 
		try {
			 con = connection.getConnection();
			// String commit="commit";
			String query = "update  seeker_details  set PASSWORD=?  where PHONE_NUMBER=?";

			 preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, password);
			// System.out.println(phoneNumber);
			preparedStatement.setLong(2, phoneNumber);

			returnNumber = preparedStatement.executeUpdate();

			// pstmt.executeQuery(commit);

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
}
