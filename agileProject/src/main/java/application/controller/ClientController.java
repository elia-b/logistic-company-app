package application.controller;

import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

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
	// line 43 to line 55 getters for view, App and ClientId
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
// constructor for initialise the ClientController 
	public ClientController(int clientid, ApplicationController controller, String username) {
		// set the clientApplicationView for current client
		view = new ClientApplicationView(this, username);
		// initialise the clientID
		this.clientid = clientid;
		// initialise the App
		this.app = new ClientApplication(clientid, LogisticCompany.GetInstance());
		// initialise the controller to clientController
		this.controller = controller;
	}

	public void display() {
		// set window to the centre on the screen.
		view.setLocationRelativeTo(null);
		// display the window
		view.setVisible(true);

	}
	// line 76 to 100 : update address, password, email, name and contact_person
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
	// line 106 to line 122 filter journey by content, destination or origin
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
	// register journey
	public void register_journey() {
		registerJourneyInput = new RegisterJourneyInput(this);
		registerJourneyInput.setLocationRelativeTo(null);
		registerJourneyInput.setVisible(true);
	}
	// get the latest status
	public void get_latest_status() {
		getLatestStatus = new GetLatestStatusInput(this);
		getLatestStatus.setLocationRelativeTo(null);
		getLatestStatus.setVisible(true);

	}
	// 
	public void get_closes_status() {
		getClosestStatus = new GetClosestStatusInput(this);
		getClosestStatus.setLocationRelativeTo(null);
		getClosestStatus.setVisible(true);

	}

	public void logOut() {
		// close the window
		view.setVisible(false);
		// back to login dialogue
		controller.login();
	}

}
