package application.model;

import java.util.ArrayList;

public class Container implements IData{
	private String content;
	private String location;
	private boolean OnJourney;
	private int id;
	private ArrayList<ContainerStatus> status = new ArrayList<ContainerStatus>();
	
	public ArrayList<ContainerStatus> getStatus() {
		return status;
	}
	
	 

	public Container(String location) {
		content = "empty";
		this.location = location;
		OnJourney = false;
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

	public void setContent(String content) {
		this.content = content;
	}
	public void startJourney() {
		OnJourney = true;
		
	}
	
	public void endJourney() {
		OnJourney = false;
		content = "empty";
		status = new ArrayList<ContainerStatus>();
	}
	
	public boolean getOnJourney() {
		return OnJourney;
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
