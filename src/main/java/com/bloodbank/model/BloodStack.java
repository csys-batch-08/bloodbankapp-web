package com.bloodbank.model;

import java.io.Serializable;
import java.util.Objects;

public class BloodStack implements Serializable {
	private int quantity;
	private String bloodType;
	private double bloodPrice;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return Objects.hash(bloodPrice, bloodType, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BloodStack other = (BloodStack) obj;
		return Double.doubleToLongBits(bloodPrice) == Double.doubleToLongBits(other.bloodPrice)
				&& Objects.equals(bloodType, other.bloodType) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "BloodStack [quantity=" + quantity + ", bloodType=" + bloodType + ", bloodPrice=" + bloodPrice + "]";
	}

	public BloodStack(int quantity, String bloodType, double bloodPrice) {
		super();
		this.quantity = quantity;
		this.bloodType = bloodType;
		this.bloodPrice = bloodPrice;
	}

	public BloodStack() {
		super();

	}

}
