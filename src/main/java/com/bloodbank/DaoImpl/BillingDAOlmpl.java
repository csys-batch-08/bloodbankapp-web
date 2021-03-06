package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BillingDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.SeekerDetails;

public class BillingDAOlmpl implements BillingDAO {
	static final String BLOODTYPE = "blood_type";
	static final String SEEKERID = "seeker_id";
	static final String QUANTITY = "quantity";
	static final String QUANTITYPRICE = "quantity_price";
	static final String BILLINGDATE = "billing_date";

	/**
	 * Insert the bill for seeker
	 */
	@Override
	public int insertBilling(BillingModel billingModel) {

		int returnNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "insert into seeker_blood_bill (blood_type,seeker_id,quantity,quantity_price) values(?,?,?,?)";
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

	/**
	 * Show the seeker billing
	 */
	@Override
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
			String query = "select blood_type,seeker_id,quantity,quantity_price,billing_date from"
					+ " seeker_blood_bill where seeker_id=? order by bill_id desc";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, seekerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				SeekerDetails seekerDetails = null;
				seekerDetails = seekerDAOlmpl.findSeekerId(resultSet.getInt(SEEKERID));

				BillingModel billing = new BillingModel(resultSet.getString(BLOODTYPE), seekerDetails,
						resultSet.getInt(QUANTITY), resultSet.getInt(QUANTITYPRICE),
						resultSet.getDate(BILLINGDATE).toLocalDate());

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

	/**
	 * Show the all billing
	 */
	@Override
	public List<BillingModel> biilingShowAdmin() {

		List<BillingModel> billingList = new ArrayList();

		ConnectionUtil connectionUtil = new ConnectionUtil();
		SeekerDAOlmpl seekerDAOlmpl = new SeekerDAOlmpl();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select blood_type,seeker_id,quantity,quantity_price,billing_date"
					+ " from seeker_blood_bill order by bill_id desc ";
			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				SeekerDetails seekerDetails = null;
				seekerDetails = seekerDAOlmpl.findSeekerId(resultSet.getInt(SEEKERID));

				BillingModel billing = new BillingModel(resultSet.getString(BLOODTYPE), seekerDetails,
						resultSet.getInt(QUANTITY), resultSet.getInt(QUANTITYPRICE),
						resultSet.getDate(BILLINGDATE).toLocalDate());
				billingList.add(billing);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return billingList;
	}

	/**
	 * Show the bill for date defined
	 */
	@Override
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
			String query = "select blood_type,seeker_id,quantity,quantity_price,billing_date from seeker_blood_bill "
					+ "where ?<=billing_date order by bill_id desc";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setDate(1, java.sql.Date.valueOf(date));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				seekerDetails = seekerDAOlmpl.findSeekerId(resultSet.getInt(SEEKERID));

				BillingModel billing = new BillingModel(resultSet.getString(BLOODTYPE), seekerDetails,
						resultSet.getInt(QUANTITY), resultSet.getInt(QUANTITYPRICE),
						resultSet.getDate(BILLINGDATE).toLocalDate());
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
