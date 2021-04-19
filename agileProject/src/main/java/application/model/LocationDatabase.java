package application.model;

import java.util.ArrayList;
import application.utils.LocationPicker;

public class LocationDatabase {
    private ArrayList<String> locations = new ArrayList<String>();
    LocationPicker lp = new LocationPicker();
    
    public LocationDatabase(){
        locations.add("BERLIN");
        locations.add("ROME");
        locations.add("COPENHAGEN");
        locations.add("NEWYORK");
        lp.updateCombo(locations);
    }

    public ArrayList<String> getLocations(){
        return locations;
    }

    public void addLocation(String l){
        locations.add(l);
        lp.updateCombo(locations);
    }

    public LocationPicker getLocationPicker(){
        return lp;
    }
}
