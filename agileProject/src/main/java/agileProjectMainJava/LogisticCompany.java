package agileProjectMainJava;

import java.util.HashSet;
import java.util.Set;

// Create an interface for any logistic company
public class LogisticCompany implements User{
	
    private Database clients = new Database();
    private JourneyDatabase journeys = new JourneyDatabase();
    private ClientInfoChecker cic = new ClientInfoChecker(this);

	private static final String logisticCompanyUsername = "LCU";
	private static final String logisticCompanyPassword = "123";
	private static final String logisticCompanyEmail = "logistic.company@gmail.com";
	
	public ClientInfoChecker getCic() {
		return cic;
	}
	
    public Database getDatabase() {
		return clients;
	}
    public JourneyDatabase getJourneys() {
    	return journeys;
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
