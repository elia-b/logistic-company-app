package agileProjectMainJava;

public class ApplicationLogIn {

	private LogisticCompany lc;
	
	public ApplicationLogIn(LogisticCompany lc){
		this.lc = lc;
	}
	
	public void logIn(String username, String password) {
		if ((username.equals(lc.getEmail()) || username.equals(lc.getUsername())) && password.equals(lc.getPassword())) {
			//Admin Mode
		} else {
			for (Client c : lc.getClients()) {
				if ((username.equals(c.getEmail()) || username.equals(c.getUsername())) && password.equals(c.getPassword())){
					//Costumer Mode
				} else {
					// unsuccessful login
				}
			}
		}
	}
}
