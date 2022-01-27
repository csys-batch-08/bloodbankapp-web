package com.bloodbank.Dao;

import java.util.List;

import com.bloodbank.model.RequestModel;

public interface RequestDAO {

	
	public int insertRequest(RequestModel request);
	
	public int deleteRequest(Long aadharcardNumber);
	
	public List<RequestModel> ShowRequest();
	
	public String StatusCheck(Long aadharcard);
	
	public List<RequestModel> ShowRequestSeeker(Long phoneNumber);
	
	public RequestModel RequestObject(Long phoneNumber);
	
	public int RequestUpdate(RequestModel  requestModel);
	
	public Long AadharcardValid(Long aadharcard);
	
	public List<RequestModel> RequestUpdateAndDelete();
	
	
}
