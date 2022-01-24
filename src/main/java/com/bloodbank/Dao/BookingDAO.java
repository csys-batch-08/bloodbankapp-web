package com.bloodbank.Dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public interface BookingDAO {

	public int  booking(BookingModel book);
	
	 public int updateBooking(BookingModel book);
	
	
	 public int deleteBooking(Long aadharcard);
	
	 public List<BookingModel> HomeCollection();
	
	 public LocalDate dateCheck(Donor donor);
	
	 public int updateDateForDonor(BookingModel book);
	 public List<BookingModel> ShowBookingAdmin();
	
	 public List<BookingModel> ShowBookingDonor(Donor donor);
	
	
	
}
