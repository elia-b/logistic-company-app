package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Container implements IData{
	private String content;
	private String location;
	private int journeyID;


	@Id
	private int containerId;
	
	public Container() {
		
	}

	public Container(String location) {
		content = "empty";
		this.location = location;
		journeyID = -1;
	}
	
	public int getJourneyID() {
		return journeyID;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
 
	public String getContent() {
		return content;
	}

	public void startJourney(String content, int journeyID) {
		this.journeyID = journeyID;
		this.content = content;
		
	}
	
	public void endJourney() {
		this.journeyID = -1;
		content = "empty";
	}
	
	public boolean getOnJourney() {
		if (journeyID == -1) {
			return false;
		}else {
			return true;
		}
	}


	@Override
	public int getID() {
		return containerId;
	}


	@Override
	public void setID(int id) {
		this.containerId = id;
		
	}
}
