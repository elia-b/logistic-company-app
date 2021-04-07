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
Feature: Track the internal status of container

  @tag1
  Scenario: Successful tracking the internal temperature
    Given a container with number 403
    And a internal temperature 60 from a previous journey
    When logistic company add the temperature to the system
    Then the clients should be able to see the container 
 @tag1
  Scenario: Successful tracking the internal air humidity
    Given a container with number 403
    And internal air humidity 50 from a previous journey
    When logistic company add the air humidity to the system
    Then the clients should be able to see the container 
 @tag3
  Scenario: Successful tracking the atmospheric pressure
    Given a container with number 403
    And  atmospheric pressure 40 from a previous journey
    When logistic company add the atmospheric pressure to the system
    Then the clients should be able to see the container 
 
 