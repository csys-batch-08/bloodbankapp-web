package com.bloodbank.bundle;

import java.util.ListResourceBundle;

public class Lable extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {

		return contents;
	}

	static final Object[][] contents = { { "nav.donor", "Donor" }, { "nav.Forgot password", "Forgot password" },
			{ "nav.AdminLogin", "AdminLogin" }, { "nav.AADHARCARD", "AADHARCARD" }, { "nav.ADDRESS", "ADDRESS" },
			{ "nav.AdminShowBooking", "AdminShowBooking" }, { "nav.Back", "Back" }, { "nav.AdminWork", "AdminWork" },
			{ "nav.Booking", "Booking" }, { "nav.Seeker", "Seeker" }, { "nav.Logout", "Logout" },
			{ "nav.BOOKING", "BOOKING" }, { "nav.center", "center" }, { "nav.Home", "Home" }

	};
}
