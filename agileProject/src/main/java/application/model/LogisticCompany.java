package application.model;

import application.model.database.ClientDatabase;
import application.model.database.ContainerDatabase;
import application.model.database.ContainerHistoryDatabase;
import application.model.database.JourneyDatabase;
import application.utils.LocationDatabase;

// Create an interface for any logistic company
public class LogisticCompany implements User{
	

    private ClientDatabase clients = new ClientDatabase();
    private JourneyDatabase journeys = new JourneyDatabase();
    private ContainerHistoryDatabase containersHistory = new ContainerHistoryDatabase();
    private ContainerDatabase containers = new ContainerDatabase();
	private LocationDatabase locationDatabase = new LocationDatabase();

	private InputInfoChecker cic = new InputInfoChecker(this);

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


	private static final String logisticCompanyUsername = "LCU";
	private static final String logisticCompanyPassword = "123";

	
	public InputInfoChecker getCic() {
		return cic;
	}
	
    public ClientDatabase getClientDatabase() {
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


}
