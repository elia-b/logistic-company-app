package application.model.database;

import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import application.model.Container;

import java.util.List;
import java.util.Set;

public class ContainerDatabase implements IDatabase<Container> {

	private Configuration con = new Configuration().configure().addAnnotatedClass(Container.class);

	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
			.buildServiceRegistry();

	private SessionFactory sf = con.buildSessionFactory(reg);

	
	private Session session = sf.openSession(); 
	
	//CHange the return type
	public int getIDfromEmptyContainerLocation(String location) {

		session.beginTransaction();
		Query q = session.createQuery("from Container where location = :location and content = :content");
		q.setParameter("location", location);
		// "empty" , "empty"?"content"
		q.setParameter("content", "empty");
		// create the container list 
		List<Container> ls = q.list();
		// end the transaction
		session.getTransaction().commit();
		// no empty container
		if (ls.size() <= 0) {
			return -1;
		} else {
			// get the container from the container list
			Container c = ls.get(0);
			// return the ID of container
			return c.getID();
		}
	}

	@Override
	// override getValueFromID in IDatabase interface
	public Container getValueFromID(int id) {
		// if the container ID exist
		if (this.containsKey(id)) {

			session.beginTransaction();
			Query q = session.createQuery("from Container where containerId = :id");
			q.setParameter("id", id);
			// create container c and cast q.uniqueResult to Container type 
			Container c = (Container) q.uniqueResult();
			//end transaction
			session.getTransaction().commit();
			// return the container
			return c;
		} else {
			// no such container ID so end the transaction
			session.getTransaction().commit();
			return null;
		}
	}

	@Override
	// override registerValue in IDatabase interface
	public void registerValue(Container c) {
		// container id equal to the current number of container in the database 
		int id = this.size();
		Transaction tx = session.beginTransaction();
		// initialise the container ID with value id 
		c.setID(id);
		// save this container in the database 
		session.save(c);

		tx.commit();
	}

	@Override
	// why we return null here???
	public Set<Entry<Integer, Container>> entrySet() {
		return null;
	}

	@Override
	// check if the container ID exist
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
		// create container list with all the container object 
		List<Container> al = query.list();
		session.getTransaction().commit();
		// return the number of container in the database
		return al.size();
	}
	
	// change the location of container
	public void changeLocation(int containerId, String location) {
		session.beginTransaction();
		// get the container object with its ID
		Container c = (Container) session.get(Container.class, containerId);
		// set the location
		c.setLocation(location);
		// save the container in the database
		session.saveOrUpdate(c);
		// end transaction
		session.getTransaction().commit();
	}

	public void startJourney(int containerId, int journeyId, String content) {
		session.beginTransaction();
		Container c = (Container) session.get(Container.class, containerId);
		// start the journey with journeyID and initialise the content 
		c.startJourney(content, journeyId);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}

	
	public void finishJourney(int containerId) {
		session.beginTransaction();
		Container c = (Container) session.get(Container.class, containerId);
		// end the journey
		c.endJourney();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}

	public List<Container> containerOnJourney(int journeyId) {
		session.beginTransaction();
		// create the query object via JourneyId
		Query q = session.createQuery("from Container where journeyId = :journeyId");
		// initialise the named parameter journeyID : journeyID
		q.setParameter("journeyId", journeyId);
		// create the list with container on journey
		List<Container> al = q.list();
		// end the transaction
		session.getTransaction().commit();
		// return all the on journey container
		return al;
	}

	public List<Container> getAll() {
		session.beginTransaction();
		Query query = session.createQuery("from Container");
		// get all container in the database no matter it on journey or not
		List<Container> al = query.list();
		session.getTransaction().commit();
		return al;
	}

	public List<Container> getMyContainers(int journeyid) {
		session.beginTransaction();
		Query q = session.createQuery("from Container where journeyID = :id");
		q.setParameter("id", journeyid);
		// get all container corresponding to the input journeyID
		List<Container> al = q.list();
		session.getTransaction().commit();
		// return the container list
		return al;
	}
}
