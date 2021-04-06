package agileProjectMainJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class JourneyDatabase {
	Map<Integer,Journey> data = new HashMap();
	
	
	public Journey getJourneyFromID(String id) {
		return data.get(id);
	}
	
	//the id for a journey is currently a string made of clientid + journeytotalnumber
	// Maybe it is smarter to just have journeytotalnumber as the id (as int)
	// i was thinking that it might be faster this way to find all journey of one client
	public void registerJourney(Journey j) {
		data.put(data.size(), j);
	}
	
	public Set<Entry<Integer, Journey>> entrySet() {
		return data.entrySet();
	}
	
	public int size() {
		return data.size();
	}
	
	
}
