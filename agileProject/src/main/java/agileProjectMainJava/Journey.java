package agileProjectMainJava;

import java.util.ArrayList;

public class Journey {
	
	//Maybe add something for the current position
	private String origin;
	private String destination;
	
	private String company;
	private ArrayList<Container> containers = new ArrayList<Container>();
	
	private boolean registered = false;
	
	public void addContainer(Container c) {
		containers.add(c);
	}
	
	
	public void register() {
		registered = true;
	}
	
	public boolean getStatus() {
		return registered;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	public String getDestination() {
		return this.destination;
	}
	
	public String getCompany() {
		return this.company;
	}
	
}
