package application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class AdminApplication {
	
	private LogisticCompany lc;
	
	// constructor for initialise the AdminApplication
	public AdminApplication(LogisticCompany lc){
		
		this.lc = lc;
	}
	// register the new client
	public String register_new_client(Client c1) {
        
		// check if all the client information is valid 
        if (lc.getCic().checkAllInfo(c1)) {
			// client get the default password 123
        	c1.setPassword(generatePassword());
                // register the client to the database
        		lc.getClientDatabase().registerValue(c1);;
                return "Client successfully registered.";
            }
        else{
            // invalid information exist so display error message
        	return "Invalid information. Please try again.";
        }
    }
	  

	
	private String generatePassword() {
		//default password, 
		
		return "123";
	}

	public int searchEmail(String email) {
		// loop through all the client object in the database
		for (Entry<Integer, Client> entry : lc.getClientDatabase().entrySet()) {
			// check the equality of the input email and the saved email
			if (entry.getValue().getEmail().equals(email)) {
				// return the client ID
				return entry.getKey();
			}
			// No such client
		}return -1;
	}
	public int searchName(String name) {
		// loop through all the client object in the database
		for (Entry<Integer, Client> entry : lc.getClientDatabase().entrySet()) {
			// check the equality of the input email and the saved email
			if (entry.getValue().getName().equals(name)) {
				// return the client ID
				return entry.getKey() ;
			}
		}
		// No such client
		return -1;
	}
	
	
	public String registerContainer(Container C) {
		// check if already set the location 
		if (lc.getCic().checkLocation(C.getLocation())) {
			// register the container 
			lc.getContainers().registerValue(C);
			return "Container successfully registered.";
		}return "Invalid Location. Please try again.";
		
		
	}
	
	public String updateJourney(int journeyid, String newlocation) {
		// check if exist the input journeyid
		if (lc.getJourneys().containsKey(journeyid)) {
			// check if update the newLocation
			if (lc.getCic().checkLocation(newlocation)) {
				//create the list of on journey container with corresponding journeyid
				List<Container> containers = lc.getContainers().containerOnJourney(journeyid);
				// loop through all the container in the list
				for (Container c : containers) {
					// change the previous location to newLocation
					lc.getContainers().changeLocation(c.getID(), newlocation);
				}
				return "Journey successfully updated.";
				}else {
					return "Invalid information. Please try again.";
				}
		}return "Journey not found. Please try again.";
		
		
	}
	
	public String finishJourney(int journeyid) {
		// check if the journey id exist
		if (lc.getJourneys().containsKey(journeyid)){
			// create the list of on journey container with corresponding journeyid
			List<Container> containers = lc.getContainers().containerOnJourney(journeyid);
			// initialise the newLocation to the destination of that journey
			String newlocation = lc.getJourneys().getValueFromID(journeyid).getDestination();
			//  loop through all the container in the list
			for (Container c : containers) {
				// end the journey, id reset to -1 and content to empty
				lc.getContainers().finishJourney(c.getID());
				//change the location to the destination
				lc.getContainers().changeLocation(c.getID(), newlocation);
			}
			return "Journey succesfully marked as finished.";
		}return "Invalid information. Please try again.";
		
	}
	
	public String updateStatus(int containerid,float humidity,float temp,float press,long date) {
		// check if the date valid
		if (lc.getCic().checkDate(date)) {
			// check if the container ID exist
			if (lc.getContainers().containsKey(containerid)) {
				// get the journey id of that container
				int jId = lc.getContainers().getValueFromID(containerid).getJourneyID();
				// update the parameter measurement with the input
				ContainerStatus cs = new ContainerStatus(date,temp,press,humidity, jId, containerid );
				// register the data to the database
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
        // check if the contain id exist
		if (lc.getContainers().containsKey(containerid)){
            // show that Container Status    
			return lc.getContainersHistory().getContainerStatusfromContainer(containerid);
            }
        else {
        	// throw the exception
        	throw new Exception("There is no container with that ID in the database");
        }
        
    }
   
    public ArrayList<Integer> getJourneyIDsfromContainerHistory(int containerid) throws Exception{
        // create a journey list 
    	ArrayList<Integer> journeys = new ArrayList<Integer>();
        // if the container id exist
    	if (lc.getContainers().containsKey(containerid)){
	        // loop through all the mock-up container status of the container with the input container id 
    		for (ContainerStatus cs : lc.getContainersHistory().getContainerStatusfromContainerAtTimeNull(containerid)) {
    			// and add the journey id saved in each mock-up status to journeys
    			journeys.add(cs.getJourneyId());
    			
	             
	        }
        return journeys;
        } else {
        	throw new Exception("That container ID is not in the database");
        }
    }
   
    public List<ContainerStatus> getStatusesFromContainerOnJourney(int containerid, int journeyid) throws Exception{
    	 // check if the contain id exist
    	if (lc.getContainers().containsKey(containerid)){
        	// check if the journey id exist
    		if (lc.getJourneys().containsKey(journeyid)){
                // return the on journey container status which corresponding to the input id 
            	return lc.getContainersHistory().getContainerStatusfromJourney(journeyid, containerid);
            } else {
            	throw new Exception("That Journey ID is not in the database");
            }
            
        } else {
        	throw new Exception("That Container ID is not in the database");
        }
        
    }
    
    public String addLocation(String location){
    	// check if the location input valid
    	if(lc.getCic().checkLocation(location)) {
    		// add the location to the database
    		lc.getLocationDatabase().addLocation(location);
    		return "Port location succesfully added.";
    	}
    	else {
    		return "Invalid information. Please try again.";
    	}
    }
    
    
    
    
}