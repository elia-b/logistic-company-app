package application.controller;

public class ApplicationController {

	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}

	public void login() {
		ApplicationLogIn app = new ApplicationLogIn(this);
		app.display();
	}

	public void clientapplication(int clientID, String username) {
		ClientController clientcontroller = new ClientController(clientID, this, username);
		clientcontroller.display();
	}

	public void adminapplication() {
		AdminController controller = new AdminController(this);
		controller.display();

	}

}
