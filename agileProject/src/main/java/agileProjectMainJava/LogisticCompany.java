package agileProjectMainJava;

// Create an interface for any logistic company
public class LogisticCompany implements User{
	
    private ClientDatabase clients = new ClientDatabase();
    private JourneyDatabase journeys = new JourneyDatabase();
    private ClientInfoChecker cic = new ClientInfoChecker(this);
    private ContainerDatabase containers = new ContainerDatabase();
    
    
	public ContainerDatabase getContainers() {
		return containers;
	}


	private static final String logisticCompanyUsername = "LCU";
	private static final String logisticCompanyPassword = "123";
	private static final String logisticCompanyEmail = "logistic.company@gmail.com";
	
	public ClientInfoChecker getCic() {
		return cic;
	}
	
    public ClientDatabase getDatabase() {
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
