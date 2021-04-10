package agileProjectMainJava;

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
		return new Date(Integer.parseInt(splitdate[0]),Integer.parseInt(splitdate[1]),Integer.parseInt(splitdate[2]),Integer.parseInt(splitdate[3]),Integer.parseInt(splitdate[4]));	
	}
	
	public int getDifference(String requestedDate) {
		Date rDate = convertDate(requestedDate);
		int diff = 0;
		diff = diff + (rDate.getYear()-date.getYear())*15768000;
		diff = diff + (rDate.getMonth()-date.getMonth())*43200;
		diff = diff + (rDate.getDay()-date.getDay())*1440;
		diff = diff + (rDate.getHour()-date.getHour())*60;
		diff = diff + (rDate.getMinutes()-date.getMinutes());
		
		return Math.abs(diff);
	}
	
}
