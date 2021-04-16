package application.model;

import java.util.ArrayList;

public class ContainerJourneyHistory  {
	private ArrayList<ContainerStatus> status = new ArrayList<ContainerStatus>();
	private int JourneyId;
	
	public ContainerJourneyHistory(int JourneyId) {
		this.JourneyId = JourneyId;
	}

	public int getJourneyId() {
		return JourneyId;
	}

	public ArrayList<ContainerStatus> getStatus() {
		return status;
	}
	

}
