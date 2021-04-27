package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import application.model.database.IData;

@Entity
public class Client implements User, IData{
	private String password;
    private String name; 
    private String email; 
    private String address;
    private String contactPerson;
    @Id
    private int clientID;
    
    public Client() {
    	
    }

	  public Client (String name, String email, String address, String contactPerson){
	      this.name = name;
	      this.email = email;
	      this.address = address;
	      this.contactPerson = contactPerson;
	      this.clientID = -2;
	  }

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setContactPerson(String contactPerson){
        this.contactPerson = contactPerson;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAddress(){
        return this.address;
    }
    public String getReferencePerson(){
        return this.contactPerson;
    }

	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return this.name;
	}
	public void setPassword(String password) {
		this.password= password;
	}

    @Override
    public int getID() {
        return this.clientID;
    }

    @Override
    public void setID(int id) {
        this.clientID = id;
        
    }
	
    
    
}
