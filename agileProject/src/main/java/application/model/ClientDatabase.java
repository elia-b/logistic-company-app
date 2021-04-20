package application.model;

import java.util.Set;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ClientDatabase implements IDatabase<Client> {
	
	private Configuration con = new Configuration().configure().addAnnotatedClass(Client.class);
	
	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	
	private SessionFactory sf = con.buildSessionFactory(reg);
	
	private Session session = sf.openSession();

	public int getIDfromClientName(String nameClient) {
		
		session.beginTransaction();
		Query q = session.createQuery("from Client where name = :nameClient");
		q.setParameter("nameClient", nameClient);
		Client c = (Client) q.uniqueResult();
		session.getTransaction().commit();
		if(c == null) {
			return -1;
		} else {
			return c.getID();
		}
		
	}
	
	public Client getValueFromID(int id) {
        if (this.containsKey(id)){
    		
    		session.beginTransaction();
    		Query q = session.createQuery("from Client where clientID = :id");
    		q.setParameter("id", id);
    		Client c = (Client) q.uniqueResult();
    		session.getTransaction().commit();
    		return c;
        }
        else {
        	session.getTransaction().commit();
            return null;
        }
    }
    
    public void registerValue(Client c) {
    	int id = this.size();
		Transaction tx = session.beginTransaction();
		
		c.setID(id);
		session.save(c);
		
		tx.commit();
    }
    
    public Set<Entry<Integer, Client>> entrySet() {
    	
    	session.beginTransaction();
		Query q = session.createQuery("from Client");
		
		List<Client> al =  q.list();
		Set<Entry<Integer, Client>> set = new HashSet<Entry<Integer, Client>>();
		for(Client c : al) {
			Entry<Integer, Client> entry = new AbstractMap.SimpleEntry<Integer, Client>(c.getID(), c);
			set.add(entry);
		}
		session.getTransaction().commit();
        return set;
    }
    

    public Boolean containsKey(int i) {
    	session.beginTransaction();
        Query query = session.createQuery("select 1 from Client c where c.clientID = :i");
        query.setParameter("i", i);
        session.getTransaction().commit();
        return (query.uniqueResult() != null);
    }


	public int size() {
		session.beginTransaction();
        Query query = session.createQuery("from Client");           
        List<Client> al = query.list();
        session.getTransaction().commit();
        return al.size();
	}
	
	public void changeName(int clientId, String newName) {
		session.beginTransaction();
		Client c = (Client) session.get(Client.class, clientId); 
		c.setName(newName);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	public void changeEmail(int clientId, String newEmail) {
		session.beginTransaction();
		Client c = (Client) session.get(Client.class, clientId); 
		c.setEmail(newEmail);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	public void changePassword(int clientId, String newPassword) {
		session.beginTransaction();
		Client c = (Client) session.get(Client.class, clientId); 
		c.setPassword(newPassword);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	public void changeContactPerson(int clientId, String newContactPerson) {
		session.beginTransaction();
		Client c = (Client) session.get(Client.class, clientId); 
		c.setContactPerson(newContactPerson);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	public void changeAddress(int clientId, String newAddress) {
		session.beginTransaction();
		Client c = (Client) session.get(Client.class, clientId); 
		c.setAddress(newAddress);
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}


}
