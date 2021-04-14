package agileProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import application.controller.AdminApplication;
import application.controller.ApplicationLogIn;
import application.controller.ClientApplication;
import application.model.Client;
import application.model.ContainerStatus;
import application.model.Journey;
import application.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
    LogisticCompany lc = new LogisticCompany();
    Client c1 = new Client();
    ApplicationLogIn al = new ApplicationLogIn(lc);
    Client c2 = new Client();
    Client c5 = new Client();
    int search;
    ClientApplication ca;
    String email;
    String name;
    String rp;
    String address;
    ArrayList<ContainerStatus> resultsStatus;

    ArrayList<Integer> results;
    
    

	
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
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            aa.register_new_client(c1);
        }
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
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            aa.register_new_client(c2);
        }
    }
    
    @Given("a logged-in registered client {string} {string} {string} {string}")
    public void a_logged_in_registered_client(String name, String email, String contactPerson, String address) {
    	c5.setName(name);
        c5.setAddress(address);
        c5.setEmail(email);
        c5.setContactPerson(contactPerson);
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            aa.register_new_client(c5);
        }
        al.logIn(c5.getUsername(), c5.getPassword());
        if (al.getapp() instanceof ClientApplication){
            ca = (ClientApplication) al.getapp();
        }
        
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
    
    @When("the client updates {string} as password")
    public void the_client_updates_as_password(String password) {
        ca.updatePassword(password);
    }

    @Then("the client has password {string}")
    public void the_client_has_password(String password) {
    	 assertEquals(c5.getPassword(),password);
    }

    
    @When("pass {string} as name search")
    public void pass_as_name_search(String name) {
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            search = aa.searchName(name);
        }
        
    }

    @Then("successful search")
    public void successful_search() {
        assertEquals(search,lc.getDatabase().getIDfromClientName(c2.getName()));
    }

 

    @Then("unsuccessful search")
    public void unsuccessful_search() {
        assertEquals(-1,search);
    }

    @When("pass {string} as e-mail search")
    public void pass_as_e_mail_search(String email) {
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            search = aa.searchEmail(email);
        }
        
    }
//M2 Journey Registration
    



    @When("register a Journey with {string} {string} {string} {int}")
    public void register_a_Journey_with(String origin, String destination, String content, int number) {
        ca.registerJourney(origin, destination, content, number);
        

    }

    @Then("the journey registration was succesful")
    public void the_journey_registration_was_succesful() {
    	
    	
        assertTrue(lc.getJourneys().size()==1);
    }

    

    @Then("the journey registration was unsuccesful")
    public void the_journey_registration_was_unsuccesful() {
        assertTrue(lc.getJourneys().size()==0);
    }

    @Given("{int} containers at {string}")
    public void containers_at(Integer numberOfContainers, String location) {
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            for (int i = 0;i<numberOfContainers;i++) {
                aa.registerContainer(location);
            }
        }
        
        
    	
    }
    
    @Given("a registered Journey with {string} {string} {string} {int}")
    public void a_registered_Journey_with(String origin, String destination, String content, int number) {
    	 al.logIn(lc.getUsername(), lc.getPassword());
         if (al.getapp() instanceof AdminApplication){
             AdminApplication aa = (AdminApplication) al.getapp();
	    	for (int i = 0;i<number;i++) {
	        	aa.registerContainer(origin);
	        }
	    	c5.setName("UserCompany");
	        c5.setAddress("Lyngby 69 RoadStreet");
	        c5.setEmail("newwmail@gmail.com");
	        c5.setContactPerson("Paul Paulson");
	        aa.register_new_client(c5);
	        ca = new ClientApplication(lc.getDatabase().getIDfromClientName(c5.getName()), lc);
	    	ca.registerJourney(origin, destination, content, number);
         }
    }

    @When("updating the Journey to {string}")
    public void updating_the_Journey_to(String newlocation) {
    	 al.logIn(lc.getUsername(), lc.getPassword());
         if (al.getapp() instanceof AdminApplication){
             AdminApplication aa = (AdminApplication) al.getapp();
             aa.updateJourney(0, newlocation);
         }
    }

    @Then("the containers in the journey have {string}")
    public void the_containers_in_the_journey_have(String location) {
        assertTrue(location.equals(lc.getJourneys().getValueFromID(0).getContainers().get(0).getLocation()));
    }
 
    @When("filtering the Journey by Origin {string}")
    public void filtering_the_Journey_by_Origin(String origin) {
        results = ca.filterJourneysbyOrigin(origin);
    }

    @Then("the resulting JourneyID is {int}")
    public void the_resulting_JourneyID_is(Integer id) {
        assertTrue(results.get(0)==id);
    }


    @When("filtering the Journey by Destination {string}")
    public void filtering_the_Journey_by_Destination(String destination) {
    	results = ca.filterJourneysbyDestination(destination);
    }


    @When("filtering the Journey by Content {string}")
    public void filtering_the_Journey_by_Content(String content) {
    	results = ca.filterJourneysbyContent(content);
    }

  

    @Then("the filtering results in nothing")
    public void the_filtering_results_in_nothing() {
        assertTrue(results.isEmpty());
    }
   
    @When("updating the Journey as finished")
    public void updating_the_Journey_as_finished() {
    	 al.logIn(lc.getUsername(), lc.getPassword());
         if (al.getapp() instanceof AdminApplication){
             AdminApplication aa = (AdminApplication) al.getapp();
             aa.finishJourney(0);
         }
    }

    @When("updating the Status to {float} {float} {float} at {string}")
    public void updating_the_Status_to_at(float hum, float temp, float press, String time) {
    	 al.logIn(lc.getUsername(), lc.getPassword());
         if (al.getapp() instanceof AdminApplication){
             AdminApplication aa = (AdminApplication) al.getapp();
             aa.updateStatus(0, hum, temp, press, time);
         }
    }


    @Then("the container measurements are updated successfully")
    public void the_container_measurements_are_updated_successfully() {
        assertFalse(lc.getJourneys().getValueFromID(0).getContainers().get(0).getStatus().isEmpty());
    }


    @Then("the container measurements are updated unsuccessfully")
    public void the_container_measurements_are_updated_unsuccessfully() {
    	assertTrue(lc.getJourneys().getValueFromID(0).getContainers().get(0).getStatus().isEmpty());
    }

    @When("the client requests the latest status from journey")
    public void the_client_requests_the_latest_status_from_journey() {
        resultsStatus = ca.getLatestStatus(0);
    }

    @Then("the client sees container status {float} {float} {float} at {string}")
    public void the_client_sees_container_status_at(float hum, float temp, float press, String time) {
        assertTrue(hum == resultsStatus.get(0).getHumidity());
        assertTrue(press == resultsStatus.get(0).getPressure());
        assertTrue(temp == resultsStatus.get(0).getTemperature());
    }


    @Then("the client doesnt see status")
    public void the_client_doesnt_see_status() {
    	System.out.println(lc.getDatabase().getValueFromID(0).getName());
    	System.out.println(lc.getDatabase().getValueFromID(1).getName());
        assertTrue(resultsStatus.isEmpty());
    }

    @When("the client requests the status at {string} for journey")
    public void the_client_requests_the_status_at_for_journey(String date) {
        resultsStatus=ca.getclosestStatus(0, date);
    }
    
    @Given("a new logged-in registered client {string} {string} {string} {string}")
    public void a_new_logged_in_registered_client(String name, String email, String contactPerson, String address) {
    	c2.setName(name);
        c2.setAddress(address);
        c2.setEmail(email);
        c2.setContactPerson(contactPerson);
        al.logIn(lc.getUsername(), lc.getPassword());
        if (al.getapp() instanceof AdminApplication){
            AdminApplication aa = (AdminApplication) al.getapp();
            aa.register_new_client(c2);
        }
        al.logIn(c2.getUsername(), c2.getPassword());
        if (al.getapp() instanceof ClientApplication){
            ca = (ClientApplication) al.getapp();
        }
    }
	
    
}
