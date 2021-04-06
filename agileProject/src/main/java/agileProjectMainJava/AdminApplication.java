package agileProjectMainJava;

import java.util.Map.Entry;

public class AdminApplication {
	
	private LogisticCompany lc;
	
	public AdminApplication(LogisticCompany lc) {
		this.lc = lc;
	}
	
	public void register_new_client(Client c1) {
        //maybe return a boolean as registerState
        if (lc.getCic().checkAllInfo(c1)) {
                lc.getDatabase().registerClient(c1);;
                c1.register();
                
            }
        else{
            //Throw an invalid client info
        }
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
		lc.getContainers().registerContainer(new Container(location));
	}
	

}
