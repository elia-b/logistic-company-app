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
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a Container Status <humidity> <temp> <press> at <time>
    When updating the Status
    Then the container measurements are updated <result>

    Examples: 	
      | humidity  	|	 temp 		 | press 	| time   							| result         |
      | 35.0				|    17.1 	 | 500.4 	| 1510232         	| successfully   |
      | 5.0					|    17.8	   | 500.4 	| 0              		| unsuccessfully |

      

  @tag2
  Scenario: latest Container Status request by authorized client
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102322
    When the client requests the latest status from journey
    Then the client sees container status
    
  @tag3
  Scenario: Container Status request by unauthorized client
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a new logged-in registered client "UserCompany1" "newwmail1@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Container Status 12.3 45.3 412.3 at 15102322
    When the client requests the latest status from journey
    Then the client doesnt see status

  @tag4
  Scenario: Container Status request be unauthorized client
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a registered Container Status 12.3 45.3 412.3 at 15102522
    And a registered Container Status 12.3 45.3 412.3 at 15102622
    And a registered Container Status 12.3 45.3 412.3 at 15102722
    And a registered Container Status 12.3 45.3 412.3 at 15102822
    And a request date 15102692
    When the client requests the status at the requested date for journey
    Then the client sees container status clooser to the requested date
