package application.model;

import java.util.ArrayList;

public class ContainerHistory implements IData{

    private int containerID;
    private ArrayList<ContainerJourneyHistory> containerJourneys;

    @Override
    public int getID() {
        return containerID;
    }

    @Override
    public void setID(int id) {
        this.containerID = id;
        
    }

    public ArrayList<ContainerJourneyHistory> getContainerJourneys() {
        return containerJourneys;
    }
    
}
