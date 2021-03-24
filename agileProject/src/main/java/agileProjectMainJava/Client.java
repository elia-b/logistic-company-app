package agileProjectMainJava;

public class Client {
    private String name; 
    private String email; 
    private String address; 
    private String contactPerson;
    private boolean registered = false;

    // // public Client (String name, String email, String address, String contactPerson){
    // //     this.name = name;
    // //     this.email = email;
    // //     this.address = address;
    // //     this.contactPerson = contactPerson;
    // // }

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

    public boolean getRegistered(){
        return this.registered;
    }

    public void register(){
        this.registered = true;
    }

    public void unregister(){
        this.registered = false;
    }
}
