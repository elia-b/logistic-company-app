package application.model;

import java.util.ArrayList;
import java.util.List;

public class ClientApplication {

	// Reference to lc to access databases
	private LogisticCompany lc;

	// variable to store which client is logged-in
	private int clientID;

	// Getter for ClientID
	public int getClientID() {
		return clientID;
	}

	public ClientApplication(int clientID, LogisticCompany lc) {
		this.clientID = clientID;
		this.lc = lc;

	}

	public String updateName(String name) {
		// Update Name in databases only if name is valid
		// Otherwise return string response for GUI
		if (lc.getCic().checkNameValid(name)) {
			lc.getClientDatabase().changeName(clientID, name);
			return "Company name succesfully updated.";
		} else {
			return "Invalid information. Please try again.";
		}
	}

	public String updateEmail(String email) {
		// Update email in databases only if email is valid
		// Otherwise return string response for GUI
		if (lc.getCic().checkEmailValid(email)) {
			lc.getClientDatabase().changeEmail(clientID, email);

			return "Company email address succesfully updated.";
		} else {
			return "Invalid information. Please try again.";
		}
	}

	public String updateAdress(String address) {
		// Update address in databases only if address is valid
		// Otherwise return string response for GUI
		if (lc.getCic().checkAddressValid(address)) {
			lc.getClientDatabase().changeAddress(clientID, address);
			return "Company address succesfully updated.";
		} else {
			return "Invalid information. Please try again.";
		}

	}

	public String updatePassword(String password) {

		// Update password in databases only if password is valid
		// Otherwise return string response for GUI
		if (lc.getCic().checkPassword(password)) {
			lc.getClientDatabase().changePassword(clientID, password);
			return "Password succesfully updated.";
		} else {
			return "Passwords don't match. Please try again.";
		}
	}

	public String updateContactPerson(String rp) {
		// Update contact person in databases only if contact person is valid
		// Otherwise return string response for GUI
		if (lc.getCic().checkReferencePersonValid(rp)) {
			lc.getClientDatabase().changeContactPerson(clientID, rp);

			return "Company contact person succesfully updated.";
		} else {
			return "Invalid information. Please try again.";
		}
	}

	public List<Journey> filterJourneysbyContent(String content) {

		List<Journey> results = new ArrayList<Journey>();

		// Loop through all Journeys
		for (int i = 0; i < lc.getJourneys().size(); i++) {
			// check that the journey is hosted by the logged-in client
			if (lc.getJourneys().getValueFromID(i).getClientid() == clientID &&
			// check if the journeys content is what the client is search for
					lc.getJourneys().getValueFromID(i).getContent().equals(content)) {
				// add the found journey to the result list
				results.add(lc.getJourneys().getValueFromID(i));
			}
		}
		return results;
	}

	public List<Journey> filterJourneysbyDestination(String destination) {

		List<Journey> results = new ArrayList<Journey>();
		// Loop through all Journeys
		for (int i = 0; i < lc.getJourneys().size(); i++) {
			// check that the journey is hosted by the logged-in client
			if (lc.getJourneys().getValueFromID(i).getClientid() == clientID &&
			// check if the journeys destination is what the client is search for
					lc.getJourneys().getValueFromID(i).getDestination().equals(destination)) {
				// add the found journey to the result list
				results.add(lc.getJourneys().getValueFromID(i));
			}
		}
		return results;
	}

	public List<Journey> filterJourneysbyOrigin(String origin) {

		List<Journey> results = new ArrayList<Journey>();
		// Loop through all Journeys
		for (int i = 0; i < lc.getJourneys().size(); i++) {
			// check that the journey is hosted by the logged-in client
			if (lc.getJourneys().getValueFromID(i).getClientid() == clientID &&
			// check if the journeys origin is what the client is search for
					lc.getJourneys().getValueFromID(i).getOrigin().equals(origin)) {
				// add the found journey to the result list
				results.add(lc.getJourneys().getValueFromID(i));
			}
		}
		return results;
	}

	public String registerJourney(Journey j) {
		// check if journey details are valid
		if (lc.getCic().checkJourneyDetails(j.getOrigin(), j.getDestination(), j.getContent())) {
			ArrayList<Container> containerList = new ArrayList<Container>();

			// initiate boolean to check wether enough containers for the journey got found
			boolean enoughContainers = true;
			int jid = lc.getJourneys().size();
			// loop through the number of requested containers
			for (int i = 0; i < j.getNOfContainers(); i++) {
				// look for a container id that is located at the origin of the journey and
				// empty
				int Cid = lc.getContainers().getIDfromEmptyContainerLocation(j.getOrigin());
				// check if the id is -1 (which means the search was unsuccessful) and change
				// the boolean if that is the case
				if (Cid == -1) {
					enoughContainers = false;
					// if the search was successful
				} else {
					// mark the containers to be on a journey so the next round of the loop wont
					// find the same container again
					lc.getContainers().startJourney(Cid, jid, j.getContent());
					// add the container to the list of containers connected to the journey
					containerList.add(lc.getContainers().getValueFromID(Cid));

				}

			}
			// if there werent enough containers
			if (!enoughContainers) {
				for (Container c : containerList) {
					// unmark containers and return error message
					lc.getContainers().finishJourney(c.getID());

				}
				return "Not enough containers. Please try again.";
			} else {
				// If enough containers got found, loop through the containerlist and create the
				// mock-up container status for them
				for (Container c : containerList) {
					lc.getContainersHistory().registerValue(new ContainerStatus(0, 0, 0, 0, jid, c.getID()));

				}
				// register the journey
				lc.getJourneys().registerValue(j);
				return "Journey registered successfully.";
			}

		}
		return "Invalid Info";

	}

	public List<ContainerStatus> getLatestStatus(int journeyid) {
		List<ContainerStatus> results = new ArrayList<ContainerStatus>();

		// check if the requested journey id exists
		if (lc.getJourneys().containsKey(journeyid)) {

			// check if the requested journey id is hosted by the logged-in client
			if (lc.getJourneys().getValueFromID(journeyid).getClientid() == clientID) {
				// loop through the containers connected to journey
				for (Container c : lc.getContainers().containerOnJourney(journeyid)) {
					// and save all statuses for each container as lcs
					List<ContainerStatus> lcs = lc.getContainersHistory().getContainerStatusfromJourney(journeyid,
							c.getID());
					// if there is at least one status in lcs
					if (lcs.size() > 0) {
						// add the last status to the results
						results.add(lcs.get(lcs.size() - 1));
					}

				}
			}
			return results;
		}
		return results;

	}

	public List<ContainerStatus> getclosestStatus(int journeyid, long date) {

		List<ContainerStatus> results = new ArrayList<ContainerStatus>();
		// check that the requested journey id exists and the date is valid
		if (lc.getJourneys().containsKey(journeyid) && lc.getCic().checkDate(date)) {
			// initiate counters for the loop
			int count = 0;
			int index = 0;
			// check if the requested journey is hosted by the logged-in client
			if (lc.getJourneys().getValueFromID(journeyid).getClientid() == clientID) {

				// loop through the containers on the journey
				for (Container c : lc.getContainers().containerOnJourney(journeyid)) {
					// save there statuses as lcs
					List<ContainerStatus> lcs = lc.getContainersHistory().getContainerStatusfromJourney(journeyid,
							c.getID());
					// check if there is at least on status on lcs
					if (lcs.size() > 0) {
						// get the difference between the requested date and first container status date
						long diff = lcs.get(0).getDifference(date);
						// update count and index for each container
						count = 0;
						index = 0;
						// loop through container statuses in lcs
						for (ContainerStatus cs : lcs) {
							// check if the last diff is bigger then the current difference
							if (diff > cs.getDifference(date)) {
								// save the new smallest difference
								diff = cs.getDifference(date);
								// save the index of the container status with the new closest difference in lcs
								// as index
								index = count;
							}
							// update count for each status in lcs to keep track of the index you are on
							count++;
						}
						// when done checking all the statuses for a container add the status that is at
						// index
						results.add(lcs.get(index));
					}
				}
			}
			return results;
		}
		return results;

	}
}
