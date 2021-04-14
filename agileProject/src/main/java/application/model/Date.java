package application.model;

public class Date {
	int day;
	int month;
	int year;
	int hour;
	int minutes;
	public Date(int day, int month, int year, int hour, int minutes) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public int getHour() {
		return hour;
	}
	public int getMinutes() {
		return minutes;
	}
	
	
}
