package application.model;

// Create an interface for any logistic company
public class LogisticCompany implements User{
	
	private UsageReport report = new UsageReport();
    private ClientDatabase clients = new ClientDatabase();
    private JourneyDatabase journeys = new JourneyDatabase();
    private ContainerHistoryDatabase containersHistory = new ContainerHistoryDatabase();
    private ContainerDatabase containers = new ContainerDatabase();
	private LocationDatabase locationDatabase = new LocationDatabase();

	private ClientInfoChecker cic = new ClientInfoChecker(this);

    //This will be used for singleton pattern
    private static LogisticCompany lc = new LogisticCompany();
    
    public static LogisticCompany GetInstance(){
		return lc;
	}
    
    private LogisticCompany(){
	}
    
	public LocationDatabase getLocationDatabase() {
		return locationDatabase;
	}
	public ContainerDatabase getContainers() {
		return containers;
	}

	public ContainerHistoryDatabase getContainersHistory() {
		return containersHistory;
	}


	public UsageReport getReport() {
		return report;
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

	public String getName() {
		return logisticCompanyUsername;
	}

	public String getEmail() {
		return logisticCompanyEmail;
	}
}
