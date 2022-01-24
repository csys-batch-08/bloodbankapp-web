package com.bloodbank.model;

import java.util.Objects;

public class BloodStack {
	private int quantity;
	private String bloodType;
	private int price;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloodType, price, quantity);
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
		return Objects.equals(bloodType, other.bloodType) && price == other.price && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "BloodStack [quantity=" + quantity + ", bloodType=" + bloodType + ", price=" + price + "]";
	}

	public BloodStack(int quantity, String bloodType, int price) {
		super();
		this.quantity = quantity;
		this.bloodType = bloodType;
		this.price = price;
	}

	public BloodStack() {
		super();
		// TODO Auto-generated constructor stub
	}

}
