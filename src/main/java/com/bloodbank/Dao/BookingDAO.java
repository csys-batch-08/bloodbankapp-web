package com.bloodbank.Dao;

import java.time.LocalDate;
import java.util.List;

import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public interface BookingDAO {

	public int booking(BookingModel book);

	public int deleteBooking(Long aadharcard);

	public List<BookingModel> homeCollection();

	public LocalDate dateCheck(Donor donor);

	public List<BookingModel> showBookingAdmin();

	public List<BookingModel> showBookingDonor(Donor donor);

}
