package application.model.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import application.model.ContainerStatus;

import java.util.Set;

public class ContainerHistoryDatabase implements IDatabase<ContainerStatus> {
	
	private Configuration con = new Configuration().configure().addAnnotatedClass(ContainerStatus.class);
	
	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	
	private SessionFactory sf = con.buildSessionFactory(reg);
	
	private Session session = sf.openSession();

	@Override
	public ContainerStatus getValueFromID(int id) {
		return null;
	}

	@Override
	public void registerValue(ContainerStatus c) {
		int id = this.size();
		Transaction tx = session.beginTransaction();
		
		c.setID(id);
		session.save(c);
		
		tx.commit();
		
	}

	@Override
	public Set<Entry<Integer, ContainerStatus>> entrySet() {
		return null;
	}

	@Override
	public Boolean containsKey(int i) {
		session.beginTransaction();
        Query query = session.createQuery("select 1 from ContainerStatus c where c.csId = :i");
        query.setParameter("i", i);
        session.getTransaction().commit();
        return (query.uniqueResult() != null);
	}


	public int size() {
		session.beginTransaction();
        Query query = session.createQuery("from ContainerStatus");           
        List<ContainerStatus> al = query.list();
        session.getTransaction().commit();
        return al.size();
	}
	
	public List<ContainerStatus> getContainerStatusfromJourney(int journeyId, int containerId){
		session.beginTransaction();
		Query q = session.createQuery("from ContainerStatus where journeyId = :journeyId and containerId = :containerId");
		q.setParameter("journeyId", journeyId);
		q.setParameter("containerId", containerId);
		List<ContainerStatus> al =  q.list();
		session.getTransaction().commit();
		List<ContainerStatus> newAl = new ArrayList<ContainerStatus>();
        for(ContainerStatus cs : al) {
        	if (cs.getDate() != 0) {
        		newAl.add(cs);
        	}
        } 
		
        return newAl;
	}
	
	public List<ContainerStatus> getContainerStatusfromContainer(int containerId){
		session.beginTransaction();
		Query q = session.createQuery("from ContainerStatus where containerId = :containerId");
		q.setParameter("containerId", containerId);
		List<ContainerStatus> al =  q.list();
		session.getTransaction().commit();
		List<ContainerStatus> newAl = new ArrayList<ContainerStatus>();
        for(ContainerStatus cs : al) {
        	if (cs.getDate() != 0) {
        		newAl.add(cs);
        	}
        }
		
        return newAl;
	}
	

	public List<ContainerStatus> getContainerStatusfromContainerAlsoTimeNull(int containerid) {
		session.beginTransaction();
		Query q = session.createQuery("from ContainerStatus where containerId = :containerId");
		q.setParameter("containerId", containerid);
		List<ContainerStatus> al =  q.list();
		session.getTransaction().commit();
        return al;
	}

	@Override
	public List<ContainerStatus> getAll() {
		return null;
	}

}  
