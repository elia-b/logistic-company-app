package agileProjectMainJava;

import java.util.HashSet;
import java.util.Set;

// Create an interface for any logistic company
public class LogisticCompany implements User{
	
    private Set<Client> clients = new HashSet<Client>();
    ClientInfoChecker cic = new ClientInfoChecker(this);

	public ClientInfoChecker getCic() {
		return cic;
	}

	private static final String logisticCompanyUsername = "LCU";
	private static final String logisticCompanyPassword = "123";
	private static final String logisticCompanyEmail = "logistic.company@gmail.com";
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

    public int numberOfClients(){
        return clients.size();
    }
	
    public Set<Client> getClients() {
		return clients;
	}

	public String getPassword() {
		return logisticCompanyPassword;
	}

	public String getUsername() {
		return logisticCompanyUsername;
	}

	public String getEmail() {
		return logisticCompanyEmail;
	}
}
