package agileProjectMainJava;

public class ApplicationLogIn {

	private LogisticCompany lc;
	private Application app;
	
	public ApplicationLogIn(LogisticCompany lc){
		this.lc = lc;
	}
	
	public void logIn(String username, String password) {
		if ((username.equals(lc.getEmail()) || username.equals(lc.getUsername())) && password.equals(lc.getPassword())) {
			app = new AdminApplication(lc);
		} else {
			int clientID = lc.getDatabase().getIDfromClientName(username);
			if (clientID != -1){
				if(lc.getDatabase().getValueFromID(clientID).getPassword().equals(password)){
					app = new ClientApplication(clientID, lc);
				} else {
					// invalid password
				}
				
			} else {
				//invalid company username
			}
		}
	}

	public Application getapp(){
		return app;
	}
}
