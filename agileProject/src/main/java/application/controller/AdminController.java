package application.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.model.AdminApplication;
import application.model.Client;
import application.model.Container;
import application.model.ContainerStatus;
import application.model.LogisticCompany;
import application.view.AddContainerInput;
import application.view.AddLocationInput;
import application.view.AdminApplicationView;
import application.view.RegisterClientInput;
import application.view.SearchNameInput;

public class AdminController {
	private AdminApplicationView view;
	private AdminApplication app;
	private ApplicationController controller;
	private RegisterClientInput input;
	private AddLocationInput locationInput;
	private AddContainerInput containerInput;
	private SearchNameInput nameInput;
	
	public AdminController(ApplicationController controller) {
		view = new AdminApplicationView(this);
		this.app = new AdminApplication(LogisticCompany.GetInstance());
		this.controller = controller;
		
	}
	
	public void display() {
		view.setVisible(true);
		
	}
	public AdminApplication getApp() {
		return app;
	}
	public AdminApplicationView getView() {
		return view;
	}
	

	public void registerClient() {
		input = new RegisterClientInput(this);
		input.setVisible(true);
	
		
		
	}

	public void searchName() {
		nameInput = new SearchNameInput(this);
		nameInput.setVisible(true);
		
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
		containerInput = new AddContainerInput(this);
		containerInput.setVisible(true);
		
		
		
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
		locationInput = new AddLocationInput(this);
		locationInput.setVisible(true);
		
		
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
