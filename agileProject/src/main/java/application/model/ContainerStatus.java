package application.model;

import java.util.Calendar;
import java.util.Date;

public class ContainerStatus {
	private Date date;
	private float temperature;
	private float pressure;
	private float humidity;
	public Date getDate() {
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
	public ContainerStatus(String date, float temperature, float pressure, float humidity) {
		super();
		this.date = convertDate(date);
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
	}
	  
	
	private Date convertDate(String date) {
		String[] splitdate = date.split(":",5);
		Calendar c = Calendar.getInstance();
    	c.set(Integer.parseInt(splitdate[0]),Integer.parseInt(splitdate[1]),Integer.parseInt(splitdate[2]),Integer.parseInt(splitdate[3]),Integer.parseInt(splitdate[4]));	
		return c.getTime();
	}
	
	public long getDifference(String requestedDate) {
		Date rDate = convertDate(requestedDate);
		long diff = rDate.getTime() - date.getTime();
		return Math.abs(diff);
	}
	
}
