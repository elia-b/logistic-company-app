package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import application.model.database.IData;

@Entity
public class Journey implements IData{
	
	public boolean equals(Journey j) {
		return this.getDestination().equals(j.getDestination()) && 
			   this.getOrigin().equals(j.getOrigin()) &&
			   this.getNOfContainers() == j.getNOfContainers() &&
			   this.getContent().equals(j.getContent()) &&
			   this.getClientid() == j.getClientid();
	}

	//Maybe add something for the current position
	private String origin;
	private String destination;
	private int clientid;
	private String content;
	private int numberOfContainers;
	@Id
	private int journeyId;
	
	public int getClientid() {
		return clientid;
	}
	
	public Journey() {
		
	}

	public Journey(String content,String origin, String destination, int numberOfContainers, int clientid) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.numberOfContainers = numberOfContainers;
		this.content = content;
		this.clientid = clientid;
	}

	public int getNOfContainers() {
		return this.numberOfContainers;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public String getDestination() {
		return this.destination;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int getID() {
		return journeyId;
	}

	@Override
	public void setID(int id) {
		this.journeyId = id;
		
	}
	
}
