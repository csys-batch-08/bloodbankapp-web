package com.bloodbank.model;

import java.util.Objects;

public class SeekerDetails {
	private String firstName;
	private String lastName;
	private String address;
	private Long phoneNumber;
	private String password;
	private Long patientId;
	private String hospitalName;
	private String bloodType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, bloodType, firstName, hospitalName, lastName, password, patientId, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeekerDetails other = (SeekerDetails) obj;
		return Objects.equals(address, other.address) && Objects.equals(bloodType, other.bloodType)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(hospitalName, other.hospitalName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(patientId, other.patientId) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	public SeekerDetails() {
		super();
	
	}

	public SeekerDetails(String firstName, String lastName, String address, Long phoneNumber, String password,
			Long patientId, String hospitalName, String bloodType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.patientId = patientId;
		this.hospitalName = hospitalName;
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "SeekerDetails [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", patientId=" + patientId
				+ ", hospitalName=" + hospitalName + ", bloodType=" + bloodType + "]";
	}

}
