package application.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.model.ClientApplication;
import application.model.ContainerStatus;
import application.model.LogisticCompany;
import application.view.ClientApplicationView;

public class ClientController {
	private ClientApplicationView view;
	private ClientApplication app;
	private ApplicationController controller;
	int clientid;

	public ClientController(int clientid, ApplicationController controller) {
		view = new ClientApplicationView(this);
		this.clientid = clientid;
		this.app = new ClientApplication(clientid,LogisticCompany.GetInstance());
		this.controller = controller;
	}
	
	
	
	public void display() {
		view.setVisible(true);
		
	}



	public void update_address() {
		String address = JOptionPane.showInputDialog("Please insert the New Address:");
		String message = app.updateAdress(address);
		if (message.equals("Successful Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
	}



    public void update_password() {
		String password = JOptionPane.showInputDialog("Please insert the New Password:");
		String message = app.updatePassword(password);
		if (message.equals("Successful Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
    }



    public void update_email() {
		String email = JOptionPane.showInputDialog("Please insert the New Email:");
		String message = app.updateEmail(email);
		if (message.equals("Successful Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
    }



    public void update_name() {
		String name = JOptionPane.showInputDialog("Please insert the New Name:");
		String message = app.updateName(name);
		if (message.equals("Successful Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
    }



    public void update_contact_person() {
		String cp = JOptionPane.showInputDialog("Please insert the New Contact Person:");
		String message = app.updateContactPerson(cp);
		if (message.equals("Successful Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
    }



    public void filter_journey_by_content() {
		String content = JOptionPane.showInputDialog("Please insert the Content:");
		ArrayList<Integer> arraylist = app.filterJourneysbyContent(content);
		if (arraylist.size() > 0){
			String message = "The Journeys with " + content + " are:\n";
			for (int i = 0; i < arraylist.size(); i++){
				message = message + arraylist.get(i) + " ";
			}
			view.showSuccess(message);
		} else {
			view.showSuccess("No Journey found");
		}
    }



    public void filter_journey_by_destination() {
		String destination = JOptionPane.showInputDialog("Please insert the Destination:");
		ArrayList<Integer> arraylist = app.filterJourneysbyDestination(destination);
		if (arraylist.size() > 0){
			String message = "The Journeys with destination " + destination + " are:\n";
			for (int i = 0; i < arraylist.size(); i++){
				message = message + arraylist.get(i) + " ";
			}
			view.showSuccess(message);
		} else {
			view.showSuccess("No Journey found");
		}
    }



    public void filter_journey_by_origin() {
		String origin = JOptionPane.showInputDialog("Please insert the Origin:");
		ArrayList<Integer> arraylist = app.filterJourneysbyOrigin(origin);
		if (arraylist.size() > 0){
			String message = "The Journeys with origin " + origin + " are:\n";
			for (int i = 0; i < arraylist.size(); i++){
				message = message + arraylist.get(i) + " ";
			}
			view.showSuccess(message);
		} else {
			view.showSuccess("No Journey found");
		}
    }



    public void register_journey() {
		String origin = JOptionPane.showInputDialog("Please insert the Origin:");
		String destination = JOptionPane.showInputDialog("Please insert the Destination:");
		String content = JOptionPane.showInputDialog("Please insert the Content:");
		String containers = JOptionPane.showInputDialog("Please insert the Number of Contatiners:");
		int icont = Integer.valueOf(containers);
		String message = app.registerJourney(origin, destination, content, icont);
		if (message.equals("Successful Registration")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
    }



    public void get_latest_status() {
		String jID = JOptionPane.showInputDialog("Please insert the JourneyID:");
		int ijid = Integer.valueOf(jID);
		ArrayList<ContainerStatus> arraylist = app.getLatestStatus(ijid);
		if (arraylist.size() > 0){
			String message = "";
			for (int i = 0; i < arraylist.size(); i++){
				message = message + "The Container "+ i + " has temp = " + arraylist.get(i).getTemperature() +  " at time " + arraylist.get(i).getDate() + "\n";
			}
			view.showSuccess(message);
		} else {
			view.showSuccess("No Container found");
		}
    }



    public void get_closes_status() {
		String jID = JOptionPane.showInputDialog("Please insert the JourneyID:");
		int ijid = Integer.valueOf(jID);
		String date = JOptionPane.showInputDialog("Please insert the Date:");
		ArrayList<ContainerStatus> arraylist = app.getclosestStatus(ijid, date);
		if (arraylist.size() > 0){
			String message = "";
			for (int i = 0; i < arraylist.size(); i++){
				message = message + "The Container "+ i + " has temp = " + arraylist.get(i).getTemperature() +  " at time " + arraylist.get(i).getDate() + "\n";
			}
			view.showSuccess(message);
		} else {
			view.showSuccess("No Container found");
		}
    }

	public void logOut() {
		view.setVisible(false);
		controller.login();
	}


}
