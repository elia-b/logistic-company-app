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
Feature: Client Managment update functionalities

  @tag1
  Scenario: Successful name update
    Given a logistic company 
    And a logged-in registered client "UserCompany21" "newwmail21@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "Company21" as name
    Then the client has name "Company21"
    
    
  @tag3  
  Scenario: Unsuccessful name update because name already taken
    Given a logistic company 
    And a logged-in registered client "UserCompany23" "newemail23@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered client "Company23" "newwmail23@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "Company23" as name
    Then the client has name "UserCompany23"
    
  @tag4
  Scenario: Successful e-mail update 
    Given a logistic company 
    And a logged-in registered client "UserCompany24" "newmail24@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "newwmail24@gmail.com" as e-mail
    Then the client has email "newwmail24@gmail.com"
    

    
  @tag6
  Scenario: Unsuccessful e-mail update because invalid e-mail
    Given a logistic company 
    And a logged-in registered client "UserCompany25" "newmail25@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "newmail25gmail.com" as e-mail
    Then the client has email "newmail25@gmail.com"
    
  @tag7
  Scenario: Unsuccessful e-mail update because e-mail already taken
    Given a logistic company 
    And a logged-in registered client "UserCompany27" "newmail27@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered client "Company27" "newwmail27@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "newwmail27@gmail.com" as e-mail
    Then the client has email "newmail27@gmail.com"
    
  @tag8
  Scenario: Successful reference person update
    Given a logistic company 
    And a logged-in registered client "UserCompany28" "newwmail28@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Paul Paulson" as reference person
    Then the client has reference person "Paul Paulson"
    

  
  @tag10
  Scenario: Successful address update
    Given a logistic company 
    And a logged-in registered client "UserCompany29" "newwmail29@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Lyngby 69 RoadStreet" as address
    Then the client has address "Lyngby 69 RoadStreet"
    


  @tag12
  Scenario: Unsuccessful address update because invalid address
    Given a logistic company 
    And a logged-in registered client "UserCompany212" "newwmail212@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Lyngby 69" as address
    Then the client has address "Lyngby 69 RoadStreet"
    
  @tag13
  Scenario: Unsuccessful address update because invalid address
    Given a logistic company 
    And a logged-in registered client "UserCompany213" "newwmail213@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Lyngby RoadStreet" as address
    Then the client has address "Lyngby 69 RoadStreet"
    
  @tag14
  Scenario: Successful password update
    Given a logistic company 
    And a logged-in registered client "UserCompany214" "newwmail214@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "123456789" as password
    Then the client has password "123456789"
    
  
