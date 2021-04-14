package application.model;

import java.util.Map.Entry;

public class ClientDatabase extends IDatabase<Client> {

	public int getIDfromClientName(String name) {
		for (Entry<Integer, Client> entry : super.entrySet()) {
			if (entry.getValue().getName().equals(name)) {
				return entry.getKey();
			}
		}
		// -1 means that the name doesn't exist
		return -1;
	}

}
