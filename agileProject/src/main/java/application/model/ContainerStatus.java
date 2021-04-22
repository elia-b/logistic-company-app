package application.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import application.model.database.IData;

@Entity
public class ContainerStatus implements IData{
	private long date;
	private float temperature;
	private float pressure;
	private float humidity;
	@Id
	private int csId;
	private int journeyId;
	private int containerId;
	
	public int getJourneyId() {
		return journeyId;
	}

	public int getContainerId() {
		return containerId;
	}
	
	public long getDate() {
		return date;
	}
	public float getTemperature() {
		return temperature;
	}
	public float getPressure() {
		return pressure;
	}
	public float getHumidity() {
		return humidity;
	}
	
	public ContainerStatus(long date, float temperature, float pressure, float humidity, int journeyId, int containerId) {
		super();
		this.date = date;
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		this.journeyId = journeyId;
		this.containerId = containerId;
	}
	  
	
	private long convertDate(String date) {
		String[] splitdate = date.split(":",5);
		Calendar c = Calendar.getInstance();
    	c.set(Integer.parseInt(splitdate[0]),Integer.parseInt(splitdate[1]),Integer.parseInt(splitdate[2]),Integer.parseInt(splitdate[3]),Integer.parseInt(splitdate[4]));	
		return c.getTime().getTime();
	}
	
	public long getDifference(long date2) {
		long diff = date2 - date;
		return Math.abs(diff);
	}

	@Override
	public int getID() {
		return this.csId;
	}

	@Override
	public void setID(int id) {
		this.csId = id;
		
	}
	
}
