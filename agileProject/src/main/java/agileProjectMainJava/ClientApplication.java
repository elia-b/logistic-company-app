package agileProjectMainJava;

import java.util.Set;

public class ClientApplication extends Application{
	
	private Client client;
	private LogisticCompany lc;
	public ClientApplication(Client user,LogisticCompany lc) {
		super(user);
		this.client = user;
		this.lc=lc;
	}
	
	//ONLY FOR TESTING:
	public void setIDD(int id) {
		for (Client c : lc.getClients()) {
    		if (client.getName().equals(c.getName())) {
    			c.setId(id);
    		}
    	}
	}
	
	
	
	public void updateName(String name) {
		 if (!(name == null) && name.matches("[a-zA-Z 0-9]+") && checkNameTaken(name)) {
	        	for (Client c : lc.getClients()) {
	        		if (client.getName().equals(c.getName())) {
	        			c.setName(name);
	        		}
	        	}
	        }
	        
	}
	//Maybe create a seperate class to check validity of info for admin and client class
	
	private boolean checkNameTaken(String name) {
		for (Client c : lc.getClients()) {
			if (c.getName().equals(name)) {
				return false;
			}
		}return true;
    	
    }
	
	public void updateEmail(String email) {
		if (!(email == null) && email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") && checkEmailTaken(email)) {
			for (Client c : lc.getClients()) {
        		if (client.getName().equals(c.getName())) {
        			c.setEmail(email);
        		}
        	}
	    }
	        
	}
	
	private boolean checkEmailTaken(String email) {
			for (Client c : lc.getClients()) {
				if (c.getEmail().equals(email)) {
					return false;
				}
			}return true;
	    }
	
	public void updateAdress(String address) {
		String[] parts = address.split(" ");
        if ( parts.length==3 ) {
        	if (parts[1].matches("[0-9]+")) {
        		for (Client c : lc.getClients()) {
            		if (client.getName().equals(c.getName())) {
            			c.setAddress(address);
            		}
            	}
        	}
        }
        
	}
	
	public void updatePassword(String password) {
		for (Client c : lc.getClients()) {
    		if (client.getName().equals(c.getName())) {
    			c.setPassword(password);
    		}
    	}
	}
	
	public void updateContactPerson(String rp) {
		if (!(rp == null) && rp.matches("[a-zA-Z ]+")) {
			for (Client c : lc.getClients()) {
        		if (client.getName().equals(c.getName())) {
        			c.setContactPerson(rp);
        		}
        	}
	    }
		        	
		        	
		        
		     
			}
}
