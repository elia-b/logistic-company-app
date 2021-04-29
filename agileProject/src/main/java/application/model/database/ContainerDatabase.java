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
<<<<<<< HEAD

	private Session session = sf.openSession();

	// CHange the return type
=======
	
	private Session session = sf.openSession(); 
	
	//CHange the return type
>>>>>>> refs/remotes/origin/date-and-location
	public int getIDfromEmptyContainerLocation(String location) {

		session.beginTransaction();
		Query q = session.createQuery("from Container where location = :location and content = :empty");
		q.setParameter("location", location);
		q.setParameter("empty", "empty");
		List<Container> ls = q.list();
		session.getTransaction().commit();
		if (ls.size() <= 0) {
			return -1;
		} else {
			Container c = ls.get(0);
			return c.getID();
		}
	}

	@Override
	public Container getValueFromID(int id) {
		if (this.containsKey(id)) {

			session.beginTransaction();
			Query q = session.createQuery("from Container where containerId = :id");
			q.setParameter("id", id);
			Container c = (Container) q.uniqueResult();
			session.getTransaction().commit();
			return c;
		} else {
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
		return null;
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

	public void startJourney(int containerId, int journeyId, String content) {
		session.beginTransaction();
		Container c = (Container) session.get(Container.class, containerId);
		c.startJourney(content, journeyId);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
<<<<<<< HEAD

	public void changeFinishJourney(int containerId) {
=======
	
	public void finishJourney(int containerId) {
>>>>>>> refs/remotes/origin/date-and-location
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

		List<Container> al = q.list();

		session.getTransaction().commit();
		return al;
	}

	public List<Container> getAll() {
		session.beginTransaction();
		Query query = session.createQuery("from Container");
		List<Container> al = query.list();
		session.getTransaction().commit();
		return al;
	}

	public List<Container> getMyContainers(int journeyid) {
		session.beginTransaction();
		Query q = session.createQuery("from Container where journeyID = :id");
		q.setParameter("id", journeyid);
		List<Container> al = q.list();
		session.getTransaction().commit();
		return al;
	}
}
