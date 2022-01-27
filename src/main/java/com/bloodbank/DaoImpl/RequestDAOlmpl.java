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

	public int insertRequest(RequestModel  requestModel) {
		int returnNumber = 0;
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String query = "insert into request_details (hospital_name,blood_type,unit,blood_collector_name,phone_number,aadharcard_number,request_date,status) values(?,?,?,?,?,?,?,?)";
		// String commit="commit";

		try {
			connection = connectionUtil.getConnection();
			// System.out.println( new java.sql.Date( request.getRequestDate().getTime()));
			 preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, requestModel.getHospitalName());
			preparedStatement.setString(2, requestModel.getBloodType());
			preparedStatement.setInt(3, requestModel.getUnit());
			preparedStatement.setString(4, requestModel.getBloodCollectorName());
			preparedStatement.setLong(5, requestModel.getPhoneNumber());
			preparedStatement.setLong(6, requestModel.getAadharcard());
			preparedStatement.setDate(7, new java.sql.Date(requestModel.getRequestDate().getTime()));
			preparedStatement.setString(8, requestModel.getStatus());
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
			ConnectionUtil.closePreparedStatement(preparedStatement, connection,null);
		}

		return returnNumber;

	}

	public int deleteRequest(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int tempNumber = 0;
		Connection connection=null;
	PreparedStatement preparedStatement=null;
		// System.out.println(aadharcard);
		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";
			
			String query = "delete from request_details where aadharcard_number =? " ;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			
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
			
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}

		return tempNumber;

	}

	public String StatusCheck(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		String status = null;
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection = connectionUtil.getConnection();
			// String commit="commit";
			String query = "select status from  request_details where aadharcard_number =?" ;
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
		   resultSet = preparedStatement.executeQuery();

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
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
			
		}
		return status;

	}

	public List<RequestModel> ShowRequest() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details order by request_id desc";
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));
				requestList.add(requestModel);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return requestList;
	}

	public List<RequestModel> ShowRequestSeeker(Long phoneNumber) {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?";
			 preparedStatement=connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			 resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));
				requestList.add(requestModel);


				

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       finally {
    	   ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
       }
		return requestList;
	}

	public RequestModel RequestObject(Long phoneNumber) {
		RequestModel requestModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		ResultSet resultSet=null;
		PreparedStatement preparedStatement=null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?" ;
		 preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, phoneNumber);
			 resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
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
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return requestModel;
	}

	public Long AadharcardValid(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Long tempNumber = null;
		ResultSet resultSet=null;
		Connection connection =null;
		PreparedStatement  preparedStatement=null;
		try {
			connection = connectionUtil.getConnection();
			// String commit="commit";
			String query = "select AADHARCARD_NUMBER from request_details where aadharcard_number =?";
			  preparedStatement=connection.prepareStatement(query);
			 preparedStatement.setLong(1, aadharcardNumber);
			 resultSet = preparedStatement.executeQuery();

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
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return tempNumber;

	}

	public List<RequestModel> RequestUpdateAndDelete() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		ResultSet resultSet=null;
		Statement statement=null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where status='pending' order by request_id desc";
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7), resultSet.getString(8));
				requestList.add(requestModel);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return requestList;
	}
	public int RequestUpdate(RequestModel  requestModel) {
		int returnNumber = 0;
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String query = "update   request_details set status='approved' where aadharcard_number=? and BLOOD_TYPE=?";
		// String commit="commit";

		try {
			connection = connectionUtil.getConnection();
			// System.out.println( new java.sql.Date( request.getRequestDate().getTime()));
			 preparedStatement = connection.prepareStatement(query);		
			preparedStatement.setLong(1, requestModel.getAadharcard());
			preparedStatement.setString(2, requestModel.getBloodType());
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
			ConnectionUtil.closePreparedStatement(preparedStatement, connection,null);
		}

		return returnNumber;

	}

	
}
