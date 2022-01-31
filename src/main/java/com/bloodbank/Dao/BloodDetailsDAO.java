package com.bloodbank.Dao;

import java.util.List;

import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.Donor;

public interface BloodDetailsDAO {
	
	
	
	public int insertBloodDetails(BloodDetailsModel details);
	public List<BloodDetailsModel > showBloodDetails(Donor donor );
	
	
	
	
	

}
