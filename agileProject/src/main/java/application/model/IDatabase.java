package application.model;

import java.util.HashMap;
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
    
    
    public C getValueFromID(int id);
    
    public void registerValue(C c);
    
    public Set<Entry<Integer, C>> entrySet();
    
    public Boolean containsKey(int i);
    
    public int size();
}

