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
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "Company1" as name
    Then the client has name "Company1"
    
    
  @tag3  
  Scenario: Unsuccessful name update because name already taken
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered client "Company1" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "Company1" as name
    Then the client has name "UserCompany"
    
  @tag4
  Scenario: Successful e-mail update 
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "newwmail2@gmail.com" as e-mail
    Then the client has email "newwmail2@gmail.com"
    

    
  @tag6
  Scenario: Unsuccessful e-mail update because invalid e-mail
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "newmailgmail.com" as e-mail
    Then the client has email "newmail@gmail.com"
    
  @tag7
  Scenario: Unsuccessful e-mail update because e-mail already taken
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered client "Company1" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When the client updates "newwmail@gmail.com" as e-mail
    Then the client has email "newmail@gmail.com"
    
  @tag8
  Scenario: Successful reference person update
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Paul Paulson" as reference person
    Then the client has reference person "Paul Paulson"
    

  
  @tag10
  Scenario: Successful address update
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Lyngby 69 RoadStreet" as address
    Then the client has address "Lyngby 69 RoadStreet"
    


  @tag12
  Scenario: Unsuccessful address update because invalid address
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Lyngby 69" as address
    Then the client has address "Lyngby 69 RoadStreet"
    
  @tag13
  Scenario: Unsuccessful address update because invalid address
    Given a logistic company 
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"

    When the client updates "Lyngby RoadStreet" as address
    Then the client has address "Lyngby 69 RoadStreet"
