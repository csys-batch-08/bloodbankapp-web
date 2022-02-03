package com.bloodbank.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class BillingModel implements Serializable {
	private String bloodType;
	private SeekerDetails seeker;
	private int unit;
	private double totalprice;
	private LocalDate billDate;

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public SeekerDetails getSeeker() {
		return seeker;
	}

	public void setSeeker(SeekerDetails seeker) {
		this.seeker = seeker;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billDate, bloodType, seeker, totalprice, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingModel other = (BillingModel) obj;
		return Objects.equals(billDate, other.billDate) && Objects.equals(bloodType, other.bloodType)
				&& Objects.equals(seeker, other.seeker)
				&& Double.doubleToLongBits(totalprice) == Double.doubleToLongBits(other.totalprice)
				&& unit == other.unit;
	}

	@Override
	public String toString() {
		return "BillingModel [bloodType=" + bloodType + ", seeker=" + seeker + ", unit=" + unit + ", totalprice="
				+ totalprice + ", billDate=" + billDate + "]";
	}

	public BillingModel(String bloodType, SeekerDetails seeker, int unit, double totalprice, LocalDate billDate) {
		super();
		this.bloodType = bloodType;
		this.seeker = seeker;
		this.unit = unit;
		this.totalprice = totalprice;
		this.billDate = billDate;
	}

	public BillingModel() {
		super();

	}

}
