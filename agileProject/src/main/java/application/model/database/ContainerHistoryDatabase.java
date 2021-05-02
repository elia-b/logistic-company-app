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

	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
			.buildServiceRegistry();

	private SessionFactory sf = con.buildSessionFactory(reg);

	private Session session = sf.openSession();

	@Override
	// implement the method in interface
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
		// create the query object via "i"  select 1 internal status 
		Query query = session.createQuery("select 1 from ContainerStatus c where c.csId = :i");
		// initialise "i" = i
		query.setParameter("i", i);
		session.getTransaction().commit();
		// check if container status id exist
		return (query.uniqueResult() != null);
	}

	public int size() {
		session.beginTransaction();
		// load a complete persistent query objects via container status into memory
		Query query = session.createQuery("from ContainerStatus");
		// creating the list with all the container status
		List<ContainerStatus> al = query.list();
		// end the transaction
		session.getTransaction().commit();
		// return the number of status
		return al.size();
	}

	public List<ContainerStatus> getContainerStatusfromJourney(int journeyId, int containerId) {
		session.beginTransaction();
		// create query object via journeyId and containerId
		Query q = session
				.createQuery("from ContainerStatus where journeyId = :journeyId and containerId = :containerId");
		// initialise the journeyId = journeyId
		q.setParameter("journeyId", journeyId);
		//initialise the containerId = containerId
		q.setParameter("containerId", containerId);
		// creating the container list with corresponding journey ID and container ID 
		List<ContainerStatus> al = q.list();
		// end transaction
		session.getTransaction().commit();
		// creating a new arraylist
		List<ContainerStatus> newAl = new ArrayList<ContainerStatus>();
		// loop through all the containerstatus in al list
		for (ContainerStatus cs : al) {
			// get the date of the status
			if (cs.getDate() != 0) {
				// add the container status into the arraylist newAl
				newAl.add(cs);
			}
		}

		return newAl;
	}

	public List<ContainerStatus> getContainerStatusfromContainer(int containerId) {
		session.beginTransaction();
		// create query object via containerId
		Query q = session.createQuery("from ContainerStatus where containerId = :containerId");
		//initialise the containerId = containerId
		q.setParameter("containerId", containerId);
		// creating the al list with all q object 
		List<ContainerStatus> al = q.list();
		session.getTransaction().commit();
		List<ContainerStatus> newAl = new ArrayList<ContainerStatus>();
		// check all the container status of one specific container
		for (ContainerStatus cs : al) {
			// get the date of the status
			if (cs.getDate() != 0) {
				newAl.add(cs);
			}
		}

		return newAl;
	}

	public List<ContainerStatus> getContainerStatusfromContainerAtTimeNull(int containerid) {
		session.beginTransaction();
		Query q = session.createQuery("from ContainerStatus where containerId = :containerId and date = 0");
		q.setParameter("containerId", containerid);
		List<ContainerStatus> al = q.list();
		session.getTransaction().commit();
		return al;
	}

	@Override
	public List<ContainerStatus> getAll() {
		return null;
	}

}
