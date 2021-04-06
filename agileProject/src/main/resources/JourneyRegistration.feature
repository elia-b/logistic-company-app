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
Feature: Journey Registrations
  

  @tag1
  Scenario: Succesful Joruney Registration
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When register a Journey with "Hamburg" "Copenhagen" "Google" 
    Then the journey registration was succesful

  @tag2
  Scenario Outline: Unsuccesful Journey Registration
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    When register a Journey with <origin> <destination>  <Company> 
    Then the journey registration was unsuccesful

    Examples: 
      | origin       | destination      | Company  |
      | "135235"     |     "Copenhagen" | "Google" |
      | "Copenhagen" |     "7"          | "Google" |
