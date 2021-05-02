package application.controller;

import application.model.LogisticCompany;
import application.view.LoginView;

public class ApplicationLogIn {
	// implement the singleton pattern
	private LogisticCompany lc = LogisticCompany.GetInstance();
	private LoginView view;
	private ApplicationController application;
	// constructor for initialise the application
	public ApplicationLogIn(ApplicationController application) {
		this.application = application;
		this.view = new LoginView(this);
	}

	// input the user name and password
	public void logIn(String username, String password) {
		// if login as logisticCompany
		if (username.equals(lc.getName()) && password.equals(lc.getPassword())) {
			// start the adminApplication
			application.adminapplication();
			// close the window
			view.setVisible(false);

		} else {
			// login as a client 
			// get the clientID from ClientDatabase via the input userName 
			int clientID = lc.getClientDatabase().getIDfromClientName(username);
			// if exist such ID
			if (clientID != -1) {
				// if the input password equal to the password saved in the database
				if (lc.getClientDatabase().getValueFromID(clientID).getPassword().equals(password)) {
					// initialise the clientApplication for the client
					application.clientapplication(clientID, username);
					// close the window
					view.setVisible(false);

				} else {
					view.showError("Wrong username and/or password. Please try again.");
				}

			} else {
				view.showError("Wrong username and/or password. Please try again.");
			}
		}
	}

	public void display() {
		view.setVisible(true);
	}

}