package application.model;

public class Client implements User{
	private String password;
    private String name; 
    private String email; 
    private String address;
    private String contactPerson;
    private int clientID;

      public Client (String name, String email, String address, String contactPerson){
          this.name = name;
          this.email = email;
          this.address = address;
          this.contactPerson = contactPerson;
      }

    public void setCLientID(int clientID){
        this.clientID = clientID;
    }

    public int getClientID(){
        return this.clientID;
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
	
    
    
}
