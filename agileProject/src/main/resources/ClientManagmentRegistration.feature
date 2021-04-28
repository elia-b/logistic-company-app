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
  Scenario Outline: Registration of a new client by a company
    Given a logistic company
    And a client <name> <email> <contactperson> <address>
    When register new client
    Then the registration is <status>

    Examples: 
      | name               |       email                 | contactperson  |address                 | status       |
      | "UserCompany"      |  "user.company@gmail.com"   | "Paul Paulson" | "Lyngby 69 RoadStreet" | successful   |
      | "UserCompany1"     |  "user.companygmail.com"    | "Paul Paulson" | "Lyngby 69 RoadStreet" | unsuccessful |
      | "UserCompany2"     |  "user.company@gmail.com"   | "Paul Paulson" | "Lyngby 69"            | unsuccessful |

    
  @tag2
  Scenario: Unsuccessful registration of a new client by a company because of already taken name
    Given a logistic company
    And a registered client "UserCompany3" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a client "UserCompany3" "user.company2@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    Then the registration is unsuccessful
    
  @tag3
  Scenario: Unsuccessful registration of a new client by a company because of already taken e-mail
    Given a logistic company
    And a registered client "UserCompany4" "newwmail2@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a client "NewUserCompany" "newwmail2@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    Then the registration is unsuccessful
    
    
    