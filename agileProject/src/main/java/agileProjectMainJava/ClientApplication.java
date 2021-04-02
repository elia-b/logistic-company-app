package agileProjectMainJava;

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

	public void registerJorney(Journey j) {
		if (lc.getCic().checkJourneyDetails(j)) {
			lc.getJourneys().registerJourney(j,clientID);
			j.register();
		}
		
	}
}
