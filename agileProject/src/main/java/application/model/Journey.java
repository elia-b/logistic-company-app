package application.model;

import java.util.ArrayList;

public class Journey implements IData{
	
	//Maybe add something for the current position
	private String origin;
	private String destination;
	private int clientid;
	private String content;
	private int numberOfContainers;
	private int id;
	private ArrayList<Container> containers = new ArrayList<Container>();
	
	public int getClientid() {
		return clientid;
	}

	public Journey(String content,String origin, String destination, int numberOfContainers) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.numberOfContainers = numberOfContainers;
		this.content = content;
	}

	public ArrayList<Container> getContainers(){
		return containers;
	}

	public void setContainers(ArrayList<Container> cl){
		containers = cl;
	}

	public int getNOfContainers() {
		return this.numberOfContainers;
	}
	public void setClientID(int clientid) {
		this.clientid = clientid;
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
		return id;
	}

	@Override
	public void setID(int id) {
		this.id = id;
		
	}
	

	
}
