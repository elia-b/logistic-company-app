package application.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DataBaseMainTest {
	
	public static void main(String[] args) {
		
		Client c = new Client("Oskar", "Address 23 asd", "paul@paul.com", "soadkas");
		Client c1 = new Client("Paul2", "Address 23 asd", "paul2@paul.com", "soadkas");
		ClientDatabase cb = new ClientDatabase();
		JourneyDatabase jb = new JourneyDatabase();
		ContainerDatabase conb = new ContainerDatabase();
		cb.registerValue(c1);
		cb.registerValue(c);
		Container clon1 = new Container("LONDON");
		Container clon2 = new Container("LONDON");
		conb.registerValue(clon1);
		conb.registerValue(clon2);
		Journey j1 = new Journey("fish","LONDON", "PARIS", 2, cb.getIDfromClientName("Paul"));
		jb.registerValue(j1);
		Client c3 = cb.getValueFromID(0);
		cb.changeName(0, "I am new");
		System.out.println(c3.getName());
		System.out.println( cb.getIDfromClientName("Paul"));
		
	}

}