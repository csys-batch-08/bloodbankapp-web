package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bloodbank.Dao.BillingDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

public class BillingDAOlmpl implements BillingDAO {

	public int insertBilling(BillingModel billingModel) {
		int returnNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "insert into billing (blood_type,seeker_id,quantity,price) values(?,?,?,?)";
			String commit = "commit";

			SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();
			int seekerId = seekerDAOlmpl.seekerIdFind(billingModel.getSeeker());

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, billingModel.getBloodType());
			preparedStatement.setInt(2, seekerId);
			preparedStatement.setInt(3, billingModel.getUnit());
			preparedStatement.setDouble(4, billingModel.getTotalprice());
			returnNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException a) {

			a.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}
		return returnNumber;

	}

	public List<BillingModel> biilingShow(BillingModel billingModel) {

		List<BillingModel> billingList = new ArrayList();

		ConnectionUtil connectionUtil = new ConnectionUtil();
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int seekerId = seekerDAOlmpl.seekerIdFind(billingModel.getSeeker());
		try {
			connection = connectionUtil.getConnection();
			String query = "select BLOOD_TYPE,SEEKER_ID,QUANTITY,PRICE,BILLING_DATE  from billing where SEEKER_ID=? order by bill_id desc";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, seekerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				SeekerDetails seekerDetails = null;
				seekerDetails = seekerDAOlmpl.findSeekerId(resultSet.getInt(3));

				BillingModel billing = new BillingModel(resultSet.getString(1), seekerDetails, resultSet.getInt(3),
						resultSet.getInt(4), resultSet.getDate(5).toLocalDate());

				billingList.add(billing);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return billingList;
	}

	public List<BillingModel> biilingShowAdmin() {

		List<BillingModel> billingList = new ArrayList();

		ConnectionUtil connectionUtil = new ConnectionUtil();
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select BLOOD_TYPE,SEEKER_ID,QUANTITY,PRICE,BILLING_DATE from billing order by bill_id desc ";
			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				SeekerDetails seekerDetails = null;
				seekerDetails = seekerDAOlmpl.findSeekerId(resultSet.getInt(3));

				BillingModel billing = new BillingModel(resultSet.getString(1), seekerDetails, resultSet.getInt(3),
						resultSet.getInt(4), resultSet.getDate(5).toLocalDate());
				billingList.add(billing);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return billingList;
	}

	public List<BillingModel> biilingShowAdminDate(LocalDate date) {

		List<BillingModel> billingList = new ArrayList();

		ConnectionUtil connectionUtil = new ConnectionUtil();
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		SeekerDetails seekerDetails = null;
		ResultSet resultSet = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select BLOOD_TYPE,SEEKER_ID,QUANTITY,PRICE,BILLING_DATE from billing where ?<=billing_date order by bill_id desc";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setDate(1, java.sql.Date.valueOf(date));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				seekerDetails = seekerDAOlmpl.findSeekerId(resultSet.getInt(3));

				BillingModel billing = new BillingModel(resultSet.getString(1), seekerDetails, resultSet.getInt(3),
						resultSet.getInt(4), resultSet.getDate(5).toLocalDate());
				billingList.add(billing);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {

			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return billingList;
	}
}
