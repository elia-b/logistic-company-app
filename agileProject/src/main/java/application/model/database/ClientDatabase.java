package application.model.database;

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

import application.model.Client;

public class ClientDatabase implements IDatabase<Client> {

	private Configuration con = new Configuration().configure().addAnnotatedClass(Client.class);

	private ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
			.buildServiceRegistry();

	private SessionFactory sf = con.buildSessionFactory(reg);

	private Session session = sf.openSession();
	
	// getIDfromClientName
	public int getIDfromClientName(String nameClient) {
		// start the transaction
		session.beginTransaction();
		// instantiate query object and create the String hql
		Query q = session.createQuery("from Client where name = :nameClient");
		// Using named parameters nameClient
		q.setParameter("nameClient", nameClient);
		// ensure return a single object and cast the type to client
		Client c = (Client) q.uniqueResult();
		//setting transcation boundaries
		session.getTransaction().commit();
		// if there is no such client 
		if (c == null) {
			return -1;
		} else {
		// return the client ID
			return c.getID();
		}

	}
	// 
	public Client getValueFromID(int id) {
		// check if the ID exist in the database 
		if (this.containsKey(id)){
    		
    		session.beginTransaction();
    		Query q = session.createQuery("from Client where clientID = :id");
    		q.setParameter("id", id);
    		Client c = (Client) q.uniqueResult();
    		session.getTransaction().commit();
    		// return the client via his ID
    		return c;
        }
        else {
        	//end the transaction 
        	session.getTransaction().commit();
           // no such client and return null
        	return null;
        }
    } 
    
    public void registerValue(Client c) {
    	// ID value equal to the current number of client in the list 
    	int id = this.size();
		//start transaction tx for add the value of new data
    	Transaction tx = session.beginTransaction();
    	// set client ID which equal to the number of client in the list
		c.setID(id);
		// save the client entity
		session.save(c);
		// end the transaction
		tx.commit();
	}

	public Set<Entry<Integer, Client>> entrySet() {

		session.beginTransaction();
		Query q = session.createQuery("from Client");
		// create the list with all the client object
		List<Client> al = q.list();
		// create a new hashset with Entry Object
		Set<Entry<Integer, Client>> set = new HashSet<Entry<Integer, Client>>();
		// loop through all the client object in the al list
		for (Client c : al) {
			// Initialise the Entry; Integer = c.getID(), client = c
			Entry<Integer, Client> entry = new AbstractMap.SimpleEntry<Integer, Client>(c.getID(), c);
			// add the new entry to the hashset
			set.add(entry);
		}
		// end transcation
		session.getTransaction().commit();
		return set;
	}
	// checking the existense of ID
	public Boolean containsKey(int i) {
		// start the transaction
		session.beginTransaction();
		//  instantiate query object and create the String hql
		Query query = session.createQuery("select 1 from Client c where c.clientID = :i");
		// Using named parameter i
		query.setParameter("i", i);
		//setting transcation boundaries
		session.getTransaction().commit();
		// check if exist such ID
		return (query.uniqueResult() != null);
	}

	public int size() {
		session.beginTransaction();
		//load a complete persistent client objects into memory. 
		Query query = session.createQuery("from Client");
		// create a list of Client object
		List<Client> al = query.list();
		// end transaction
		session.getTransaction().commit();
		// return the number of client object
		return al.size();
	}
// change Name, Email, Password , Address and contact person
	public void changeName(int clientId, String newName) {
		session.beginTransaction();
		// return the Client instance of client class with identifier ClientID
		Client c = (Client) session.get(Client.class, clientId);
		// set new name
		c.setName(newName);
		// save the client object
		session.saveOrUpdate(c);
		// end the transcation
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

	@Override
	// override the getAll method in IDatabase interface
	public List<Client> getAll() {
		session.beginTransaction();
		Query query = session.createQuery("from Client");
		List<Client> al = query.list();
		session.getTransaction().commit();
		// return the list with all client object
		return al;
	}

}
