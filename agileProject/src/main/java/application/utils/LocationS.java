package application.utils;

import javax.persistence.Entity;
import javax.persistence.Id;

import application.model.database.IData;

@Entity
public class LocationS implements IData{
	@Id
	private int locationID;
	private String name;
	
	public String getName() {
		return name;
	}
	 
	public LocationS() {
		
	}
	public LocationS(String name) {
		super();
		this.name = name;
	}
	@Override
	public int getID() {
		return locationID;
	}
	@Override
	public void setID(int id) {
		locationID = id;
		
	}
}
