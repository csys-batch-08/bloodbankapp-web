package com.bloodbank.Dao;

import com.bloodbank.model.SeekerDetails;

public interface SeekerDAO  {
	
	public int insertSeekerDetails( SeekerDetails details);
	
	
	public int seekerIdFind(SeekerDetails seeker);
	
	public SeekerDetails seekerObject(String password, Long phoneNumber);
	
	public SeekerDetails FindSeekerId(int seekerId);
	
	public int ForgotPassword(Long phoneNumber ,String password); 
	
	public SeekerDetails FindSeekerObjectId(long phoneNumber);
	
	
	
	
	
}
