package application.controller;

import application.model.LogisticCompany;
import application.view.LoginView;

public class ApplicationLogIn {

	private LogisticCompany lc = LogisticCompany.GetInstance();
	private LoginView view;
	private ApplicationController application;

	public ApplicationLogIn(ApplicationController application) {
		this.application = application;
		this.view = new LoginView(this);
	}

	public void logIn(String username, String password) {
		if (username.equals(lc.getName()) && password.equals(lc.getPassword())) {
			application.adminapplication();
			view.setVisible(false);

		} else {
			int clientID = lc.getClientDatabase().getIDfromClientName(username);
			if (clientID != -1) {
				if (lc.getClientDatabase().getValueFromID(clientID).getPassword().equals(password)) {
					application.clientapplication(clientID, username);
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