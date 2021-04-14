package application.controller;

import java.util.ArrayList;
import java.util.Map.Entry;

import application.model.Client;
import application.model.Container;
import application.model.ContainerStatus;
import application.model.LogisticCompany;
import application.view.AdminApplicationView;

public class AdminApplication {
	
	private LogisticCompany lc;
	
	
	public AdminApplication(LogisticCompany lc){
		
		this.lc = lc;
	}
	
	public String register_new_client(Client c1) {
        //maybe return a boolean as registerState
		
        if (lc.getCic().checkAllInfo(c1)) {
				c1.setPassword(generatePassword());
                lc.getDatabase().registerValue(c1);;
                c1.register();
                return "Registration Successful";
            }
        else{
            return "Invalid Info";
        }
    }
	public void getClientReport() {
		System.out.print(lc.getReport().getClientReport().getClientapp());
	}
	
	private String generatePassword() {
		//for now it does not randomly generate the password, 
		//but at some point it would be nice
		return "12345Password";
	}

	public int searchEmail(String email) {
		for (Entry<Integer, Client> entry : lc.getDatabase().entrySet()) {
			if (entry.getValue().getEmail().equals(email)) {
				return entry.getKey();
			}
			
		}return -1;
	}
	public int searchName(String name) {
		for (Entry<Integer, Client> entry : lc.getDatabase().entrySet()) {
			if (entry.getValue().getName().equals(name)) {
				return entry.getKey() ;
			}
		}return -1;
	}
	
	//Maybe check location
	public String registerContainer(String location) {
		lc.getContainers().registerValue(new Container(location));
		return "Container registered";
		
	}
	//Check if id exists
	public String updateJourney(int journeyid, String newlocation) {
		if (lc.getCic().checkDestination(newlocation)) {
		ArrayList<Container> containers = lc.getJourneys().getValueFromID(journeyid).getContainers();
		for (int i = 0; i<containers.size();i++) {
			containers.get(i).setLocation(newlocation);
		}
		return "Successful Journey Update";
		}else {
			return "Unsuccessful Journey Update";
		}
		
	}
	//Check if id exists
	public String finishJourney(int journeyid) {
		ArrayList<Container> containers = lc.getJourneys().getValueFromID(journeyid).getContainers();
		for (int i = 0; i<containers.size();i++) {
			containers.get(i).endJourney();
			containers.get(i).setContent("empty");
			containers.get(i).setLocation(lc.getJourneys().getValueFromID(journeyid).getDestination());
		}
		return "Journey finished";
	}
	
	public void updateStatus(int containerid,float humidity,float temp,float press,String date) {
		if (lc.getCic().checkDate(date)) {
			lc.getContainers().getValueFromID(containerid).getStatus().add(new ContainerStatus(date,temp,press,humidity));
			
			
		}else {
			//Error Message
		}
	}

	

	
}
