package application.model;

import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JourneyDatabase implements IDatabase<Journey>{

	private Configuration con = new Configuration().configure().addAnnotatedClass(Journey.class);
	
	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	
	private SessionFactory sf = con.buildSessionFactory(reg);
	
	private Session session = sf.openSession();

	@Override
	public Journey getValueFromID(int id) {
		if (this.containsKey(id)){
    		
    		session.beginTransaction();
    		Query q = session.createQuery("from Journey where journeyId = :id");
    		q.setParameter("id", id);
    		Journey c = (Journey) q.uniqueResult();
    		session.getTransaction().commit();
    		return c;
        }
        else {
        	session.getTransaction().commit();
            return null;
        }
	}

	@Override
	public void registerValue(Journey c) {
		int id = this.size();
		Transaction tx = session.beginTransaction();
		
		c.setID(id);
		session.save(c);
		
		tx.commit();
		
	}

	@Override
	public Set<Entry<Integer, Journey>> entrySet() {
		session.beginTransaction();
		Query q = session.createQuery("from Journey");
		
		List<Journey> al =  q.list();
		Set<Entry<Integer, Journey>> set = new HashSet<Entry<Integer, Journey>>();
		for(Journey c : al) {
			Entry<Integer, Journey> entry = new AbstractMap.SimpleEntry<Integer, Journey>(c.getID(), c);
			set.add(entry);
		}
		session.getTransaction().commit();
        return set;
	}

	@Override
	public Boolean containsKey(int i) {
		session.beginTransaction();
        Query query = session.createQuery("select 1 from Journey c where c.journeyId = :i");
        query.setParameter("i", i);
        session.getTransaction().commit();
        return (query.uniqueResult() != null);
	}

	public int size() {
		session.beginTransaction();
        Query query = session.createQuery("from Journey");           
        List<Journey> al = query.list();
        session.getTransaction().commit();
        return al.size();
	}
	public List<Journey> getAll() {
		session.beginTransaction();
        Query query = session.createQuery("from Journey");           
        List<Journey> al = query.list();
        session.getTransaction().commit();
        return al;
	}
	
	
	
}
