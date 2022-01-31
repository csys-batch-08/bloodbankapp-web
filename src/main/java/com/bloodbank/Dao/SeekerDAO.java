package com.bloodbank.Dao;

import com.bloodbank.model.SeekerDetails;

public interface SeekerDAO  {
	
	public int insertSeekerDetails( SeekerDetails details);
	
	
	public int seekerIdFind(SeekerDetails seeker);
	
	public SeekerDetails seekerObject(String password, Long phoneNumber);
	
	public SeekerDetails findSeekerId(int seekerId);
	
	public int forgotPassword(Long phoneNumber ,String password); 
	
	public SeekerDetails findSeekerObjectId(long phoneNumber);
	
	public Long phoneNumberValid(long phoneNumber);
	
	
	
}
