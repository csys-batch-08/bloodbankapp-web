package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BloodStackDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.RequestModel;

public class BloodStackDAOlmpl implements BloodStackDAO {


	public int updateStack(BloodStack stack) {
		ConnectionUtil connection = new ConnectionUtil();
		int returnNumber = 0;
		Connection con =null;
		PreparedStatement  preparedStatement=null;
		
		try {
			 con = connection.getConnection();

			int quantity = checkOfQuantity(stack.getBloodType().toLowerCase());

			// System.out.println(stack.getBloodType()+""+quantity);

			String query = "update blood_stack set quantity=? where blood_type=?";
		     preparedStatement = con.prepareStatement(query);
			String commit = "commit";
			preparedStatement.setInt(1, quantity + stack.getQuantity());
			preparedStatement.setString(2, stack.getBloodType());
			returnNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
 
		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, con);
		}
		return returnNumber;
	}

	public List<BloodStack> showStack() {
		ConnectionUtil connection = new ConnectionUtil();
		BloodStack stack1 = null;
		List<BloodStack> stockDetails = new ArrayList<BloodStack>();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		
		try {
			String query = "select BLOOD_TYPE,QUANTITY,UNIT_PRICE from blood_stack";
			 preparedStatement = con.prepareStatement(query);
			// pstmt.setString(1, stack.getBloodType());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				stack1 = new BloodStack(resultSet.getInt(2), resultSet.getString(1), resultSet.getInt(3));
				stockDetails.add(stack1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, con);
		}
		return stockDetails;
	}

	public int checkOfQuantity(String bloodtype) {
		ConnectionUtil connection = new ConnectionUtil();
		
		int returnNumber = 0;
		Connection con =null;
		PreparedStatement  preparedStatement=null;
		try {

			 con = connection.getConnection();
			String query = "select QUANTITY from  blood_stack where blood_type=?";
		    preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, bloodtype);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				returnNumber = resultSet.getInt(1);

			}

			System.out.println(returnNumber);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(n+"QUANTITY"+bloodtype);
		finally{
			ConnectionUtil.closePreparedStatement(preparedStatement, con);
		}
		return returnNumber;
	}

	public int updateStackReduce(String bloodType, int unit) {
		ConnectionUtil connection = new ConnectionUtil();
		int returnNumber = 0;
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connection.getConnection();

			String query = "update blood_stack set quantity=? where blood_type=?";
			 preparedStatement = con.prepareStatement(query);
			String commit = "commit";
			int totalUnit = checkOfQuantity(bloodType) - unit;
			preparedStatement.setInt(1, totalUnit);
			preparedStatement.setString(2, bloodType);
			returnNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
		finally {
         ConnectionUtil.closePreparedStatement(preparedStatement, con);
		}
		return returnNumber;
	}

	public double findPrice(String bloodType) {
		double returnNumber = 0;
		ConnectionUtil connectin = new ConnectionUtil();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		try {
			 con = connectin.getConnection();
			String query = "select UNIT_PRICE from blood_stack where blood_type=?";
			 preparedStatement = con.prepareStatement(query);
			//System.out.println(bloodType);
			preparedStatement.setString(1, bloodType);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				//System.out.println(rs.getInt(1));
				returnNumber = resultSet.getDouble(1);

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
		return returnNumber;
	}

//	public List<BloodStack> HomeCollection(){
//		
//		List<BloodStack>bloodList=new ArrayList<BloodStack>();
//		ConnectionUtil connection=new ConnectionUtil();
//		BloodStack stack=null;
//		String query="select donor_details.first_name,booking.address from donor_details inner join booking on donor_details.adharcard=booking.adharcard\r\n"
//				+ "where BLOOD_COLLECT_CHOICE='home'";
//		try {
//			Connection con=connection.getConnection();
//			
//			Statement stmt=con.createStatement();
//		ResultSet rs= stmt.executeQuery(query);
//		while(rs.next()) {
//			
//			
//			
//		}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		return bloodList;
//		
//	}

//public BloodStack FindBlood(String type) {
//	
//	ConnectionUtil connection=new ConnectionUtil();
//	try {
//		Connection con=connection.getConnection();
//		String query="select * from blood_stack where blood_type=?";
//		PreparedStatement pstmt=con.prepareStatement(query);
//		pstmt.setString(1,type );
//		ResultSet rs=.executeQuery();
//		
//		
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	

//	return null;
//	
//}

}
