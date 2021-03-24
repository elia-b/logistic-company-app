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
Feature: Client Managment search functionalities

  @tag1
  Scenario Outline: Name search
    Given a logistic company
    And a registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When pass <name> as name search
    Then <status> search
    
    Examples: 
      | name              | status       |
      | "UserCompany"     | successful   |
      | "NotUserCompany"  | unsuccessful |
    
  @tag2
  Scenario Outline: E-mail search
    Given a logistic company
    And a registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When pass <e-mail> as e-mail search
    Then <status> search
    
    Examples: 
      | e-mail                 | status       |
      | "newwmail@gmail.com"   | successful   |
      | "Notnewwmail@gmail.com"| unsuccessful |


