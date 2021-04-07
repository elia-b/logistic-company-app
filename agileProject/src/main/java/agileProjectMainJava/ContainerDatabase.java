package agileProjectMainJava;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class ContainerDatabase extends IDatabase<Container> {
	
	public int getIDfromContainerLocation(String location) {
		
		for (Entry<Integer, Container> entry : data.entrySet()) {
			if (entry.getValue().getLocation().equals(location)&&!entry.getValue().getOnJourney()) {
				return entry.getKey();
			}
		}
		// -1 means that the name doesn't exist
		return -1;
	}
}
