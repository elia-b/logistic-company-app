package application.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.model.AdminApplication;
import application.model.Client;
import application.model.Container;
import application.model.ContainerStatus;
import application.model.LogisticCompany;
import application.view.AdminApplicationView;

public class AdminController {
	private AdminApplicationView view;
	private AdminApplication app;
	private ApplicationController controller;
	
	public AdminController(ApplicationController controller) {
		view = new AdminApplicationView(this);
		this.app = new AdminApplication(LogisticCompany.GetInstance());
		this.controller = controller;
		
	}
	
	public void display() {
		view.setVisible(true);
		
	}

	

	public void registerClient() {
		String Name = JOptionPane.showInputDialog("Please insert the ClientName:");
		String email = JOptionPane.showInputDialog("Please insert the email:");
		String address = JOptionPane.showInputDialog("Please insert the address:");
		String contact = JOptionPane.showInputDialog("Please insert the contact:");
		Client client = new Client(Name,email,address,contact);
		
		String message = app.register_new_client(client);
		if (message.equals("Registration Successful")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
		
	}

	public void searchName() {
		String Name = JOptionPane.showInputDialog("Please insert the ClientName:");
		int message = app.searchName(Name);
		if (message>-1) {
			view.showSuccess("Client's ID is: " + message);
		}else {
			view.showError("No Client with that Name");
		}
	}

	public void searchEmail() {
		String Email = JOptionPane.showInputDialog("Please insert the Email:");
		int message = app.searchEmail(Email);
		if (message>-1) {
			view.showSuccess("Client's ID is: " + message);
		}else {
			view.showError("No Client with that Email");
		}
		
	}

	public void updateJourney() {
		String id = JOptionPane.showInputDialog("Please insert the Journey ID: ");
		int idi = Integer.valueOf(id);
		String newloc = JOptionPane.showInputDialog("Please insert the new Location: ");
		String message = app.updateJourney(idi, newloc);
		if (message.equals("Successful Journey Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
		
	}

	public void registerContainer() {
		String location = JOptionPane.showInputDialog("Please insert the Location: ");
		Container C = new Container(location);
		String message = app.registerContainer(C);
		if (message.equals("Container registered")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
		
	}

	public void finishJourney() {
		String id = JOptionPane.showInputDialog("Please insert the Journey ID: ");
		int idi = Integer.valueOf(id);
		String message = app.finishJourney(idi);
		if (message.equals("Journey finished")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
		
	}

	public void updateStatus() {
		String id = JOptionPane.showInputDialog("Please insert the Container ID: ");
		int idi = Integer.valueOf(id);
		String hum = JOptionPane.showInputDialog("Please insert the Humidity level: ");
		float fhum = Float.valueOf(hum);
		String temp = JOptionPane.showInputDialog("Please insert the Temperature: ");
		float ftemp = Float.valueOf(temp);
		String press = JOptionPane.showInputDialog("Please insert the Pressure: ");
		float fpress = Float.valueOf(press);
		String date = JOptionPane.showInputDialog("Please insert the Date: ");
		String message = app.updateStatus(idi, fhum, ftemp, fpress, date);
		if (message.equals("Successful Update")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
		
	}
	
	public void addNewLocation() {
		String location = JOptionPane.showInputDialog("Please insert new Location: ");
		String message = app.addLocation(location);
		if (message.equals("Location Added")) {
			view.showSuccess(message);
		}else {
			view.showError(message);
		}
		
	}
	
	public void getContainerHistory() {
		String id = JOptionPane.showInputDialog("Please insert the Container ID: ");
		int idi = Integer.valueOf(id);
		
		String message = "";
		try {
			ArrayList<ContainerStatus> arraylist = (ArrayList<ContainerStatus>) app.searchContainerHistory(idi);
			for (int i = 0; i < arraylist.size(); i++){
				message = message + "ContainerStatus "+ i + " date:" + arraylist.get(i).getDate();
			}
			view.showSuccess(message);
		}
		catch (Exception e) {
			view.showError("ERROR 404");
		}

	}
	
	public void getContainerHistoryfromJourney() {
		String id = JOptionPane.showInputDialog("Please insert the Container ID: ");
		int idi = Integer.valueOf(id);
		String id2 = JOptionPane.showInputDialog("Please insert the Journey ID: ");
		int idi2 = Integer.valueOf(id);
		String message = "";
		try {
			ArrayList<ContainerStatus> arraylist = (ArrayList<ContainerStatus>) app.getStatusesFromContainerHistory(idi, idi2);
			for (int i = 0; i < arraylist.size(); i++){
				message = message + "ContainerStatus "+ i + " date:" + arraylist.get(i).getDate();
			}
			view.showSuccess(message);
		}
		catch (Exception e) {
			view.showError("ERROR 404");
		}

	}

	public void getJourneysOfContainer() {
		String id = JOptionPane.showInputDialog("Please insert the Container ID: ");
		int idi = Integer.valueOf(id);
		
		String message = "";
		try {
			ArrayList<Integer> arraylist = (ArrayList<Integer>) app.getJourneyIDsfromContainerHistory(idi);
			for (int i = 0; i < arraylist.size(); i++){
				message = message + "Journey  "+  arraylist.get(i);
			}
			view.showSuccess(message);
		}
		catch (Exception e) {
			view.showError("ERROR 404");
		}

	}
	
	
	public void logOut() {
		view.setVisible(false);
		controller.login();
	}
}
