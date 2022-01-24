package com.bloodbank.Dao;

import java.util.List;

import com.bloodbank.model.BloodStack;

public interface BloodStackDAO {
	
	
	public int updateStack(BloodStack stack);
	public double findPrice(String bloodType);
	public int updateStackReduce(String bloodType,int unit);
	public int checkOfQuantity(String bloodtype);
	public List<BloodStack> showStack();
	
	
	
	
	
	
	
	
	
	
	

}
