#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Journey update by logistics Company


  @tag1
   Scenario Outline: Journey Update
    Given a logistic company
    And a logged-in registered client "UserCompany51" "newwmail51@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with <origin> "Hamburg" "banana" 2
    When updating the Journey to <newlocation>
    Then the containers in the journey have location <location> 

    Examples: 
      | origin  	|	 newlocation | location |
      | "Lisboa"	|     "Roma" 	 | "Roma"     	|
      | "Roma" 		|     "123123" | "Roma"      |

      
	@tag2
		Scenario: Successful Journey Finish
		 Given a logistic company
		 And a logged-in registered client "UserCompany52" "newwmail52@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
		 And a registered Journey with "Lisboa" "Hamburg" "banana" 2
		 When updating this Journey as finished
		 Then the containers in the journey have the destination as location
		 
@tag3
		Scenario: Unsuccessful Journey Update because journey doesnt exist
		 Given a logistic company
		 And a logged-in registered client "UserCompany52" "newwmail52@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
		 And a registered Journey with "Lisboa" "Hamburg" "banana" 2
		 When updating a non existing Journey 
		 Then the containers in the journey have location "Lisboa" 
		 
@tag4
		Scenario: Unsuccessful Journey finish because journey doesnt exist
		 Given a logistic company
		 And a logged-in registered client "UserCompany52" "newwmail52@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
		 And a registered Journey with "Lisboa" "Hamburg" "banana" 2
		 When updating a non existing Journey as finished
		 Then the containers in the journey have location "Lisboa" 