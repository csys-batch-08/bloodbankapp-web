package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bloodbank.Dao.RequestDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

public class RequestDAOlmpl implements RequestDAO {

	public int insertRequest(RequestModel request) {
		int returnNumber = 0;
		
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		String query = "insert into request_details (hospital_name,blood_type,unit,blood_collector_name,phone_number,aadharcard_number,request_date,status) values(?,?,?,?,?,?,?,?)";
		// String commit="commit";

		try {
			 con = connection.getConnection();
			// System.out.println( new java.sql.Date( request.getRequestDate().getTime()));
			 preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, request.getHospitalName());
			preparedStatement.setString(2, request.getBloodType());
			preparedStatement.setInt(3, request.getUnit());
			preparedStatement.setString(4, request.getBloodCollectorName());
			preparedStatement.setLong(5, request.getPhoneNumber());
			preparedStatement.setLong(6, request.getAadharcard());
			preparedStatement.setDate(7, new java.sql.Date(request.getRequestDate().getTime()));
			preparedStatement.setString(8, request.getStatus());
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

	public int deleteRequest(Long aadharcardNumber) {
		ConnectionUtil connection = new ConnectionUtil();
		int tempNumber = 0;
		Connection con=null;
		Statement statement=null;
		// System.out.println(aadharcard);
		try {
			 con = connection.getConnection();
			String commit = "commit";
			
			String query = "delete from request_details where aadharcard_number =" + aadharcardNumber;
			 statement = con.createStatement();
			tempNumber = statement.executeUpdate(query);
			statement.executeQuery(commit);

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

		return tempNumber;

	}

	public String StatusCheck(Long aadharcardNumber) {
		ConnectionUtil connection = new ConnectionUtil();
		String status = null;
		Connection con=null;
		Statement statement=null;
		
		try {
			 con = connection.getConnection();
			// String commit="commit";
			String query = "select status from  request_details where aadharcard_number =" + aadharcardNumber;
			
			 statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			// stmt.executeQuery(commit);
			while (resultSet.next()) {

				status = resultSet.getString(1);
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
		return status;

	}

	public List<RequestModel> ShowRequest() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		Statement statement=null;
		try {
			 con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS	 from request_details order by request_id desc";
			 statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel request = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));
				requestList.add(request);

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
		return requestList;
	}

	public List<RequestModel> ShowRequestSeeker(Long phoneNumber) {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?";
			 preparedStatement=con.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				RequestModel request = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));
				requestList.add(request);


				

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
		return requestList;
	}

	public RequestModel RequestObject(Long phoneNumber) {
		RequestModel request = null;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?" ;
		 preparedStatement=con.prepareStatement(query);
		preparedStatement.setLong(1, phoneNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				request = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));

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
		return request;
	}

	public Long AadharcardValid(Long aadharcardNumber) {
		ConnectionUtil connection = new ConnectionUtil();
		Long tempNumber = null;
		Connection con =null;
		PreparedStatement  preparedStatement=null;
		try {
			 con = connection.getConnection();
			// String commit="commit";
			String query = "select AADHARCARD_NUMBER from request_details where aadharcard_number =?";
			  preparedStatement=con.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			// stmt.executeQuery(commit);
			while (resultSet.next()) {

				tempNumber = resultSet.getLong(1);
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
		return tempNumber;

	}

	public List<RequestModel> RequestUpdateAndDelete() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		Statement statement=null;
		try {
			 con = connection.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where status='pending' order by request_id desc";
			 statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel request = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));
				requestList.add(request);
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
		return requestList;
	}
}
