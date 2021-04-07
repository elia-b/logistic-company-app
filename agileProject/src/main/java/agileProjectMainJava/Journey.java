package agileProjectMainJava;

import java.util.ArrayList;

public class Journey {
	
	//Maybe add something for the current position
	private String origin;
	private String destination;
	private int clientid;
	private ArrayList<Container> containers = new ArrayList<Container>();
	
	public int getClientid() {
		return clientid;
	}
	
	


	public Journey(String origin, String destination, int clientid,ArrayList<Container> containerList) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.clientid = clientid;
		this.containers = containerList;
		
	}
	public ArrayList<Container> getContainers(){
		return containers;
	}

	
	public String getOrigin() {
		return this.origin;
	}
	public String getDestination() {
		return this.destination;
	}
	

	
}
