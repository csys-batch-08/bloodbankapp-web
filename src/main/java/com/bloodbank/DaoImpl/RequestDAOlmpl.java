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

	public int insertRequest(RequestModel requestModel) {
		int returnNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into request_details (hospital_name,blood_type,unit,blood_collector_name,phone_number,aadharcard_number,request_date,status) values(?,?,?,?,?,?,?,?)";

		try {
			connection = connectionUtil.getConnection();

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

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}

		return returnNumber;

	}

	public int deleteRequest(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int tempNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";

			String query = "delete from request_details where aadharcard_number =? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);

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

	public String statusCheck(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		String status = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();

			String query = "select status from  request_details where aadharcard_number =?";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				status = resultSet.getString(1);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);

		}
		return status;

	}

	public List<RequestModel> showRequest() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details order by request_id desc";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getLong(6),
						resultSet.getDate(7), resultSet.getString(8));
				requestList.add(requestModel);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return requestList;
	}

	public List<RequestModel> showRequestSeeker(Long phoneNumber) {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getLong(6),
						resultSet.getDate(7), resultSet.getString(8));
				requestList.add(requestModel);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return requestList;
	}

	public RequestModel requestObject(Long phoneNumber) {
		RequestModel requestModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where PHONE_NUMBER =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getString(4), resultSet.getLong(5), resultSet.getLong(6), resultSet.getDate(7),
						resultSet.getString(8));

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return requestModel;
	}

	public Long aadharcardValid(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Long tempNumber = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();

			String query = "select AADHARCARD_NUMBER from request_details where aadharcard_number =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				tempNumber = resultSet.getLong(1);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return tempNumber;

	}

	public List<RequestModel> requestUpdateAndDelete() {
		List<RequestModel> requestList = new ArrayList<RequestModel>();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select HOSPITAL_NAME,BLOOD_TYPE,UNIT,BLOOD_COLLECTOR_NAME,PHONE_NUMBER,AADHARCARD_NUMBER,REQUEST_DATE,STATUS from request_details where status='pending' order by request_id desc";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(1), resultSet.getString(2),
						resultSet.getInt(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getLong(6),
						resultSet.getDate(7), resultSet.getString(8));
				requestList.add(requestModel);
			}

		} catch (ClassNotFoundException e) {

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return requestList;
	}

	public int requestUpdate(RequestModel requestModel) {
		int returnNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "update   request_details set status='approved' where aadharcard_number=? and BLOOD_TYPE=?";

		try {
			connection = connectionUtil.getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, requestModel.getAadharcard());
			preparedStatement.setString(2, requestModel.getBloodType());
			returnNumber = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}

		return returnNumber;

	}

}
