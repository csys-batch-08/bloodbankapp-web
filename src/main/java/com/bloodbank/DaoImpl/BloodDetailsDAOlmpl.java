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

	public int insertBloodDetails(BloodDetailsModel details) {
		int tempNumber = 0;
		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement  preparedStatement=null;
		try {
			 con = connection.getConnection();

			String query = "insert into blood_details(blood_type,aadharcard,unit,price) values(?,?,?,?)";
			 preparedStatement = con.prepareStatement(query);
			String commit = "commit";
			preparedStatement.setString(1, details.getBloodType());
			preparedStatement.setLong(2, details.getDonor().getAadharcard());
			preparedStatement.setInt(3, details.getUnit());
			preparedStatement.setInt(4, details.getPrice());
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

	public List<BloodDetailsModel> ShowBloodDetails(Donor donor) {
		BloodDetailsModel details = null;

		List<BloodDetailsModel> showList = new ArrayList<BloodDetailsModel>();

		ConnectionUtil connection = new ConnectionUtil();
		Connection con =null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();
			String query = "select BLOOD_TYPE,AADHARCARD,UNIT,PRICE from blood_details where aadharcard=?";
			 preparedStatement = con.prepareStatement(query);
			preparedStatement.setLong(1, donor.getAadharcard());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				details = new BloodDetailsModel(donor, resultSet.getInt(3), resultSet.getString(1), resultSet.getInt(4));

				showList.add(details);
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
		return showList;

	}

}
