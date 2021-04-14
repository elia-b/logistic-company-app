package application.controller;

import application.model.LogisticCompany;

public class ApplicationController {
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}
	
	public void login() {
		ApplicationLogIn app = new ApplicationLogIn(this);
		app.display();
	}

	public void clientapplication(int clientID) {
		ClientController clientcontroller = new ClientController(clientID);
		clientcontroller.display();
	}

	public void adminapplication() {
		AdminController controller = new AdminController(this);
		controller.display();
		
	}



}
