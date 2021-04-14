package application.model;

public class JourneyDatabase extends IDatabase<Journey>{

	
	public int size() {
		return super.entrySet().size();
	}
	
	
}
