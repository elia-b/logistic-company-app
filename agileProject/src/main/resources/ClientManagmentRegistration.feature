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
Feature: Client Managment registration functionalities

  @tag1
  Scenario: Successful registration of a new client by a company
    Given a logistic company
    And a client
    And pass "UserCompany" as name
    And pass "user.company@gmail.com" as e-mail
    And pass "Paul Paulson" as reference person
    And pass "Lyngby 69 RoadStreet" as address
    When register new client
    Then the registration is successful
    
  @tag2
  Scenario: Unsuccessful registration of a new client by a company because of invalid e-mail
    Given a logistic company
    And a client
    And pass "UserCompany" as name
    And pass "user.companygmail.com" as e-mail
    And pass "Paul Paulson" as reference person
    And pass "Lyngby 69 RoadStreet" as address
    When register new client
    Then the registration is unsuccessful
  
  @tag3
  Scenario: Unsuccessful registration of a new client by a company because of missing e-mail
    Given a logistic company
    And a client
    And pass "UserCompany" as name
    And pass "Paul Paulson" as reference person
    And pass "Lyngby 69 RoadStreet" as address
    When register new client
    Then the registration is unsuccessful
    
  @tag4
  Scenario: Unsuccessful registration of a new client by a company because of invalid address
    Given a logistic company
    And a client
    And pass "UserCompany" as name
    And pass "user.company@gmail.com" as e-mail
    And pass "Paul Paulson" as reference person
    And pass "Lyngby 69" as address
    When register new client
    Then the registration is unsuccessful
  
  @tag5
  Scenario: Unsuccessful registration of a new client by a company because of missing reference person
    Given a logistic company
    And a client
    And pass "UserCompany" as name
    And pass "user.company@gmail.com" as e-mail
    And pass "Lyngby 69 RoadStreet" as address
    When register new client
    Then the registration is unsuccessful
    
  @tag6
  Scenario: Unsuccessful registration of a new client by a company because of already taken name
    Given a logistic company
    And a registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a client
    And pass "UserCompany" as name
    And pass "user.company@gmail.com" as e-mail
    And pass "Paul Paulson" as reference person
    And pass "Lyngby 69 RoadStreet" as address
    When register new client
    Then the registration is unsuccessful
    
  @tag7
  Scenario: Unsuccessful registration of a new client by a company because of already taken e-mail
    Given a logistic company
    And a registered client "UserCompany2" "user.company@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a client
    And pass "UserCompany" as name
    And pass "user.company@gmail.com" as e-mail
    And pass "Paul Paulson" as reference person
    And pass "Lyngby 69 RoadStreet" as address
    When register new client
    Then the registration is unsuccessful
    
    
    