package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BloodDetailsDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.Donor;

public class BloodDetailsDAOlmpl implements BloodDetailsDAO {
	static final String BLOODTYPE = "blood_type";
	static final String BLOODUNIT = "blood_unit";
	static final String BLOODUNITPRICE = "blood_unit_price";

	/**
	 * Insert the blood details
	 */
	@Override
	public int insertBloodDetails(BloodDetailsModel detailsModel) {
		int tempNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();

			String query = "insert into blood_details(blood_type,aadharcard_number,blood_unit,blood_unit_price) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			String commit = "commit";
			preparedStatement.setString(1, detailsModel.getBloodType());
			preparedStatement.setLong(2, detailsModel.getDonor().getAadharcard());
			preparedStatement.setInt(3, detailsModel.getUnit());
			preparedStatement.setDouble(4, detailsModel.getBloodPrice());
			tempNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}
		return tempNumber;

	}

	/**
	 * show for blood details in donor
	 */
	@Override
	public List<BloodDetailsModel> showBloodDetails(Donor donor) {
		BloodDetailsModel detailsModel = null;

		List<BloodDetailsModel> showList = new ArrayList();

		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select blood_type,aadharcard_number,blood_unit,blood_unit_price from blood_details where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, donor.getAadharcard());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				detailsModel = new BloodDetailsModel(donor, resultSet.getInt(BLOODUNIT), resultSet.getString(BLOODTYPE),
						resultSet.getDouble(BLOODUNITPRICE));

				showList.add(detailsModel);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return showList;

	}

}
