package agileProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import agileProjectMainJava.AdminApplication;
import agileProjectMainJava.Client;
import agileProjectMainJava.ClientApplication;
import agileProjectMainJava.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
    LogisticCompany lc = new LogisticCompany();
    Client c1 = new Client();
    AdminApplication aa = new AdminApplication(lc);
    
    
    Client c2 = new Client();
    Client c5 = new Client();
    
    ClientApplication ca;
    String email;
    String name;
    String rp;
    String address;
	
    @Given("a logistic company")
    public void a_logistic_company() {
        assertNotEquals(null, lc);
    }
    
    @Given("a client")
    public void a_client() {
        c1.unregister();
        c1.setAddress(null);
        c1.setContactPerson(null);
        c1.setEmail(null);
        c1.setName(null);
    }

    @Given("pass {string} as name")
    public void pass_as_name(String name) {
        c1.setName(name);
    }

    @Given("pass {string} as e-mail")
    public void pass_as_e_mail(String email) {
        c1.setEmail(email);
    }

    @Given("pass {string} as reference person")
    public void pass_as_reference_person(String contactPerson) {
        c1.setContactPerson(contactPerson);
    }

    @Given("pass {string} as address")
    public void pass_as_address(String address) {
        c1.setAddress(address);
    }

    @When("register new client")
    public void register_new_client() {
        aa.register_new_client(c1);
    }

    @Then("the registration is successful")
    public void the_registration_is_successful() {
        assertTrue(c1.getRegistered());
    }

    @Then("the registration is unsuccessful")
    public void the_registration_is_unsuccessful() {
        assertFalse(c1.getRegistered());
    }


    @Given("a registered client {string} {string} {string} {string}")
    public void a_registered_client(String name, String email, String contactPerson, String address ) {
        c2.setName(name);
        c2.setAddress(address);
        c2.setEmail(email);
        c2.setContactPerson(contactPerson);
        aa.register_new_client(c2);
    }
    
    @Given("a logged-in registered client {string} {string} {string} {string}")
    public void a_logged_in_registered_client(String name, String email, String contactPerson, String address) {
    	c5.setName(name);
        c5.setAddress(address);
        c5.setEmail(email);
        c5.setContactPerson(contactPerson);
        aa.register_new_client(c5);
        ca = new ClientApplication(lc.getDatabase().getIDfromClientName(c5.getName()), lc);
    }

    @When("the client updates {string} as name")
    public void the_client_updates_as_name(String name) {
        ca.updateName(name);
    }

    @Then("the client has name {string}")
    public void the_client_has_name(String name) {
    	//c5 is always the logged-in client
        assertEquals(c5.getName(),name);
    }

    @When("the client updates {string} as e-mail")
    public void the_client_updates_as_e_mail(String email) {
    	ca.updateEmail(email);
    }

    @Then("the client has email {string}")
    public void the_client_has_email(String email) {
    	assertEquals(c5.getEmail(),email);
    }

    @When("the client updates {string} as reference person")
    public void the_client_updates_as_reference_person(String rp) {
    	ca.updateContactPerson(rp);
    }

    @Then("the client has reference person {string}")
    public void the_client_has_reference_person(String rp) {
        assertEquals(c5.getReferencePerson(), rp);
    }	

    @When("the client updates {string} as address")
    public void the_client_updates_as_address(String address) {
        ca.updateAdress(address);
    }

    @Then("the client has address {string}")
    public void the_client_has_address(String address) {
        assertEquals(c5.getAddress(),address);
    }


    

    
}
