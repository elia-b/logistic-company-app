package agileProjectMainJava;

public class ClientInfoChecker {
	
	LogisticCompany lc;
	
	public ClientInfoChecker(LogisticCompany logisticCompany) {
		this.lc = logisticCompany;
	}
	
	public boolean checkAllInfo(Client c) {
		return this.checkNameValid(c) &&
			   this.checkEmailValid(c) &&
			   this.checkAddressValid(c) &&
			   this.checkReferencePersonValid(c);
	}

	private boolean checkReferencePersonValid(Client c1) {
        // further implementation can be done
        String rp = c1.getReferencePerson();
        if (!(rp == null) && rp.matches("[a-zA-Z ]+")) {
        	
        	return true;
        	
        }
        return false;
    }

    private boolean checkEmailValid(Client c1) {
        String email = c1.getEmail();
        // Check whether a @ is there and if it is not already taken
        if (!(email == null) && email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") && checkEmailTaken(email)) {
        return true;
        }
        return false;
    }

    private boolean checkAddressValid(Client c1) {
        String address = c1.getAddress();
        String[] parts = address.split(" ");
        if ( parts.length==3 ) {
        	if (parts[1].matches("[0-9]+")) {
        		return true;
        	}
        }
        return false;
    }

    private boolean checkNameValid(Client c1) {
        String name = c1.getName();
        if (!(name == null) && name.matches("[a-zA-Z 0-9]+") && checkNameTaken(name)) {
        	return true;
        }
        return false;
        
    }
    
    private boolean checkEmailTaken(String email) {
		for (Client c : lc.getClients()) {
			if (c.getEmail().equals(email)) {
				return false;
			}
		}return true;
    }
    
    
    
    private boolean checkNameTaken(String name) {
		for (Client c : lc.getClients()) {
			if (c.getName().equals(name)) {
				return false;
			}
		}return true;
    	
    }
}
