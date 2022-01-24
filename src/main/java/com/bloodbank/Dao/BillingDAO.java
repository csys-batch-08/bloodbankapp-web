package com.bloodbank.Dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.bloodbank.model.BillingModel;

public interface BillingDAO {
		
	public int insertBilling(BillingModel bill );	
	public List<BillingModel> biilingShow( BillingModel bill);
	public List<BillingModel> biilingShowAdmin();
	public List<BillingModel> biilingShowAdminDate(LocalDate date);
	

}
