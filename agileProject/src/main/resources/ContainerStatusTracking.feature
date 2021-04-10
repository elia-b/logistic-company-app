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
    When updating the Status to <humidity> <temp> <press> at <time>
    Then the container measurements are updated <result>

    Examples: 	
      | humidity  	|	 temp 		 | press 	| time   							| result         |
      | 35.0				|    17.1 	 | 500.4 	| "10:01:2021:12:03" 	| successfully   |
      | 5.0					|    17.8	   | 500.4 	| "10:01:2021:12"  		| unsuccessfully |

      

  @tag2
  Scenario: latest Container Status request by authorized client
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And updating the Status to 12.3 45.3 412.3 at "10:01:2021:12:03"
    When the client requests the latest status from journey
    Then the client sees container status 12.3 45.3 412.3 at "10:01:2021:12:03"
    
  @tag3
  Scenario: Container Status request by unauthorized client
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And a new logged-in registered client "UserCompany1" "newwmail1@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And updating the Status to 12.3 45.3 412.3 at "10:01:2021:12:03"
    When the client requests the latest status from journey
    Then the client doesnt see status

  @tag4
  Scenario: Container Status request be unauthorized client
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Lisboa" "Hamburg" "banana" 1
    And updating the Status to 12.3 45.3 412.3 at "10:01:2021:10:03"
    And updating the Status to 10.1 45.3 412.3 at "10:01:2021:11:30"
    And updating the Status to 12.3 45.3 412.3 at "10:01:2021:12:03"
    And updating the Status to 12.3 45.3 412.3 at "10:01:2021:13:03"
    When the client requests the status at "10:01:2021:11:30" for journey
    Then the client sees container status 10.1 45.3 412.3 at "10:01:2021:11:29"
