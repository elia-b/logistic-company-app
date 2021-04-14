package application.controller;

import application.model.LogisticCompany;
import application.view.ClientApplicationView;

public class ClientController {
	private ClientApplicationView view;
	private ClientApplication app;
	int clientid;
	public ClientController(int clientid) {
		view = new ClientApplicationView(this);
		this.clientid = clientid;
		this.app = new ClientApplication(clientid,LogisticCompany.GetInstance());
	}
	
	
	
	public void display() {
		view.setVisible(true);
		
	}



	public void registerJourney() {
		// TODO Auto-generated method stub
		
	}


}
