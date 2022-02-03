package com.bloodbank.exception;

public class ExeceptionHandle extends Exception {

	static final String INVALIDAADHARNUMBER = "Invalid aadharcard Number";

	public String donorMessage() {

		return INVALIDAADHARNUMBER;
	}

	static final String SEEKERMESSAGE = "Invalid phonenumber and password";

	public String seekerMessage() {

		return SEEKERMESSAGE;
	}

	static final String ADMINMESSAGE = "*Invalid email id and password";

	public String adminMessage() {

		return ADMINMESSAGE;

	}

	static final String FORGOTPASSWORD = "*Two password  must same";

	public String forgotPassword() {

		return FORGOTPASSWORD;

	}

	static final String PHONENUMBER = "*The phone number already register";

	public String phoneNumber() {

		return PHONENUMBER;
	}

	static final String AADHRCARDNUMBER = "*The aadharcard number already register";

	public String aadharcardNumber() {

		return AADHRCARDNUMBER;
	}

	static final String HOMECOLLECTION = "No one choice the Home";

	public String homeCollection() {

		return HOMECOLLECTION;

	}

	static final String SEEKERPHONENUMBER = "this number not register";

	public String seekerPhoneNumberFind() {

		return SEEKERPHONENUMBER;

	}

	static final String REQUESTDELETE = " can't delete the request it is approved";

	public String requestDelete() {

		return REQUESTDELETE;

	}

}
