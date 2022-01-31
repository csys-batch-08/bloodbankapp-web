package com.bloodbank.Dao;

import com.bloodbank.model.AdminModel;

public interface AdminDAO {
	
	
	public  AdminModel  verificationAdmin(AdminModel aModel);	
	public AdminModel updateWallet();	
	public int seekerPayment(double totalPrice) ;
	public Double checkWallet();
	
	
	
	
	
	

}
