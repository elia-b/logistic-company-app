package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import application.model.database.IData;

@Entity
public class Container implements IData {
	// class members to describe a container
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
		// inital id = -1, when a container goes on a journey it gets updated
		journeyID = -1;
	}

	// updating journeyID and content to start a journey
	public void startJourney(String content, int journeyID) {
		this.journeyID = journeyID;
		this.content = content;

	}

	// changing id back to -1 and content to "empty" to end the journey
	public void endJourney() {
		this.journeyID = -1;
		content = "empty";
	}

	// Getters and Setters
	public int getJourneyID() {
		return journeyID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int getID() {
		return containerId;
	}

	@Override
	public void setID(int id) {
		this.containerId = id;

	}

	public String getContent() {
		return this.content;
	}
}
