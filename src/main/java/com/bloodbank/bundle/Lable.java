package com.bloodbank.bundle;

import java.util.ListResourceBundle;

public class Lable extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {

		return contents;
	}

	static final Object[][] contents = { { "nav.donor", "Donor" }, { "nav.Forgot password", "Forgot password" } };

}
