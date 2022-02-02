package com.bloodbank.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BookingModel {

	private Donor donor;
	private String address;
	private LocalDate appdate;
	private String bloodType;
	private String bloodCollectChoice;

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getAppdate() {
		return appdate;
	}

	public void setAppdate(LocalDate appdate) {
		this.appdate = appdate;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getBloodCollectChoice() {
		return bloodCollectChoice;
	}

	public void setBloodCollectChoice(String bloodCollectChoice) {
		this.bloodCollectChoice = bloodCollectChoice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, appdate, bloodCollectChoice, bloodType, donor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingModel other = (BookingModel) obj;
		return Objects.equals(address, other.address) && Objects.equals(appdate, other.appdate)
				&& Objects.equals(bloodCollectChoice, other.bloodCollectChoice)
				&& Objects.equals(bloodType, other.bloodType) && Objects.equals(donor, other.donor);
	}

	@Override
	public String toString() {
		return "BookingModel [donor=" + donor + ", address=" + address + ", appdate=" + appdate + ", bloodType="
				+ bloodType + ", bloodCollectChoice=" + bloodCollectChoice + "]";
	}

	public BookingModel(Donor donor, String address, LocalDate appdate, String bloodType, String bloodCollectChoice) {
		super();
		this.donor = donor;
		this.address = address;
		this.appdate = appdate;
		this.bloodType = bloodType;
		this.bloodCollectChoice = bloodCollectChoice;
	}

	public BookingModel() {
		super();
		
	}

}
