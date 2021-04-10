package agileProjectMainJava;

import java.util.ArrayList;

public class ClientApplication extends Application{
	
	private int clientID;
	private LogisticCompany lc;
	public ClientApplication(int clientID,LogisticCompany lc) {
		this.clientID = clientID;
		this.lc=lc;
	}	
	
	public void updateName(String name) {
		 if (lc.getCic().checkNameValid(name)) {
			 lc.getDatabase().getValueFromID(clientID).setName(name);
	     } 
	}
	
	public void updateEmail(String email) {
		if (lc.getCic().checkEmailValid(email)) {
			 lc.getDatabase().getValueFromID(clientID).setEmail(email);
	    } 
	}
	
	
	public void updateAdress(String address) {
		if (lc.getCic().checkAddressValid(address)) {
			 lc.getDatabase().getValueFromID(clientID).setAddress(address);
	    } 
        
	}
	
	public void updatePassword(String password) {
		// maybe have minimum size, required sign or Capital letter
		if (true) {
			 lc.getDatabase().getValueFromID(clientID).setPassword(password);
	    }
	}
	
	public void updateContactPerson(String rp) {
		if (lc.getCic().checkReferencePersonValid(rp)) {
			 lc.getDatabase().getValueFromID(clientID).setContactPerson(rp);
	    }
	}
	public ArrayList<Integer> filterJourneysbyContent(String content) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0;i<lc.getJourneys().size();i++) {
			
			if (lc.getJourneys().getValueFromID(i).getClientid()==clientID && 
					lc.getJourneys().getValueFromID(i).getContainers().get(0).getContent().equals(content)) {
				results.add(i);
			}
		}return results;
	}
	public ArrayList<Integer> filterJourneysbyDestination(String destination) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0;i<lc.getJourneys().size();i++) {
			
			if (lc.getJourneys().getValueFromID(i).getClientid()==clientID && 
					lc.getJourneys().getValueFromID(i).getDestination().equals(destination)) {
				results.add(i);
			}
		}return results;
	}
	public ArrayList<Integer> filterJourneysbyOrigin(String origin) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		for (int i = 0;i<lc.getJourneys().size();i++) {
			
			if (lc.getJourneys().getValueFromID(i).getClientid()==clientID && 
					lc.getJourneys().getValueFromID(i).getOrigin().equals(origin)) {
				results.add(i);
			}
		}return results;
	}
	
	
	
	public void registerJourney(String origin,String destination, String content, int containers) {
		if (lc.getCic().checkJourneyDetails(origin,destination,content)) {
			ArrayList<Container> containerList = new ArrayList<Container>();
			boolean enoughContainers = true;
			for (int i = 0; i<containers; i++) {
				int Cid = lc.getContainers().getIDfromContainerLocation(origin);
				
				if (Cid != -1) {
					lc.getContainers().getValueFromID(Cid).startJourney();
					lc.getContainers().getValueFromID(Cid).setContent(content);
					
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
				//ERROR MESSAGE!
			}else {
				lc.getJourneys().registerValue(new Journey(origin,destination,this.clientID,containerList));
			}
			
			
			
		}
		
	}
}
