package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.RequestDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.RequestModel;

public class RequestDAOlmpl implements RequestDAO {

	static final String HOSPITALNAME = "hospital_name";
	static final String BLOODTYPE = "blood_type";
	static final String BLOODUNIT = "blood_unit";
	static final String BLOODCOLLECTERNAME = "blood_collector_name";
	static final String PHONENUMBER = "phone_number";
	static final String AADHARCARDNUMER = "aadharcard_number";
	static final String REQUESTDATE = "request_date";
	static final String STATUS = "status";

	@Override
	public int insertRequest(RequestModel requestModel) {
		int returnNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into request_details (hospital_name,blood_type,blood_unit,blood_collector_name,phone_number,aadharcard_number,request_date,status) values(?,?,?,?,?,?,?,?)";

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

	@Override
	public int deleteRequest(Long aadharcardNumber, String bloodType) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int tempNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";

			String query = "delete from request_details where aadharcard_number =? and blood_type=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			preparedStatement.setString(2, bloodType);

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

	@Override
	public String statusCheck(Long aadharcardNumber, String bloodType) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		String status = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();

			String query = "select status from  request_details where aadharcard_number =? and blood_type=? ";

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			preparedStatement.setString(2, bloodType);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				status = resultSet.getString(STATUS);
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

	@Override
	public List<RequestModel> showRequest() {
		List<RequestModel> requestList = new ArrayList();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select hospital_name,blood_type,blood_unit,blood_collector_name,phone_number,aadharcard_number,request_date,status from request_details order by request_id desc";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(HOSPITALNAME),
						resultSet.getString(BLOODTYPE), resultSet.getInt(BLOODUNIT),
						resultSet.getString(BLOODCOLLECTERNAME), resultSet.getLong(PHONENUMBER),
						resultSet.getLong(AADHARCARDNUMER), resultSet.getDate(REQUESTDATE),
						resultSet.getString(STATUS));
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

	@Override
	public List<RequestModel> showRequestSeeker(Long phoneNumber) {
		List<RequestModel> requestList = new ArrayList();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select hospital_name,blood_type,blood_unit,blood_collector_name,phone_number,aadharcard_number,request_date,status from request_details where phone_number =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(HOSPITALNAME),
						resultSet.getString(BLOODTYPE), resultSet.getInt(BLOODUNIT),
						resultSet.getString(BLOODCOLLECTERNAME), resultSet.getLong(PHONENUMBER),
						resultSet.getLong(AADHARCARDNUMER), resultSet.getDate(REQUESTDATE),
						resultSet.getString(STATUS));
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

	@Override
	public RequestModel requestObject(Long phoneNumber) {
		RequestModel requestModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select hospital_name,blood_type,blood_unit,blood_collector_name,phone_number,aadharcard_number,request_date,status from request_details where phone_number =? order by request_id desc";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				requestModel = new RequestModel(resultSet.getString(HOSPITALNAME), resultSet.getString(BLOODTYPE),
						resultSet.getInt(BLOODUNIT), resultSet.getString(BLOODCOLLECTERNAME),
						resultSet.getLong(PHONENUMBER), resultSet.getLong(AADHARCARDNUMER),
						resultSet.getDate(REQUESTDATE), resultSet.getString(STATUS));

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

	@Override
	public Long aadharcardValid(Long aadharcardNumber) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Long tempNumber = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();

			String query = "select aadharcard_number from request_details where aadharcard_number =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, aadharcardNumber);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				tempNumber = resultSet.getLong(AADHARCARDNUMER);
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

	@Override
	public List<RequestModel> requestUpdateAndDelete() {
		List<RequestModel> requestList = new ArrayList();
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select hospital_name,blood_type,blood_unit,blood_collector_name,phone_number,aadharcard_number,request_date,status from request_details where status='pending' order by request_id desc";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {

				RequestModel requestModel = new RequestModel(resultSet.getString(HOSPITALNAME),
						resultSet.getString(BLOODTYPE), resultSet.getInt(BLOODUNIT),
						resultSet.getString(BLOODCOLLECTERNAME), resultSet.getLong(PHONENUMBER),
						resultSet.getLong(AADHARCARDNUMER), resultSet.getDate(REQUESTDATE),
						resultSet.getString(STATUS));
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

	@Override
	public int requestUpdate(RequestModel requestModel) {
		int returnNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "update request_details set status='approved' where aadharcard_number=? and BLOOD_TYPE=?";

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
