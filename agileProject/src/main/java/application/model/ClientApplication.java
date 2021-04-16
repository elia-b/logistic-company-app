package application.model;

import java.util.ArrayList;

public class ClientApplication{
	
	
	private int clientID;
	private LogisticCompany lc;
	public ClientApplication(int clientID,LogisticCompany lc) {
		this.clientID = clientID;
		this.lc=lc;
		
	}	
	
	public String updateName(String name) {
		 lc.getReport().getClientReport().increaseUpdateName();
		 if (lc.getCic().checkNameValid(name)) {
			 lc.getDatabase().getValueFromID(clientID).setName(name);
			 return "Successful Update";
	     } else {
			return "Unsuccessful Update";
		 }
	}
	
	public String updateEmail(String email) {
		lc.getReport().getClientReport().increaseUpdateEmail();
		if (lc.getCic().checkEmailValid(email)) {
			 lc.getDatabase().getValueFromID(clientID).setEmail(email);
			
			return "Successful Update";
		} else {
			return "Unsuccessful Update";
		} 
	}
	
	
	public String updateAdress(String address) {
		lc.getReport().getClientReport().increaseUpdateAdress();
		if (lc.getCic().checkAddressValid(address)) {
			 lc.getDatabase().getValueFromID(clientID).setAddress(address);
			 return "Successful Update";
	    } else {
			return "Unsuccessful Update";
		}
        
	}
	
	
	public String updatePassword(String password) {
		lc.getReport().getClientReport().increaseUpdatePassword();
		// maybe have minimum size, required sign or Capital letter
		if (lc.getCic().checkPassword(password)) {
			 lc.getDatabase().getValueFromID(clientID).setPassword(password);
			return "Successful Update";
		} else {
			return "Unsuccessful Update";
		}
	}
 	
	public String updateContactPerson(String rp) {
		lc.getReport().getClientReport().increaseUpdateContactPerson();
		if (lc.getCic().checkReferencePersonValid(rp)) {
			 lc.getDatabase().getValueFromID(clientID).setContactPerson(rp);
			 
			return "Successful Update";
		} else {
			return "Unsuccessful Update";
		}
	}

	public ArrayList<Integer> filterJourneysbyContent(String content) {
		lc.getReport().getClientReport().increaseFilterJourneysbyContent();
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0;i<lc.getJourneys().size();i++) {
			
			if (lc.getJourneys().getValueFromID(i).getClientid()==clientID && 
					lc.getJourneys().getValueFromID(i).getContent().equals(content)) {
				results.add(i);
			}
		}return results;
	}
	public ArrayList<Integer> filterJourneysbyDestination(String destination) {
		lc.getReport().getClientReport().increaseFilterJourneysbyDestination();
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0;i<lc.getJourneys().size();i++) {
			
			if (lc.getJourneys().getValueFromID(i).getClientid()==clientID && 
					lc.getJourneys().getValueFromID(i).getDestination().equals(destination)) {
				results.add(i);
			}
		}return results;
	}
	public ArrayList<Integer> filterJourneysbyOrigin(String origin) {
		lc.getReport().getClientReport().increaseFilterJourneysbyOrigin();
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0;i<lc.getJourneys().size();i++) {
			
			if (lc.getJourneys().getValueFromID(i).getClientid()==clientID && 
					lc.getJourneys().getValueFromID(i).getOrigin().equals(origin)) {
				results.add(i);
			}
		}return results;
	}
	
	
	
	public String registerJourney(Journey j) {
		lc.getReport().getClientReport().increaseRegisterjourney();
		if (lc.getCic().checkJourneyDetails(j.getOrigin(),j.getDestination(),j.getContent())) {
			ArrayList<Container> containerList = new ArrayList<Container>();
			boolean enoughContainers = true;
			for (int i = 0; i< j.getNOfContainers(); i++) {
				int Cid = lc.getContainers().getIDfromContainerLocation(j.getOrigin());
				
				if (Cid != -1) {
					lc.getContainers().getValueFromID(Cid).startJourney();
					lc.getContainers().getValueFromID(Cid).setContent(j.getContent());
					
					containerList.add(lc.getContainers().getValueFromID(Cid));
					
				}else {
					enoughContainers = false;
				}
				
			}
			if (!enoughContainers) {
				for (int i = 0; i<containerList.size(); i++) {
					containerList.get(i).endJourney();
					containerList.get(i).setContent("empty");
				
				}
				return "Not enough containers";
			}else {
				j.setContainers(containerList);
				j.setClientID(this.clientID);
				lc.getJourneys().registerValue(j);
				for (Container c : containerList) {
					lc.getContainersHistory().getValueFromID(c.getID()).getContainerJourneys().add(new ContainerJourneyHistory(j.getID()));
				}
				return "Successful Registration";
			}
			
			
			
		}
		return "Invalid Info";
		
	}
	
	
	public ArrayList<ContainerStatus> getLatestStatus(int journeyid) {
		ArrayList<ContainerStatus> results = new ArrayList<ContainerStatus>();
		if (lc.getJourneys().containsKey(journeyid)) {
			lc.getReport().getClientReport().increaseGetLatestStatus();
			
			if (lc.getJourneys().getValueFromID(journeyid).getClientid()==clientID) {
				for (Container c : lc.getJourneys().getValueFromID(journeyid).getContainers()) {
					if (c.getStatus().size()>0) {
						results.add(c.getStatus().get(c.getStatus().size()-1));
					}
					
				}
			}
			return results;
		}return results;
		
	}
	
	
	public ArrayList<ContainerStatus> getclosestStatus(int journeyid,String date){
		lc.getReport().getClientReport().increaseGetClosestStatus();
		ArrayList<ContainerStatus> results = new ArrayList<ContainerStatus>();
		if (lc.getJourneys().containsKey(journeyid)&&lc.getCic().checkDate(date)) {
			int count = 0;
			int index = 0;
			if (lc.getJourneys().getValueFromID(journeyid).getClientid()==clientID) {
				
				
				
				
				for (Container c : lc.getJourneys().getValueFromID(journeyid).getContainers()) {
					int diff = c.getStatus().get(0).getDifference(date);
					count = 0;
					index = 0;
					for (ContainerStatus cs : c.getStatus()) {
						
						if (diff>cs.getDifference(date)) {
							diff = cs.getDifference(date);
							index = count;
						}
						count++;
					}
					results.add(c.getStatus().get(index));
				}
			}
			return results;
		}return results;
		
	}

	

	
	
	
}
