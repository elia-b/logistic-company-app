package agileProjectMainJava;

import java.util.ArrayList;
import java.util.Set;

public class ClientApplication {
	
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
