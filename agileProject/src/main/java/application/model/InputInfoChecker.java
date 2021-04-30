package application.model;

import java.util.Map.Entry;

public class InputInfoChecker {

	// reference to lc needed to access databases for checking uniqueness
	LogisticCompany lc;

	public InputInfoChecker(LogisticCompany logisticCompany) {
		this.lc = logisticCompany;
	}

	public boolean checkAllInfo(Client c) {
		return this.checkNameValid(c.getName()) && this.checkEmailValid(c.getEmail())
				&& this.checkAddressValid(c.getAddress()) && this.checkReferencePersonValid(c.getReferencePerson());
	}

	public boolean checkReferencePersonValid(String rp) {
		// check its only letters and spaces
		if (!(rp == null) && rp.matches("[a-zA-Z ]+")) {

			return true;

		}
		return false;
	}

	public boolean checkLocation(String l) {
		// check its only letters and spaces
		if (!(l == null) && l.matches("[a-zA-Z ]+")) {

			return true;

		}
		return false;
	}

	public boolean checkEmailValid(String email) {
		// Check whether a @ is there and if it is not already taken
		if (!(email == null) && email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")
				&& checkEmailTaken(email)) {
			return true;
		}
		return false;
	}

	public boolean checkAddressValid(String address) {
		// Check for three elements where the middle one is a number
		String[] parts = address.split(" ");
		if (parts.length == 3) {
			if (parts[1].matches("[0-9]+")) {
				return true;
			}
		}
		return false;
	}

	public boolean checkNameValid(String name) {
		// Only letters, spaces or numbers
		if (!(name == null) && name.matches("[a-zA-Z 0-9]+") && checkNameTaken(name)) {
			return true;
		}
		return false;

	}

	private boolean checkEmailTaken(String email) {
		// loop through database to check if email is taken
		for (Entry<Integer, Client> entry : lc.getClientDatabase().entrySet()) {
			if (entry.getValue().getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkNameTaken(String name) {
		// loop through database to check if name is taken
		for (Entry<Integer, Client> entry : lc.getClientDatabase().entrySet()) {
			if (entry.getValue().getName().equals(name)) {
				return false;
			}
		}
		return true;

	}

	public boolean checkJourneyDetails(String origin, String destination, String content) {

		if (checkOrigin(origin) && checkDestination(destination)) {
			return true;
		}
		return false;
	}

	private boolean checkOrigin(String origin) {
		// check its only letters and spaces
		if (!(origin == null) && origin.matches("[a-zA-Z ]+")) {

			return true;

		}
		return false;
	}

	public boolean checkDestination(String destination) {
		// check its only letters and spaces
		if (!(destination == null) && destination.matches("[a-zA-Z ]+")) {

			return true;

		}
		return false;
	}

	public boolean checkDate(long date) {
		// check that the date is more than 0 to not confuse it with the mock-up
		// container statuses
		if (date > 0) {
			return true;
		}
		return false;
	}

	public boolean checkPassword(String p) {
		// check that password is at least 3 digits long
		if (p.length() < 3) {
			return false;
		}
		return true;
	}

}
