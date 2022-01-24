package com.bloodbank.model;

import java.util.Date;
import java.util.Objects;

public class RequestModel {

	private String hospitalName;
	private String bloodType;
	private int unit;
	private String bloodCollectorName;
	private Long phoneNumber;
	private Long aadharcard;
	private Date requestDate;
	private String status;

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

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getBloodCollectorName() {
		return bloodCollectorName;
	}

	public void setBloodCollectorName(String bloodCollectorName) {
		this.bloodCollectorName = bloodCollectorName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(Long aadharcard) {
		this.aadharcard = aadharcard;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aadharcard, bloodCollectorName, bloodType, hospitalName, phoneNumber, requestDate, status,
				unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestModel other = (RequestModel) obj;
		return Objects.equals(aadharcard, other.aadharcard)
				&& Objects.equals(bloodCollectorName, other.bloodCollectorName)
				&& Objects.equals(bloodType, other.bloodType) && Objects.equals(hospitalName, other.hospitalName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(requestDate, other.requestDate)
				&& Objects.equals(status, other.status) && unit == other.unit;
	}

	@Override
	public String toString() {
		return "RequestModel [hospitalName=" + hospitalName + ", bloodType=" + bloodType + ", unit=" + unit
				+ ", bloodCollectorName=" + bloodCollectorName + ", phoneNumber=" + phoneNumber + ", aadharcard="
				+ aadharcard + ", requestDate=" + requestDate + ", status=" + status + "]";
	}

	public RequestModel(String hospitalName, String bloodType, int unit, String bloodCollectorName, Long phoneNumber,
			Long aadharcard, Date requestDate, String status) {
		super();
		this.hospitalName = hospitalName;
		this.bloodType = bloodType;
		this.unit = unit;
		this.bloodCollectorName = bloodCollectorName;
		this.phoneNumber = phoneNumber;
		this.aadharcard = aadharcard;
		this.requestDate = requestDate;
		this.status = status;
	}

	public RequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
