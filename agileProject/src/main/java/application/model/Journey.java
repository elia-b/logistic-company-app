package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Journey implements IData{
	
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
