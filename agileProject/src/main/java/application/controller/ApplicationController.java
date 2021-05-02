package application.controller;

public class ApplicationController {

	public static void main(String[] args) {
		// create the ApplicationController object
		ApplicationController app = new ApplicationController();
		app.login();
	}
	// login either as client or logistic company
	public void login() {
		ApplicationLogIn app = new ApplicationLogIn(this);
		app.display();
	}
	// login as a client and display the client application window
	public void clientapplication(int clientID, String username) {
		ClientController clientcontroller = new ClientController(clientID, this, username);
		clientcontroller.display();
	}
	// login as a logistic company and display the administrator application window
	public void adminapplication() {
		AdminController controller = new AdminController(this);
		controller.display();

	}

}
