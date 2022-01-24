package com.bloodbank.model;

import java.util.Objects;

public class BloodDetailsModel {
	private Donor donor;
	private int unit;
	private String bloodType;
	private int price;

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloodType, donor, price, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BloodDetailsModel other = (BloodDetailsModel) obj;
		return Objects.equals(bloodType, other.bloodType) && Objects.equals(donor, other.donor) && price == other.price
				&& unit == other.unit;
	}

	@Override
	public String toString() {
		return "BloodDetailsModel [donor=" + donor + ", unit=" + unit + ", bloodType=" + bloodType + ", price=" + price
				+ "]";
	}

	public BloodDetailsModel(Donor donor, int unit, String bloodType, int price) {
		super();
		this.donor = donor;
		this.unit = unit;
		this.bloodType = bloodType;
		this.price = price;
	}

	public BloodDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
