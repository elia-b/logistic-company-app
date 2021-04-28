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
Feature: Container Tracking 

  @tag1
   Scenario Outline: Container Status
    Given a logistic company
    And a logged-in registered client <name> <email> "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status <humidity> <temp> <press> at <time>
    When the client requests the latest status from journey
    Then the client <verb> container status

    Examples: 	
      | humidity  	|	 temp 		 | press 	| time   						| verb        | name		  | email 						 |
      | 35.0				|    17.1 	 | 500.4 	| 1510232         	| sees			  |  "Name71" | "name71@gmail.com" |
      | 212.0     	|    17.8	   | 500.4 	| 0              		| doesnt see  | "Name72"  | "name72@gmail.com" |

      

  @tag2
  Scenario: latest Container Status request by authorized client
    Given a logistic company
    And a logged-in registered client "UserCompany72" "newwmail72@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102322
    When the client requests the latest status from journey
    Then the client sees container status
    
  @tag7
  Scenario: latest Container Status request by authorized client
    Given a logistic company
    And a logged-in registered client "UserCompany72" "newwmail72@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102322 for a non existing Container
    When the client requests the latest status from journey
    Then the client doesnt see container status
    
 @tag5
  Scenario: latest Container Status request by authorized client for non exsisting journey
    Given a logistic company
    And a logged-in registered client "UserCompany72" "newwmail72@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102322
    When the client requests the latest status from journey -2
    Then the client doesnt see container status
    
 
    
 @tag6
  Scenario: closest Container Status request by authorized client for non exsisting journey
    Given a logistic company
    And a logged-in registered client "UserCompany72" "newwmail72@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102322
    When the client requests the status at the requested date 15102692 for journey -2
    Then the client doesnt see container status
    
  @tag3
  Scenario: Container Status request by unauthorized client
    Given a logistic company
    And a logged-in registered client "UserCompany73" "newwmail73@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a logged-in registered client "UserCompany74" "newwmail74@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Container Status 12.3 45.3 412.3 at 15102322
    When the client requests the latest status from journey
    Then the client doesnt see container status

  @tag4
  Scenario: Container Status request with date
    Given a logistic company
    And a logged-in registered client "UserCompany75" "newwmail75@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102522
    And a registered Container Status 12.4 45.4 412.4 at 15102622
    And a registered Container Status 12.5 45.5 412.5 at 15102722
    And a registered Container Status 12.6 45.6 412.6 at 15102822
    When the client requests the status at the requested date 15102692 for journey
    Then the client sees container status 15102722 12.5 45.5 412.5 
    
    

    
