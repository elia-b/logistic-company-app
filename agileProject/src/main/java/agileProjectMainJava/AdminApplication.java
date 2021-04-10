package agileProjectMainJava;

import java.util.ArrayList;
import java.util.Map.Entry;

public class AdminApplication  extends Application{
	
	private LogisticCompany lc;
	
	public AdminApplication(LogisticCompany lc){
		this.lc = lc;
	}
	
	public void register_new_client(Client c1) {
        //maybe return a boolean as registerState
        if (lc.getCic().checkAllInfo(c1)) {
				c1.setPassword(generatePassword());
                lc.getDatabase().registerValue(c1);;
                c1.register();
                
            }
        else{
            //Throw an invalid client info
        }
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
	public void registerContainer(String location) {
		lc.getContainers().registerValue(new Container(location));
	}
	
	public void updateJourney(int journeyid, String newlocation) {
		if (lc.getCic().checkDestination(newlocation)) {
		ArrayList<Container> containers = lc.getJourneys().getValueFromID(journeyid).getContainers();
		for (int i = 0; i<containers.size();i++) {
			containers.get(i).setLocation(newlocation);
		}
		}else {
			//Error Message
		}
		
	}
	
	public void finishJourney(int journeyid) {
		ArrayList<Container> containers = lc.getJourneys().getValueFromID(journeyid).getContainers();
		for (int i = 0; i<containers.size();i++) {
			containers.get(i).endJourney();
			containers.get(i).setContent("empty");
			containers.get(i).setLocation(lc.getJourneys().getValueFromID(journeyid).getDestination());
		}
	}
	

}
