package agileProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
    //int jID;

    String response;

    AdminApplication aa = new AdminApplication(lc);
    ClientApplication ca;

    List<ContainerStatus> resultsStatus;

    List<Journey> results;

    int intResult;
    
    Container C;
    
    List<ContainerStatus> cs;
    
    List<Integer> cj;

	
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
        assertFalse(lc.getClientDatabase().getIDfromClientName(c1.getName()) == -1);
    }

    @Then("the registration is unsuccessful")
    public void the_registration_is_unsuccessful() {
    	
        assertEquals(c1.getID(), -2);
    }


    @Given("a registered client {string} {string} {string} {string}")
    public void a_registered_client(String name, String email, String contactPerson, String address ) {
    	c2 = new Client(name,email,address,contactPerson);
        
        aa.register_new_client(c2);
    }
    
    @Given("a logged-in registered client {string} {string} {string} {string}")
    public void a_logged_in_registered_client(String name, String email, String contactPerson, String address) {
    	c3 = new Client(name,email,address,contactPerson);
        aa.register_new_client(c3);
        ca = new ClientApplication(lc.getClientDatabase().getIDfromClientName(c3.getName()), lc);
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
        assertEquals(intResult, lc.getClientDatabase().getIDfromClientName(c2.getName()));
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
        j = new Journey(content,origin, destination, number, ca.getClientID());
     //   jID = lc.getJourneys().size();

    }

    @When("register a Journey")
    public void register_a_Journey() {
    	ca.registerJourney(j);
       
        

    }

    
    @Then("the journey registration was succesful")
    public void the_journey_registration_was_succesful() {
    	
        assertTrue(lc.getJourneys().getValueFromID(j.getID()).equals(j));
    }

    @Then("the journey registration was unsuccesful")
    public void the_journey_registration_was_unsuccesful() {
        assertFalse(lc.getJourneys().getValueFromID(j.getID()).equals(j));
    }

    @Given("{int} containers at {string}")
    public void containers_at(Integer numberOfContainers, String location) {
    	for(int i = 0;i<numberOfContainers;i++) {
    		C = new Container(location);
            aa.registerContainer(C);
    	}
    	
    }
    
    @Given("a registered Journey with {string} {string} {string} {int}")
    public void a_registered_Journey_with(String origin, String destination, String content, int number) {
    	for(int i = 0;i<number;i++) {
    		C = new Container(origin);
            aa.registerContainer(C);
    	}
    	j = new Journey(content,origin, destination,  number, ca.getClientID());
        ca.registerJourney(j);
    }

    @When("updating the Journey to {string}")
    public void updating_the_Journey_to(String newlocation) {
        aa.updateJourney(j.getID(), newlocation);
    }

    @Then("the containers in the journey have location {string}")
    public void the_containers_in_the_journey_have_location(String location) {
    	
        assertTrue(location.equals(lc.getContainers().containerOnJourney(j.getID()).get(0).getLocation()));
    }
 
    @When("filtering the Journey by Origin {string}")
    public void filtering_the_Journey_by_Origin(String origin) {
        results = ca.filterJourneysbyOrigin(origin);
    }

    @Then("we find {int} Journeys")
    public void the_resulting_JourneyID_is(int size ) {
        assertTrue(results.size() == size);
    }


    @When("filtering the Journey by Destination {string}")
    public void filtering_the_Journey_by_Destination(String destination) {
    	results = ca.filterJourneysbyDestination(destination);
    }


    @When("filtering the Journey by Content {string}")
    public void filtering_the_Journey_by_Content(String content) {
    	results = ca.filterJourneysbyContent(content);
    }

    @When("updating this Journey as finished")
    public void updating_this_Journey_as_finished() {
        aa.finishJourney(j.getID());
    }
   
    @Given("updating the Journey as finished")
    public void updating_the_Journey_as_finished() {
        aa.finishJourney(j.getID());
    }
    
    @Then("the containers in the journey have the destination as location")
    public void the_containers_in_the_journey_have_the_destination_as_location() {

    	assertTrue(j.getDestination().equals(C.getLocation()));
    }
//Journey feature done, now Container Status
    @Given("a registered Container Status {double} {double} {double} at {int}")
    public void a_registered_Container_Status_at(double hum, double temp, double press, int date) {
        aa.updateStatus(lc.getContainers().containerOnJourney(j.getID()).get(0).getID(),(float) hum,(float) temp,(float) press,(long) date);
       
    }


    @Then("the client sees container status")
    public void the_client_sees_container_status() {
        assertTrue(cs.size()>0);
    }



    @Then("the client doesnt see container status")
    public void the_client_doesnt_see_container_status() {
    	assertTrue(cs.size()==0);
    }


    @When("the client requests the latest status from journey")
    public void the_client_requests_the_latest_status_from_journey() {
        cs = ca.getLatestStatus(j.getID());
    }


    @When("the client requests the status at the requested date {int} for journey")
    public void the_client_requests_the_status_at_the_requested_date_for_journey(int date) {
        cs = ca.getclosestStatus(j.getID(),(long) date);
    }
    @Then("the client sees container status {int}")
    public void the_client_sees_container_status(Integer date) {
    	assertEquals(cs.get(0).getDate(),(long) date);
    }
    
    @When("searching for Container Status History")
    public void searching_for_Container_Status_History() {
        try {
			cs = aa.searchContainerHistory(lc.getContainers().containerOnJourney(j.getID()).get(0).getID());
		} catch (Exception e) {
			cs = new ArrayList<ContainerStatus>();
		}
    }

    @Then("we get {int} container Statuses")
    public void we_get_container_Statuses(int size) {
        assertEquals(cs.size(),size);
    }

    @When("searching for Container Journey History")
    public void searching_for_Container_Journey_History() {
        try {
			cj = aa.getJourneyIDsfromContainerHistory(lc.getContainers().containerOnJourney(j.getID()).get(0).getID());
		} catch (Exception e) {
			cj = new ArrayList<Integer>();
		}
    }

    @Then("we get {int} journey ids")
    public void we_get_journey_ids(int size) {
    	assertEquals(cj.size(),size);
    }

    @When("searching for Container Journey Status History")
    public void searching_for_Container_Journey_Status_History() {
    	try {
    		
			cs = aa.getStatusesFromContainerOnJourney(lc.getContainers().containerOnJourney(j.getID()).get(0).getID(),j.getID());
		} catch (Exception e) {
			cs = new ArrayList<ContainerStatus>();
		}
    }




    
}
