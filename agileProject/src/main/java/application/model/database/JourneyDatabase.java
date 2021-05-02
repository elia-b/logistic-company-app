package application.model.database;

import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import application.model.Journey;

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
		// check the existence of journey ID
		if (this.containsKey(id)){
    		
    		session.beginTransaction();
    		// creating the query object via jouneryId "id"
    		Query q = session.createQuery("from Journey where journeyId = :id");
    		// initialise "id" = id
    		q.setParameter("id", id);
    		// cast the q to journey type and create the journey object c
    		Journey c = (Journey) q.uniqueResult();
    		session.getTransaction().commit();
    		// return the journey
    		return c;
        }
        else { 
        	
            return null;
        }
	}

	@Override
	public void registerValue(Journey c) {
		// jounery id equal to the current number of journey in the database
		int id = this.size();
		Transaction tx = session.beginTransaction();
		//set the journey id
		c.setID(id);
		// save the journey
		session.save(c);
		// end the transaction
		tx.commit();
		
	}

	@Override
	public Set<Entry<Integer, Journey>> entrySet() {
		return null;
	}

	@Override
	public Boolean containsKey(int i) {
		session.beginTransaction();
        // why select 1??
		Query query = session.createQuery("select 1 from Journey c where c.journeyId = :i");
        // initialise "i" = input i
		query.setParameter("i", i);
        session.getTransaction().commit();
        // check if the id exist
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

	public List<Journey> getMyJourneys(int clientid) {
		session.beginTransaction();
		// create the query object via clientid (id) 
		Query q = session.createQuery("from Journey where clientid = :id");
		// initialise id to clientid
		q.setParameter("id", clientid);
		// create a list with the jounery owned by the specific client
		List<Journey> al = q.list();
		session.getTransaction().commit();
		// return all the journey
		return al;
		
	}
	
	
	
}
