package application.controller;


import application.model.AdminApplication;
import application.model.LogisticCompany;

import application.view.AdminApplicationView;
import application.view.admin_inputs.AddContainerInput;
import application.view.admin_inputs.AddLocationInput;
import application.view.admin_inputs.ContainerHistoryFromJourneyInput;
import application.view.admin_inputs.FinishJourneyInput;
import application.view.admin_inputs.GetContainerHistoryInput;
import application.view.admin_inputs.JourneysOfContainerInput;
import application.view.admin_inputs.RegisterClientInput;
import application.view.admin_inputs.SearchEmailInput;
import application.view.admin_inputs.SearchNameInput;
import application.view.admin_inputs.UpdateJourneyInput;
import application.view.admin_inputs.UpdateStatusInput;

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
	private ContainerHistoryFromJourneyInput containerHistoryFromJourneyInput;
	private JourneysOfContainerInput journeysOfContainerInput;
	
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
		containerHistoryFromJourneyInput = new ContainerHistoryFromJourneyInput(this);
		containerHistoryFromJourneyInput.setVisible(true);
	}

	public void getJourneysOfContainer() {
		journeysOfContainerInput = new JourneysOfContainerInput(this);
		journeysOfContainerInput.setVisible(true);

	}
	
	
	public void logOut() {
		view.setVisible(false);
		controller.login();
	}
}
