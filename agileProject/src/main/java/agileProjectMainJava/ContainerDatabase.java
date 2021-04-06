package agileProjectMainJava;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class ContainerDatabase {
	HashMap<Integer, Container> data = new HashMap<Integer, Container>();

	public Container getContainerFromID(int id) {
		return data.get(id);
	}

	public void registerContainer(Container c) {
		data.put(data.size(), c);
	}

	public Set<Entry<Integer, Container>> entrySet() {
		return data.entrySet();
	}

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
