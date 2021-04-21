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

public class ContainerDatabase implements IDatabase<Container> {
	
	private Configuration con = new Configuration().configure().addAnnotatedClass(Container.class);
	
	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	
	private SessionFactory sf = con.buildSessionFactory(reg);
	
	private Session session = sf.openSession();
	
	//CHange the return type
	public int getIDfromContainerLocation(String location) {
		
		session.beginTransaction();
		Query q = session.createQuery("from Container where location = :location");
		q.setParameter("location", location);
		Container c = (Container) q.uniqueResult();
		session.getTransaction().commit();
		if(c == null) {
			return -1;
		} else {
			return c.getID();
		}
	}

	@Override
	public Container getValueFromID(int id) {
		if (this.containsKey(id)){
    		
    		session.beginTransaction();
    		Query q = session.createQuery("from Container where containerId = :id");
    		q.setParameter("id", id);
    		Container c = (Container) q.uniqueResult();
    		session.getTransaction().commit();
    		return c;
        }
        else {
        	session.getTransaction().commit();
            return null;
        }
	}

	@Override
	public void registerValue(Container c) {
		int id = this.size();
		Transaction tx = session.beginTransaction();
		
		c.setID(id);
		session.save(c);
		
		tx.commit();
	}

	@Override
	public Set<Entry<Integer, Container>> entrySet() {
		session.beginTransaction();
		Query q = session.createQuery("from Container");
		
		List<Container> al =  q.list();
		Set<Entry<Integer, Container>> set = new HashSet<Entry<Integer, Container>>();
		for(Container c : al) {
			Entry<Integer, Container> entry = new AbstractMap.SimpleEntry<Integer, Container>(c.getID(), c);
			set.add(entry);
		}
		session.getTransaction().commit();
        return set;
	}

	@Override
	public Boolean containsKey(int i) {
		session.beginTransaction();
        Query query = session.createQuery("select 1 from Container c where c.containerId = :i");
        query.setParameter("i", i);
        session.getTransaction().commit();
        return (query.uniqueResult() != null);
	}

	@Override
	public int size() {
		session.beginTransaction();
        Query query = session.createQuery("from Container");           
        List<Container> al = query.list();
        session.getTransaction().commit();
        return al.size();
	}
	
	public void changeLocation(int containerId, String location) {
		session.beginTransaction();
		Container c = (Container) session.get(Container.class, containerId); 
		c.setLocation(location);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}

	public void changeStartJourney(int containerId, int journeyId, String content) {
		session.beginTransaction();
		Container c = (Container) session.get(Container.class, containerId); 
		c.startJourney(content, journeyId);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	
	public void changeFinishJourney(int containerId) {
		session.beginTransaction();
		Container c = (Container) session.get(Container.class, containerId); 
		c.endJourney();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	
	public List<Container> containerOnJourney(int journeyId) {
		session.beginTransaction();
		Query q = session.createQuery("from Container where journeyId = :journeyId");
		q.setParameter("journeyId", journeyId);
		
		List<Container> al =  q.list();

		session.getTransaction().commit();
        return al;
	}
}
	
    


