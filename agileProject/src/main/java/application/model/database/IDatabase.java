package application.model.database;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Set;

public interface IDatabase<C extends IData>{
    
// get the container, client, journey via their ID    
    public C getValueFromID(int id);
   // register container, client, journey
    public void registerValue(C c);
    // create the hashset with Entry<ID,container or journey or client>
    public Set<Entry<Integer, C>> entrySet();
    // check the existence of ID  of container or client fo journey
    public Boolean containsKey(int i);
    // return the number of current container or client or journey
    public int size();
    // show all the container or client orjourney
    public List<C> getAll();
}

