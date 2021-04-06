package agileProjectMainJava;

public class Container {
	private String content;
	private String location;
	private boolean OnJourney;
	
	
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
	}
	
	public boolean getOnJourney() {
		return OnJourney;
	}
}
