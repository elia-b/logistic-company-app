package agileProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;


import application.controller.ApplicationLogIn;
import application.model.AdminApplication;
import application.model.Client;
import application.model.ClientApplication;
import application.model.Container;
import application.model.ContainerStatus;
import application.model.Journey;
import application.model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
    LogisticCompany lc = LogisticCompany.GetInstance();
    //c1 is always the new client
    Client c1;
    //c2 is always the already registered client
    Client c2;
    //c3 is always the logged-in and registered client
    Client c3;

    Journey j;

    String response;

    AdminApplication aa = new AdminApplication(lc);
    ClientApplication ca;

    ArrayList<ContainerStatus> resultsStatus;

    ArrayList<Integer> results;

    int intResult;
    
    Container C;
    
    

	
    @Given("a logistic company")
    public void a_logistic_company() {
        assertNotEquals(null, lc);
    }
    
    @Given("a client {string} {string} {string} {string}")
    public void a_client(String name, String email, String contactPerson, String address) {
        c1 = new Client(name, email, address, contactPerson);
    }

    @When("register new client")
    public void register_new_client() {
        aa.register_new_client(c1);
    }

    @Then("the registration is successful")
    public void the_registration_is_successful() {
        assertFalse(lc.getDatabase().getIDfromClientName(c1.getName()) == -1);
    }

    @Then("the registration is unsuccessful")
    public void the_registration_is_unsuccessful() {
        assertTrue(lc.getDatabase().getIDfromClientName(c1.getName()) == -1);
    }


    @Given("a registered client {string} {string} {string} {string}")
    public void a_registered_client(String name, String email, String contactPerson, String address ) {
        c2.setName(name);
        c2.setAddress(address);
        c2.setEmail(email);
        c2.setContactPerson(contactPerson);
        aa.register_new_client(c2);
        }
    }
    
    @Given("a logged-in registered client {string} {string} {string} {string}")
    public void a_logged_in_registered_client(String name, String email, String contactPerson, String address) {
    	c3.setName(name);
        c3.setAddress(address);
        c3.setEmail(email);
        c3.setContactPerson(contactPerson);
        aa.register_new_client(c3);
        ca = new ClientApplication(lc.getDatabase().getIDfromClientName(c3.getName()), lc);
    }

    @When("the client updates {string} as name")
    public void the_client_updates_as_name(String name) {
        ca.updateName(name);
    }

    @Then("the client has name {string}")
    public void the_client_has_name(String name) {
        assertEquals(c3.getName(),name);
    }

    @When("the client updates {string} as e-mail")
    public void the_client_updates_as_e_mail(String email) {
    	ca.updateEmail(email);
    }

    @Then("the client has email {string}")
    public void the_client_has_email(String email) {
    	assertEquals(c3.getEmail(),email);
    }
    

    @When("the client updates {string} as reference person")
    public void the_client_updates_as_reference_person(String rp) {
    	ca.updateContactPerson(rp);
    }

    @Then("the client has reference person {string}")
    public void the_client_has_reference_person(String rp) {
        assertEquals(c3.getReferencePerson(), rp);
    }	

    @When("the client updates {string} as address")
    public void the_client_updates_as_address(String address) {
        ca.updateAdress(address);
    }
 
    @Then("the client has address {string}")
    public void the_client_has_address(String address) {
        assertEquals(c3.getAddress(),address);
    }
    
    @When("the client updates {string} as password")
    public void the_client_updates_as_password(String password) {
        ca.updatePassword(password);
    }

    @Then("the client has password {string}")
    public void the_client_has_password(String password) {
    	 assertEquals(c3.getPassword(),password);
    }

    
    @When("pass {string} as name search")
    public void pass_as_name_search(String name) {
        intResult = aa.searchName(name);
        
    }

    @Then("successful search")
    public void successful_search() {
        assertEquals(intResult, lc.getDatabase().getIDfromClientName(c2.getName()));
    }

 

    @Then("unsuccessful search")
    public void unsuccessful_search() {
        assertEquals(-1, intResult);
    }

    @When("pass {string} as e-mail search")
    public void pass_as_e_mail_search(String email) {
        intResult = aa.searchEmail(email);
    }


//M2 Journey Registration

    @Given("a Journey with {string} {string} {string} {int}")
    public void a_Journey_with(String origin, String destination, String content, int number) {
        j = new Journey(origin, destination, content, number);

    }

    @When("register a Journey")
    public void register_a_Journey() {
        ca.registerJourney(j);

    }

    //size is not SOLID
    @Then("the journey registration was succesful")
    public void the_journey_registration_was_succesful() {
        assertTrue(lc.getJourneys().size() == 1);
    }

    @Then("the journey registration was unsuccesful")
    public void the_journey_registration_was_unsuccesful() {
        assertTrue(lc.getJourneys().size() == 0);
    }

    @Given("{int} containers at {string}")
    public void containers_at(Integer numberOfContainers, String location) {
    	C = new Container(location);
        aa.registerContainer(C);
    }
    
    @Given("a registered Journey with {string} {string} {string} {int}")
    public void a_registered_Journey_with(String origin, String destination, String content, int number) {
        ca.registerJourney(origin, destination, content, number);
    }

    @When("updating the Journey to {string}")
    public void updating_the_Journey_to(String newlocation) {
        aa.updateJourney(0, newlocation);
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
        assertTrue(results.get(0) == id);
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
        aa.finishJourney(0);
    }

    @When("updating the Status to {float} {float} {float} at {string}")
    public void updating_the_Status_to_at(float hum, float temp, float press, String time) {
        aa.updateStatus(0, hum, temp, press, time);
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
