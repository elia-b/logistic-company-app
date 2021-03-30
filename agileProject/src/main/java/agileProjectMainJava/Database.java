package agileProjectMainJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Database {
	
	Map<Integer, Client> data = new HashMap();
	
	
	public Client getClientFromID(int id) {
		return data.get(id);
	}
	
	public void registerClient(Client c) {
		data.put(data.size(), c);
	}
	
	public Set<Entry<Integer, Client>> entrySet() {
		return data.entrySet();
	}
	
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
