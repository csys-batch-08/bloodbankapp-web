package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bloodbank.Dao.BookingDAO;
import com.bloodbank.Dao.DonorDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public class BookingDAOlmpl implements BookingDAO {

	public int booking(BookingModel  bookingModel) {
		int tempNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		String query = "insert into booking (aadharcard,address,book_date,blood_type,blood_collect_choice) values(?,?,?,?,?)";
		Connection connection=null;
		PreparedStatement  preparedStatement=null;
		
		try {
			connection = connectionUtil.getConnection();
			 preparedStatement = connection.prepareStatement(query);
			// System.out.println("nothing"+book.getAddress());
			// String commit="commit";
			// System.out.println(book.getDonor().getAadharcard());

			preparedStatement.setLong(1, bookingModel.getDonor().getAadharcard());
			preparedStatement.setString(2, bookingModel.getAddress());
			preparedStatement.setDate(3, java.sql.Date.valueOf(bookingModel.getAppdate()));
			preparedStatement.setString(4, bookingModel.getBloodType());
			preparedStatement.setString(5, bookingModel.getBloodCollectChoice());

			tempNumber = preparedStatement.executeUpdate();

			// pstmt.executeQuery(commit);
			// System.out.println("insert"+tempNumber);
			// fg System.out.println("DONE...!!!");

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
		return tempNumber;

	}

	public int updateBooking(BookingModel  bookingModel) {
		int tempNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection = connectionUtil.getConnection();
			String query = "update booking set address=?,book_date=?,blood_collect_choice=? where aadharcard=?";
			 preparedStatement = connection.prepareStatement(query);
			// String commit="commit";
			preparedStatement.setString(1, bookingModel.getAddress());
			preparedStatement.setDate(2, java.sql.Date.valueOf((bookingModel.getAppdate())));
			preparedStatement.setLong(4, bookingModel.getDonor().getAadharcard());
			preparedStatement.setString(3, bookingModel.getBloodCollectChoice());
			tempNumber = preparedStatement.executeUpdate();
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
		return tempNumber;

	}

	public int deleteBooking(Long aadharcard) {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		// System.out.println(aadharcard+"dfvgbhnjm");
		int tempNumber = 0;
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";
			String query = "delete from booking where aadharcard=?";
			 preparedStatement = connection.prepareStatement(query);

			preparedStatement.setLong(1, aadharcard);

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
			ConnectionUtil.closePreparedStatement(preparedStatement, connection,null);
		}
		return tempNumber;

	}

	public List<BookingModel> HomeCollection() {
		BookingModel bookingModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<BookingModel> booking = new ArrayList<BookingModel>();
		Connection connection=null;
		Statement  statement=null;
		ResultSet resultSet=null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select  AADHARCARD,ADDRESS,BOOK_DATE,BLOOD_TYPE,BLOOD_COLLECT_CHOICE from booking where BLOOD_COLLECT_CHOICE ='home'";
			  statement = connection.createStatement();
			 resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DonorDAOImpl donor = new DonorDAOImpl();

				Donor donor1 = donor.validAadharcardNumber(resultSet.getLong(1));
				// System.out.println(donor1);
				bookingModel = new BookingModel(donor1, resultSet.getString(2), resultSet.getDate(3).toLocalDate(), resultSet.getString(4),
						resultSet.getString(5));

				booking.add(bookingModel);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection,resultSet);
		}
		return booking;

	}

	public LocalDate dateCheck(Donor donor) {
		LocalDate date = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		PreparedStatement  preparedStatement =null;
		ResultSet resultSet=null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select book_date+90 from booking where aadharcard=?";
			 preparedStatement = connection.prepareStatement(query);
			// System.out.println(donor.getAadharcard()+"dfcvgbhnjmk,l");
			preparedStatement.setLong(1, donor.getAadharcard());
			// System.out.println(donor.getAdharcard());
			 resultSet = preparedStatement.executeQuery();
			// System.out.println("date");
			while (resultSet.next()) {

				date = resultSet.getDate(1).toLocalDate();
				// System.out.println("date "+ rs.(1));
				// System.out.println("Date"+date);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(date);

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection,resultSet);
		}
		return date;
	}

	public int updateDateForDonor(BookingModel  bookingModel) {
   int returnNumber=0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";
			String query = "update booking set book_date=? where aadharcard=?";
			 preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, java.sql.Date.valueOf(bookingModel.getAppdate()));
			preparedStatement.setLong(2, bookingModel.getDonor().getAadharcard());
			returnNumber=preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

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

	public List<BookingModel> ShowBookingDonor(Donor donor) {
		BookingModel bookingModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<BookingModel> booking = new ArrayList<BookingModel>();
		Connection connection=null;
		ResultSet resultSet=null;
		 PreparedStatement  preparedStatement=null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select  AADHARCARD,ADDRESS,BOOK_DATE,BLOOD_TYPE,BLOOD_COLLECT_CHOICE from booking where aadharcard=?" ;
			    preparedStatement=connection.prepareStatement(query);
			  preparedStatement.setLong(1, donor.getAadharcard());
			 resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// System.out.println(donor1);
				bookingModel = new BookingModel(donor, resultSet.getString(2), resultSet.getDate(3).toLocalDate(), resultSet.getString(4),
						resultSet.getString(5));

				booking.add(bookingModel);

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
		return booking;

	}

	public List<BookingModel> ShowBookingAdmin() {
		BookingModel bookingModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<BookingModel> booking = new ArrayList<BookingModel>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select AADHARCARD,ADDRESS,BOOK_DATE,BLOOD_TYPE,BLOOD_COLLECT_CHOICE from booking ";
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(query);
		    	while (resultSet.next()) {
				DonorDAOImpl donor = new DonorDAOImpl();

				Donor donor1 = donor.validAadharcardNumber(resultSet.getLong(1));
				// System.out.println(donor1);
				bookingModel = new BookingModel(donor1, resultSet.getString(2), resultSet.getDate(3).toLocalDate(), resultSet.getString(4),
						resultSet.getString(5));

				booking.add(bookingModel);

			}
			// System.out.println(rs.getString(3));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.closeStatement(statement, connection,resultSet);
		}

		return booking;

	}


}
