package application.model.database;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import application.model.LocationS;
import application.utils.LocationPicker;

public class LocationDatabase implements IDatabase<LocationS>{
	private Configuration con = new Configuration().configure().addAnnotatedClass(LocationS.class);
	
	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	
	private SessionFactory sf = con.buildSessionFactory(reg);
	
	private Session session = sf.openSession();
	
    LocationPicker lp = new LocationPicker();
    LocationPicker lp2 = new LocationPicker();
    
    public LocationDatabase(){
    	initialisePickers();
    }


    public void addLocation(String l){
    	registerValue(new LocationS(l));
    	session.beginTransaction();
		Query q = session.createQuery("from LocationS");
		List<LocationS> al =  q.list();
		session.getTransaction().commit();
        lp.updateCombo(al);
        lp2.updateCombo(al);
    }

    public LocationPicker getLocationPicker(){
        return lp;
    }
    
    public LocationPicker getLocationPicker2(){
        return lp2;
    }

	@Override
	public LocationS getValueFromID(int id) {
		if (this.containsKey(id)){
    		
    		session.beginTransaction();
    		Query q = session.createQuery("from LocationS where locationID = :id");
    		q.setParameter("id", id);
    		LocationS c = (LocationS) q.uniqueResult();
    		session.getTransaction().commit();
    		return c;
        }
        else {
        	session.getTransaction().commit();
            return null;
        }
	}

	@Override
	public void registerValue(LocationS c) {
		int id = this.size();
		Transaction tx = session.beginTransaction();
		
		c.setID(id);
		session.save(c);
		
		tx.commit();
	}

	@Override
	public Set<Entry<Integer, LocationS>> entrySet() {
		session.beginTransaction();
		Query q = session.createQuery("from LocationS");
		
		List<LocationS> al =  q.list();
		Set<Entry<Integer, LocationS>> set = new HashSet<Entry<Integer, LocationS>>();
		for(LocationS c : al) {
			Entry<Integer, LocationS> entry = new AbstractMap.SimpleEntry<Integer, LocationS>(c.getID(), c);
			set.add(entry);
		}
		session.getTransaction().commit();
        return set;
	}

	@Override
	public Boolean containsKey(int i) {
		session.beginTransaction();
        Query query = session.createQuery("select 1 from LocationS c where c.locationID = :i");
        query.setParameter("i", i);
        session.getTransaction().commit();
        return (query.uniqueResult() != null);
	}

	@Override
	public int size() {
		session.beginTransaction();
        Query query = session.createQuery("from LocationS");           
        List<LocationS> al = query.list();
        session.getTransaction().commit();
        return al.size();
	}
	public List<LocationS> getAll() {
		session.beginTransaction();
        Query query = session.createQuery("from LocationS");           
        List<LocationS> al = query.list();
        session.getTransaction().commit();
        return al;
	}
	
	public void initialisePickers() {
		session.beginTransaction();
        Query query = session.createQuery("from LocationS");           
        List<LocationS> al = query.list();
        session.getTransaction().commit();
        lp.updateCombo(al);
        lp2.updateCombo(al);
	}


}
