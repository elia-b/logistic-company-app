package application.controller;

import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import application.model.ClientApplication;
import application.model.ContainerStatus;
import application.model.Journey;
import application.model.LogisticCompany;
import application.view.ClientApplicationView;
import application.view.client_inputs.FilterJourneyContentInput;
import application.view.client_inputs.FilterJourneyDestinationInput;
import application.view.client_inputs.FilterJourneyOriginInput;
import application.view.client_inputs.GetClosestStatusInput;
import application.view.client_inputs.GetLatestStatusInput;
import application.view.client_inputs.RegisterJourneyInput;
import application.view.client_inputs.UpdateAdressInput;
import application.view.client_inputs.UpdateContactPersonInput;
import application.view.client_inputs.UpdateEmailInput;
import application.view.client_inputs.UpdateNameInput;
import application.view.client_inputs.UpdatePasswordInput;

public class ClientController {
	private ClientApplicationView view;
	private ClientApplication app;
	private ApplicationController controller;
	private RegisterJourneyInput registerJourneyInput;
	private UpdateEmailInput updateEmail;
	private UpdateAdressInput updateAdress;
	private UpdateNameInput updateName;
	private UpdateContactPersonInput updateContactPerson;
	private UpdatePasswordInput passwordInput;
	private FilterJourneyContentInput filterJourneyContent;
	private FilterJourneyDestinationInput filterJourneyDestination;
	private FilterJourneyOriginInput filterJourneyOrigin;
	private GetLatestStatusInput getLatestStatus;
	private GetClosestStatusInput getClosestStatus;

	public ClientApplicationView getView() {
		return view;
	}

	public ClientApplication getApp() {
		return app;
	}

	private int clientid;

	public int getClientid() {
		return clientid;
	}

	public ClientController(int clientid, ApplicationController controller, String username) {
		view = new ClientApplicationView(this, username);
		this.clientid = clientid;
		this.app = new ClientApplication(clientid, LogisticCompany.GetInstance());
		this.controller = controller;
	}

	public void display() {
		view.setLocationRelativeTo(null);
		view.setVisible(true);

	}

	public void update_address() {
		updateAdress = new UpdateAdressInput(this);
		updateAdress.setLocationRelativeTo(null);
		updateAdress.setVisible(true);
	}

	public void update_password() {
		passwordInput = new UpdatePasswordInput(this);
		passwordInput.setLocationRelativeTo(null);
		passwordInput.setVisible(true);
	}

	public void update_email() {
		updateEmail = new UpdateEmailInput(this);
		updateEmail.setLocationRelativeTo(null);
		updateEmail.setVisible(true);
	}

	public void update_name() {
		updateName = new UpdateNameInput(this);
		updateName.setLocationRelativeTo(null);
		updateName.setVisible(true);
	}

	public void update_contact_person() {
		updateContactPerson = new UpdateContactPersonInput(this);
		updateContactPerson.setLocationRelativeTo(null);
		updateContactPerson.setVisible(true);
	}

	public void filter_journey_by_content() {
		filterJourneyContent = new FilterJourneyContentInput(this);
		filterJourneyContent.setLocationRelativeTo(null);
		filterJourneyContent.setVisible(true);

	}

	public void filter_journey_by_destination() {
		filterJourneyDestination = new FilterJourneyDestinationInput(this);
		filterJourneyDestination.setLocationRelativeTo(null);
		filterJourneyDestination.setVisible(true);
	}

	public void filter_journey_by_origin() {
		filterJourneyOrigin = new FilterJourneyOriginInput(this);
		filterJourneyOrigin.setLocationRelativeTo(null);
		filterJourneyOrigin.setVisible(true);
	}

	public void register_journey() {
		registerJourneyInput = new RegisterJourneyInput(this);
		registerJourneyInput.setLocationRelativeTo(null);
		registerJourneyInput.setVisible(true);
	}

<<<<<<< HEAD
	public void get_latest_status() {
		getLatestStatus = new GetLatestStatusInput(this);
		getLatestStatus.setLocationRelativeTo(null);
=======
    public void filter_journey_by_destination() {
    	filterJourneyDestination = new FilterJourneyDestinationInput(this);
    	filterJourneyDestination.setVisible(true);
    }



    public void filter_journey_by_origin() {
    	filterJourneyOrigin = new FilterJourneyOriginInput(this);
    	filterJourneyOrigin.setVisible(true);
    }
 


    public void register_journey() {
    	registerJourneyInput = new RegisterJourneyInput(this);
    	registerJourneyInput.setVisible(true);
    }



    public void get_latest_status() {
    	getLatestStatus = new GetLatestStatusInput(this);
>>>>>>> refs/remotes/origin/date-and-location
		getLatestStatus.setVisible(true);

	}

	public void get_closes_status() {
		getClosestStatus = new GetClosestStatusInput(this);
		getClosestStatus.setLocationRelativeTo(null);
		getClosestStatus.setVisible(true);

	}

	public void logOut() {
		view.setVisible(false);
		controller.login();
	}

}
