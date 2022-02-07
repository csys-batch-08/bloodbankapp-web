package com.bloodbank.Dao;

import java.util.List;

import com.bloodbank.model.Donor;

public interface DonorDAO {

	public Donor validNumber(Long number);

	public int insertDonor(Donor donor);

	public List<Donor> showDonor();

	public Long aadharcardNumber(Donor donor);

	public Donor validAadharcardNumber(Long aaaadharcard);
}
