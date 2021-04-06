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
			 lc.getDatabase().getClientFromID(clientID).setName(name);
	     } 
	}
	
	public void updateEmail(String email) {
		if (lc.getCic().checkEmailValid(email)) {
			 lc.getDatabase().getClientFromID(clientID).setEmail(email);
	    } 
	}
	
	
	public void updateAdress(String address) {
		if (lc.getCic().checkAddressValid(address)) {
			 lc.getDatabase().getClientFromID(clientID).setAddress(address);
	    } 
        
	}
	
	public void updatePassword(String password) {
		// maybe have minimum size, required sign or Capital letter
		if (true) {
			 lc.getDatabase().getClientFromID(clientID).setPassword(password);
	    }
	}
	
	public void updateContactPerson(String rp) {
		if (lc.getCic().checkReferencePersonValid(rp)) {
			 lc.getDatabase().getClientFromID(clientID).setContactPerson(rp);
	    }
	}
	
	public void registerJourney(String origin,String destination, String content, int containers) {
		if (lc.getCic().checkJourneyDetails(origin,destination,content)) {
			ArrayList<Container> containerList = new ArrayList<Container>();
			boolean enoughContainers = true;
			for (int i = 0; i<containers; i++) {
				int Cid = lc.getContainers().getIDfromContainerLocation(origin);
				
				if (Cid != -1) {
					lc.getContainers().getContainerFromID(Cid).startJourney();
					lc.getContainers().getContainerFromID(Cid).setContent(content);
					
					containerList.add(lc.getContainers().getContainerFromID(Cid));
					
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
				lc.getJourneys().registerJourney(new Journey(origin,destination,this.clientID,containerList));
			}
			
			
			
		}
		
	}
}
