package com.bloodbank.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.Dao.BookingDAO;
import com.bloodbank.Util.ConnectionUtil;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public class BookingDAOlmpl implements BookingDAO {

	static final String AADHARCARDNUMBER = "aadharcard_number";
	static final String ADDRESS = "address";
	static final String BOOKDATE = "book_date";
	static final String BLOODTYPE = "blood_type";
	static final String DONORCHOICE = "blood_collect_choice";

	@Override
	public int booking(BookingModel bookingModel) {
		int tempNumber = 0;

		ConnectionUtil connectionUtil = new ConnectionUtil();
		String query = "insert into donor_booking (aadharcard_number,address,book_date,blood_type,blood_collect_choice) values(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setLong(1, bookingModel.getDonor().getAadharcard());
			preparedStatement.setString(2, bookingModel.getAddress());
			preparedStatement.setDate(3, java.sql.Date.valueOf(bookingModel.getAppdate()));
			preparedStatement.setString(4, bookingModel.getBloodType());
			preparedStatement.setString(5, bookingModel.getBloodCollectChoice());

			tempNumber = preparedStatement.executeUpdate();

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
	public int updateBooking(BookingModel bookingModel) {
		int tempNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "update donor_booking set address=?,book_date=?,blood_collect_choice=? where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, bookingModel.getAddress());
			preparedStatement.setDate(2, java.sql.Date.valueOf((bookingModel.getAppdate())));
			preparedStatement.setLong(4, bookingModel.getDonor().getAadharcard());
			preparedStatement.setString(3, bookingModel.getBloodCollectChoice());
			tempNumber = preparedStatement.executeUpdate();

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

	@Override
	public int deleteBooking(Long aadharcard) {
		ConnectionUtil connectionUtil = new ConnectionUtil();

		int tempNumber = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";
			String query = "delete from donor_booking where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setLong(1, aadharcard);

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

	@Override
	public List<BookingModel> homeCollection() {
		BookingModel bookingModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<BookingModel> booking = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select  aadharcard_number,address,book_date,blood_type,blood_collect_choice from donor_booking where BLOOD_COLLECT_CHOICE ='home'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DonorDAOImpl donor = new DonorDAOImpl();

				Donor donor1 = donor.validAadharcardNumber(resultSet.getLong(AADHARCARDNUMBER));

				bookingModel = new BookingModel(donor1, resultSet.getString(ADDRESS),
						resultSet.getDate(BOOKDATE).toLocalDate(), resultSet.getString(BLOODTYPE),
						resultSet.getString(DONORCHOICE));

				booking.add(bookingModel);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}
		return booking;

	}

	@Override
	public LocalDate dateCheck(Donor donor) {
		LocalDate date = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionUtil.getConnection();
			String query = "select book_date+90  from donor_booking where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setLong(1, donor.getAadharcard());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				date = resultSet.getDate(1).toLocalDate();

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return date;
	}

	@Override
	public int updateDateForDonor(BookingModel bookingModel) {
		int returnNumber = 0;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = connectionUtil.getConnection();
			String commit = "commit";
			String query = "update donor_booking set book_date=? where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, java.sql.Date.valueOf(bookingModel.getAppdate()));
			preparedStatement.setLong(2, bookingModel.getDonor().getAadharcard());
			returnNumber = preparedStatement.executeUpdate();
			preparedStatement.executeQuery(commit);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, null);
		}
		return returnNumber;
	}

	@Override
	public List<BookingModel> showBookingDonor(Donor donor) {
		BookingModel bookingModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<BookingModel> booking = new ArrayList();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select  aadharcard_number,address,book_date,blood_type,blood_collect_choice from donor_booking where aadharcard_number=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, donor.getAadharcard());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				bookingModel = new BookingModel(donor, resultSet.getString(ADDRESS),
						resultSet.getDate(BOOKDATE).toLocalDate(), resultSet.getString(BLOODTYPE),
						resultSet.getString(DONORCHOICE));

				booking.add(bookingModel);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		finally {
			ConnectionUtil.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return booking;

	}

	@Override
	public List<BookingModel> showBookingAdmin() {
		BookingModel bookingModel = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<BookingModel> booking = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = connectionUtil.getConnection();
			String query = "select aadharcard_number,address,book_date,blood_type,blood_collect_choice from donor_booking ";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				DonorDAOImpl donor = new DonorDAOImpl();

				Donor donor1 = donor.validAadharcardNumber(resultSet.getLong(AADHARCARDNUMBER));

				bookingModel = new BookingModel(donor1, resultSet.getString(ADDRESS),
						resultSet.getDate(BOOKDATE).toLocalDate(), resultSet.getString(BLOODTYPE),
						resultSet.getString(DONORCHOICE));

				booking.add(bookingModel);

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.closeStatement(statement, connection, resultSet);
		}

		return booking;

	}

}
