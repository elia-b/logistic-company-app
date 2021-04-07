package agileProjectMainJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ClientDatabase extends IDatabase<Client> {

	public int getIDfromClientName(String name) {
		for (Entry<Integer, Client> entry : data.entrySet()) {
			if (entry.getValue().getName().equals(name)) {
				return entry.getKey();
			}
		}
		// -1 means that the name doesn't exist
		return -1;
	}

}
