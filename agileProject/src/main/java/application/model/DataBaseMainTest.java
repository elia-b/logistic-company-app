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
		cb.registerValue(c1);
		cb.registerValue(c);
		Client c3 = cb.getValueFromID(0);
		System.out.println(c3.getName());
		System.out.println( cb.getIDfromClientName("Paul"));
		
	}

}
