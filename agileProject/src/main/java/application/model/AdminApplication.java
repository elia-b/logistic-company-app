package application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class AdminApplication {
	
	private LogisticCompany lc;
	
	
	public AdminApplication(LogisticCompany lc){
		
		this.lc = lc;
	}
	
	public String register_new_client(Client c1) {
        
		
        if (lc.getCic().checkAllInfo(c1)) {
				c1.setPassword(generatePassword());
                lc.getDatabase().registerValue(c1);;
                return "Registration Successful";
            }
        else{
            return "Invalid Info";
        }
    }
	
	public void getClientReport() {
		System.out.print(lc.getReport().getClientReport().getClientapp());
	}
	
	private String generatePassword() {
		//for now it does not randomly generate the password, 
		//but at some point it would be nice
		return "123";
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
	
	
	public String registerContainer(Container C) {
		if (lc.getCic().checkLocation(C.getLocation())) {
			lc.getContainers().registerValue(C);
			return "Container registered";
		}return "Location invalid";
		
		
	}
	
	public String updateJourney(int journeyid, String newlocation) {
		if (lc.getJourneys().containsKey(journeyid)) {
			if (lc.getCic().checkLocation(newlocation)) {
				List<Container> containers = lc.getContainers().containerOnJourney(journeyid);
				for (Container c : containers) {
					lc.getContainers().changeLocation(c.getID(), newlocation);
				}
				return "Successful Journey Update";
				}else {
					return "Unsuccessful Journey Update";
				}
		}return "Journey not found";
		
		
	}
	
	public String finishJourney(int journeyid) {
		if (lc.getJourneys().containsKey(journeyid)){
			List<Container> containers = lc.getContainers().containerOnJourney(journeyid);
			String newlocation = lc.getJourneys().getValueFromID(journeyid).getDestination();
			for (Container c : containers) {
				lc.getContainers().changeFinishJourney(c.getID());
				lc.getContainers().changeLocation(c.getID(), newlocation);
			}
			return "Journey finished";
		}return "Journey not found";
		
	}
	
	public String updateStatus(int containerid,float humidity,float temp,float press,long date) {
		if (lc.getCic().checkDate(date)) {
			if (lc.getContainers().getValueFromID(containerid) != null) {
				int jId = lc.getContainers().getValueFromID(containerid).getJourneyID();
				ContainerStatus cs = new ContainerStatus(date,temp,press,humidity, jId, containerid );
				lc.getContainersHistory().registerValue(cs);
				return "Successful Update";
			} else {
				return "Invalid Container ID";
			}
			
		}else {
			return "Invalid Date";
		}
	}

	public List<ContainerStatus> searchContainerHistory(int containerid) throws Exception {
        if (lc.getContainersHistory().containsKey(containerid)){
                return lc.getContainersHistory().getContainerStatusfromContainer(containerid);
            }
        throw new Exception("There is no container with that ID in the database");
    }
   
    public ArrayList<Integer> getJourneyIDsfromContainerHistory(int containerid) throws Exception{
        ArrayList<Integer> journeys = new ArrayList<Integer>();
        if (lc.getContainersHistory().containsKey(containerid)){
	        for (ContainerStatus cs : lc.getContainersHistory().getContainerStatusfromContainer(containerid)) {
	        	if (!journeys.contains(cs.getJourneyId())) {
	        		journeys.add(cs.getJourneyId());
	        	}
	            
	        }
        return journeys;
        }
        throw new Exception("That container ID is not in the database");
    }
   
    public List<ContainerStatus> getStatusesFromContainerHistory(int containerid, int journeyid) throws Exception{
        if (lc.getContainersHistory().containsKey(containerid)){
        	return lc.getContainersHistory().getContainerStatusfromJourney(journeyid, containerid);
        }
        throw new Exception("That container ID is not in the database");
    }
    
    public String addLocation(String location){
    	if(lc.getCic().checkLocation(location)) {
    		lc.getLocationDatabase().addLocation(location);
    		return "Location Added";
    	}
    	else {
    		return "Location not Valid";
    	}
    }
}