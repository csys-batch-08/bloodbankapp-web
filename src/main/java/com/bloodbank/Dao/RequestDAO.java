package com.bloodbank.Dao;

import java.util.List;

import com.bloodbank.model.RequestModel;

public interface RequestDAO {

	public int insertRequest(RequestModel request);

	public int deleteRequest(Long aadharcardNumber, String bloodType);

	public List<RequestModel> showRequest();

	public String statusCheck(Long aadharcardNumber, String bloodType);

	public List<RequestModel> showRequestSeeker(Long phoneNumber);

	public RequestModel requestObject(Long phoneNumber);

	public int requestUpdate(RequestModel requestModel);

	public Long aadharcardValid(Long aadharcard);

	public List<RequestModel> requestUpdateAndDelete();

}
