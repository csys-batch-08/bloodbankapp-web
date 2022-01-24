package com.bloodbank.exception;

public class ExeceptionHandle extends Exception {

	public String DonorMessage() {

		return "*Invalid aadharcard Number";
	}

	public String SeekerMessage() {

		return "*Invalid PhoneNumber and password";
	}

	public String AdminMessage() {

		return "*Invalid Email Id and password";

	}

	public String ForgotPassword() {

		return "*Two password  must same";

	}

	public String PhoneNumber() {

		return "*Phone number already register";
	}

	public String AadharcardNumber() {

		return "*Aadharcard Number already register";
	}

	public String HomeCollection() {

		return "No one choice the Home";

	}

	public String SeekerPhoneNumberFind() {

		return " this number not register";

	}
	
	public String RequestDelete() {

		return " can't delete the request it is approved";

	}
	
	
}
