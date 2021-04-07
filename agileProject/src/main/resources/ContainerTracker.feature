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
  Scenario: Successful update of temperature
    Given a container with id 5
    And a measured temperature of 40 
    When logistic company updates the temperature
    Then new temperature becomes available 
    And temperature history is updated
  @tag2
  Scenario: Succesful update of pressure
    Given a container with id 5
    And a measured pressure of 40 
    When logistic company updates the pressure
    Then new pressure becomes available 
    And pressure history is updated
  @tag3
  Scenario: Succesful update of humidity
    Given a container with id 5
    And a measured humidity of 40 
    When logistic company updates the humidity
    Then new humidity becomes available 
    And humidity history is updated

  @tag4
  Scenario: Succesful client retrieval of current values
    Given a client 
    And a request for all current values
    When client has containers in journeys
    Then all current measurements for their containers are provided
  
  @tag5
  Scenario: Succesful retrieval of containers currently above certain temperature
    Given a client
    And a maximum temperature 40
    When client has containers in journeys
    Then all instances of clients containers exceeding maximum temperature 40 is returned

  @tag6
  Scenario: Succesful retrieval of containers currently below certain temperature
    Given a client
    And a minimum temperature 0
    When client has containers in journeys
    Then all instances of clients containers exceeding minimum temperature 0 is returned

  @tag7
  Scenario: Succesful retrieval of containers currently above certain pressure
    Given a client
    And a maximum pressure 40
    When client has containers in journeys
    Then all instances of clients containers exceeding maximum pressure 40 is returned

  @tag8
  Scenario: Succesful retrieval of containers currently below certain pressure
    Given a client
    And a minimum pressure 10
    When client has containers in journeys
    Then all instances of clients containers exceeding minimum pressure 0 is returned

  @tag9
  Scenario: Succesful retrieval of containers currently above certain humidity
    Given a client
    And a maximum humidity 40
    When client has containers in journeys
    Then all instances of clients containers exceeding maximum humidity 40 is returned

  @tag10
  Scenario: Succesful retrieval of containers currently below certain humidity
    Given a client
    And a minimum humidity 30
    When client has containers in journeys
    Then all instances of clients containers exceeding minimum humidity 30 is returned

  @tag11
  Scenario: Succesful retrieval of container history
    Given a client
    And a request for container history
    When client has containers in journeys
    Then the full history of all the clients containers is returned