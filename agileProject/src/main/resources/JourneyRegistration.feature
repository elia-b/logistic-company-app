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
    And 3 containers at "Hamburg"
    And a Journey with "Hamburg" "Copenhagen" "banana" 3
    When register a Journey
    Then the journey registration was succesful

  @tag2
  Scenario Outline: Unsuccesful Journey Registration
    Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And 2 containers at <origin>
    And a Journey with <origin> <destination> <Content> 2
    When register a Journey
    Then the journey registration was unsuccesful

    Examples: 
      | origin       | destination      | Content  |
      | "135235"     |     "Copenhagen" | "apple" |
      | "Copenhagen" |     "7"          | "beer" |

  @tag3
  Scenario: Unsuccesful Journey Registration not enough Containers
  	Given a logistic company
    And a logged-in registered client "UserCompany" "newwmail@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And 2 containers at "Hamburg"
    And a Journey with "Hamburg" "Copenhagen" "banana" 3
    When register a Journey
    Then the journey registration was unsuccesful