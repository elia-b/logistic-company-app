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
		if ((username.equals(lc.getEmail()) || username.equals(lc.getUsername())) && password.equals(lc.getPassword())) {
			application.adminapplication();
			view.setVisible(false);
			
			
		} else {
			int clientID = lc.getDatabase().getIDfromClientName(username);
			if (clientID != -1){
				if(lc.getDatabase().getValueFromID(clientID).getPassword().equals(password)){
					application.clientapplication(clientID);
					view.setVisible(false);
					
					
					lc.getReport().getClientReport().increaseClientapp();
					
				} else {
					view.showError("wrong password");
				}
				 
			} else {
				view.showError("wrong username");
			}
		}
	}
	
	public void display() {
		view.setVisible(true);
	}

}