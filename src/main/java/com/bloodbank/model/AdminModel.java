package com.bloodbank.model;

import java.util.Objects;

public class AdminModel {

	private String email;
	private String password;
	private double wallet;

	public AdminModel() {
		super();
	
	}

	public AdminModel(String email, String password, double wallet) {
		super();
		this.email = email;
		this.password = password;
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "AdminModel [email=" + email + ", password=" + password + ", wallet=" + wallet + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, wallet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminModel other = (AdminModel) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Double.doubleToLongBits(wallet) == Double.doubleToLongBits(other.wallet);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

}
