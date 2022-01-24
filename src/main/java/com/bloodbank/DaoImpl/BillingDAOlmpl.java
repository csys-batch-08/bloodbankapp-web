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

	public int insertBilling(BillingModel bill) {
		int returnNumber = 0;

		ConnectionUtil connection = new ConnectionUtil();
		Connection con=null;
		PreparedStatement  preparedStatement=null;
		try {
			RequestDAOlmpl requestDao = new RequestDAOlmpl();
			RequestModel model = requestDao.RequestObject(bill.getSeeker().getPhoneNumber());

			 con = connection.getConnection();
			String query = "insert into billing (blood_type,seeker_id,quantity,price) values(?,?,?,?)";
			String commit = "commit";
			SeekerDAOlmpl seeker = new SeekerDAOlmpl();
			int seekerId = seeker.seekerIdFind(bill.getSeeker());
			  preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, bill.getBloodType());
			preparedStatement.setInt(2, seekerId);
			preparedStatement.setInt(3, bill.getUnit());
			preparedStatement.setDouble(4, bill.getTotalprice());
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

	public List<BillingModel> biilingShow(BillingModel bill) {

		List<BillingModel> billingList = new ArrayList<BillingModel>();

		ConnectionUtil connection = new ConnectionUtil();
		SeekerDAOlmpl seekerDao = new SeekerDAOlmpl();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		int seekerId = seekerDao.seekerIdFind(bill.getSeeker());
		try {
		     con = connection.getConnection();
			String query = "select BLOOD_TYPE,SEEKER_ID,QUANTITY,PRICE,BILLING_DATE  from billing where SEEKER_ID=? order by bill_id desc";
		     preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, seekerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				SeekerDetails seeker = null;
				seeker = seekerDao.FindSeekerId(resultSet.getInt(3));

//				RequestDAOlmpl requestDao = new RequestDAOlmpl();
//				RequestModel model = requestDao.RequestObject(bill.getSeeker().getPhoneNumber());

				BillingModel billing = new BillingModel(resultSet.getString(1), seeker, resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getDate(5).toLocalDate());
				
				billingList.add(billing);
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
		return billingList;
	}

	public List<BillingModel> biilingShowAdmin() {

		List<BillingModel> billingList = new ArrayList<BillingModel>();

		ConnectionUtil connection = new ConnectionUtil();
		SeekerDAOlmpl seekerDao = new SeekerDAOlmpl();
		
		Connection con=null;
		Statement  statement=null;
		try {
			 con = connection.getConnection();
			String query = "select BLOOD_TYPE,SEEKER_ID,QUANTITY,PRICE,BILLING_DATE from billing order by bill_id desc ";
			  statement = con.createStatement();

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {

				SeekerDetails seeker = null;
				seeker = seekerDao.FindSeekerId(resultSet.getInt(3));
				RequestDAOlmpl requestDao = new RequestDAOlmpl();
				RequestModel model = requestDao.RequestObject(seeker.getPhoneNumber());

				BillingModel billing = new BillingModel(resultSet.getString(1), seeker, resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getDate(5).toLocalDate());
				billingList.add(billing);
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
		return billingList;
	}

	public List<BillingModel> biilingShowAdminDate(LocalDate date) {

		List<BillingModel> billingList = new ArrayList<BillingModel>();

		// SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyy");

		ConnectionUtil connection = new ConnectionUtil();
		SeekerDAOlmpl seekerDao = new SeekerDAOlmpl();
		PreparedStatement  preparedStatement=null;
		Connection con=null;
		try {
			 con = connection.getConnection();
			// String query="select * from billing where
			// TO_CHAR(billing_date=?,'YYYY-MM-DD') between TO_CHAR(SYSDATE,'YYYY-MM-DD')";
			String query = "select BLOOD_TYPE,SEEKER_ID,QUANTITY,PRICE,BILLING_DATE from billing where ?<=billing_date order by bill_id desc";
			  preparedStatement = con.prepareStatement(query);

			preparedStatement.setDate(1, java.sql.Date.valueOf(date));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				SeekerDetails seeker = null;
				seeker = seekerDao.FindSeekerId(resultSet.getInt(3));
				RequestDAOlmpl requestDao = new RequestDAOlmpl();
				RequestModel model = requestDao.RequestObject(seeker.getPhoneNumber());

				BillingModel billing = new BillingModel(resultSet.getString(1), seeker, resultSet.getInt(3), resultSet.getInt(4),
						resultSet.getDate(5).toLocalDate());
				billingList.add(billing);
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
		return billingList;
	}
}
