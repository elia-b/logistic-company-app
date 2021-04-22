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
import application.view.FinishJourneyInput;
import application.view.GetContainerHistoryInput;
import application.view.RegisterClientInput;
import application.view.SearchEmailInput;
import application.view.SearchNameInput;
import application.view.UpdateJourneyInput;
import application.view.UpdateStatusInput;

public class AdminController {
	private AdminApplicationView view;
	private AdminApplication app;
	private ApplicationController controller;
	
	
	private RegisterClientInput input;
	private AddLocationInput locationInput;
	private AddContainerInput containerInput;
	private SearchNameInput nameInput;
	private SearchEmailInput emailInput;
	private UpdateJourneyInput updateJourneyInput;
	private FinishJourneyInput finishjourneyInput;
	private UpdateStatusInput updateStatusInput;
	private GetContainerHistoryInput getContainerHistoryInput;
	
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
		emailInput = new SearchEmailInput(this);
		emailInput.setVisible(true);
		
		
	}

	public void updateJourney() {
		updateJourneyInput = new UpdateJourneyInput(this);
		updateJourneyInput.setVisible(true);
	
		
	}

	public void registerContainer() {
		containerInput = new AddContainerInput(this);
		containerInput.setVisible(true);
		
		
		
	}

	public void finishJourney() {
		finishjourneyInput = new FinishJourneyInput(this);
		finishjourneyInput.setVisible(true);
		
	}

	public void updateStatus() {
		updateStatusInput = new UpdateStatusInput(this);
		updateStatusInput.setVisible(true);
		
	}
	
	public void addNewLocation() {
		locationInput = new AddLocationInput(this);
		locationInput.setVisible(true);
		
		
	}
	
	public void getContainerHistory() {
		getContainerHistoryInput = new GetContainerHistoryInput(this);
		getContainerHistoryInput.setVisible(true);

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
