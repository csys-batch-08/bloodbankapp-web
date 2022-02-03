package com.bloodbank.model;

import java.io.Serializable;
import java.util.Objects;

public class BloodDetailsModel implements Serializable {
	private Donor donor;
	private int unit;
	private String bloodType;
	private double bloodPrice;

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

	public double getBloodPrice() {
		return bloodPrice;
	}

	public void setBloodPrice(double bloodPrice) {
		this.bloodPrice = bloodPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloodPrice, bloodType, donor, unit);
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
		return Double.doubleToLongBits(bloodPrice) == Double.doubleToLongBits(other.bloodPrice)
				&& Objects.equals(bloodType, other.bloodType) && Objects.equals(donor, other.donor)
				&& unit == other.unit;
	}

	@Override
	public String toString() {
		return "BloodDetailsModel [donor=" + donor + ", unit=" + unit + ", bloodType=" + bloodType + ", bloodPrice="
				+ bloodPrice + "]";
	}

	public BloodDetailsModel(Donor donor, int unit, String bloodType, double bloodPrice) {
		super();
		this.donor = donor;
		this.unit = unit;
		this.bloodType = bloodType;
		this.bloodPrice = bloodPrice;
	}

	public BloodDetailsModel() {
		super();

	}

}
