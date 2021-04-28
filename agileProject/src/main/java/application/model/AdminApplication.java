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
                lc.getClientDatabase().registerValue(c1);;
                return "Client successfully registered.";
            }
        else{
            return "Invalid information. Please try again.";
        }
    }
	 

	
	private String generatePassword() {
		//for now it does not randomly generate the password, 
		//but at some point it would be nice
		return "123";
	}

	public int searchEmail(String email) {
		for (Entry<Integer, Client> entry : lc.getClientDatabase().entrySet()) {
			if (entry.getValue().getEmail().equals(email)) {
				return entry.getKey();
			}
			
		}return -1;
	}
	public int searchName(String name) {
		for (Entry<Integer, Client> entry : lc.getClientDatabase().entrySet()) {
			if (entry.getValue().getName().equals(name)) {
				return entry.getKey() ;
			}
		}return -1;
	}
	
	
	public String registerContainer(Container C) {
		if (lc.getCic().checkLocation(C.getLocation())) {
			lc.getContainers().registerValue(C);
			return "Container successfully registered.";
		}return "Invalid Location. Please try again.";
		
		
	}
	
	public String updateJourney(int journeyid, String newlocation) {
		if (lc.getJourneys().containsKey(journeyid)) {
			if (lc.getCic().checkLocation(newlocation)) {
				List<Container> containers = lc.getContainers().containerOnJourney(journeyid);
				for (Container c : containers) {
					lc.getContainers().changeLocation(c.getID(), newlocation);
				}
				return "Journey successfully updated.";
				}else {
					return "Invalid information. Please try again.";
				}
		}return "Journey not found. Please try again.";
		
		
	}
	
	public String finishJourney(int journeyid) {
		if (lc.getJourneys().containsKey(journeyid)){
			List<Container> containers = lc.getContainers().containerOnJourney(journeyid);
			String newlocation = lc.getJourneys().getValueFromID(journeyid).getDestination();
			for (Container c : containers) {
				lc.getContainers().changeFinishJourney(c.getID());
				lc.getContainers().changeLocation(c.getID(), newlocation);
			}
			return "Journey succesfully marked as finished.";
		}return "Invalid information. Please try again.";
		
	}
	
	public String updateStatus(int containerid,float humidity,float temp,float press,long date) {
		if (lc.getCic().checkDate(date)) {
			if (lc.getContainers().containsKey(containerid)) {
				int jId = lc.getContainers().getValueFromID(containerid).getJourneyID();
				ContainerStatus cs = new ContainerStatus(date,temp,press,humidity, jId, containerid );
				lc.getContainersHistory().registerValue(cs);
				return "Container successfully updated.";
			} else {
				return "Invalid information. Please try again.";
			}
			
		}else {
			return "Invalid information. Please try again.";
		}
	}

	public List<ContainerStatus> searchContainerHistory(int containerid) throws Exception {
        if (lc.getContainers().containsKey(containerid)){
                return lc.getContainersHistory().getContainerStatusfromContainer(containerid);
            }
        else {
        	throw new Exception("There is no container with that ID in the database");
        }
        
    }
   
    public ArrayList<Integer> getJourneyIDsfromContainerHistory(int containerid) throws Exception{
        ArrayList<Integer> journeys = new ArrayList<Integer>();
        if (lc.getContainers().containsKey(containerid)){
	        for (ContainerStatus cs : lc.getContainersHistory().getContainerStatusfromContainerAlsoTimeNull(containerid)) {
	        	if (!journeys.contains(cs.getJourneyId())) {
	        		journeys.add(cs.getJourneyId());
	        	}
	             
	        }
        return journeys;
        } else {
        	throw new Exception("That container ID is not in the database");
        }
    }
   
    public List<ContainerStatus> getStatusesFromContainerOnJourney(int containerid, int journeyid) throws Exception{
        if (lc.getContainers().containsKey(containerid)){
        	if (lc.getJourneys().containsKey(journeyid)){
                
            	return lc.getContainersHistory().getContainerStatusfromJourney(journeyid, containerid);
            } else {
            	throw new Exception("That Journey ID is not in the database");
            }
            
        } else {
        	throw new Exception("That Container ID is not in the database");
        }
        
    }
    
    public String addLocation(String location){
    	if(lc.getCic().checkLocation(location)) {
    		lc.getLocationDatabase().addLocation(location);
    		return "Port location succesfully added.";
    	}
    	else {
    		return "Invalid information. Please try again.";
    	}
    }
    
    
    
    
}