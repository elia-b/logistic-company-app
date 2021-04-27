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
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
 Scenario: Succesful search for container status history
    Given a logistic company
    And a logged-in registered client "UserCompany81" "newwmail82@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "SPAIN" "ITALIA" "PAELLA" 1
    And a registered Container Status 123.2 12.3 124.2 at 1510232 
    And updating the Journey as finished 
    And a registered Journey with "ITALIA" "SPAIN" "PIZZE" 1
    And a registered Container Status 123.2 12.3 124.2 at 1511000  
    And updating the Journey as finished 
    And a registered Journey with "SPAIN" "ITALIA" "FISH" 1
    And a registered Container Status 123.2 12.3 124.2 at 1511500  
   	When searching for Container Status History
   	Then we get 3 container Statuses

@tag2
 Scenario: Succesful search for container journey history
    Given a logistic company
    And a logged-in registered client "UserCompany82" "newwmail82@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "SPAINA" "ITALIAA" "PAELLA" 1
    And updating the Journey as finished 
    And a registered Journey with "ITALIAA" "SPAINA" "PIZZE" 1
    And updating the Journey as finished 
    And a registered Journey with "SPAINA" "ITALIAA" "FISH" 1
   	When searching for Container Journey History
   	Then we get 3 journey ids
   	
   	
@tag3
 Scenario: Succesful search for container journey status history
    Given a logistic company
    And a logged-in registered client "UserCompany83" "newwmail83@gmail.com" "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "SPAINA" "ITALIAA" "PAELLA" 1
    And a registered Container Status 123.2 12.3 124.2 at 1510232 
    And updating the Journey as finished 
    And a registered Journey with "ITALIAA" "SPAINA" "PIZZE" 1
    And a registered Container Status 123.2 12.3 124.2 at 1511000  
    And updating the Journey as finished 
    And a registered Journey with "SPAINA" "ITALIAA" "FISH" 1
    And a registered Container Status 123.2 12.3 124.2 at 1511500  
   	When searching for Container Journey Status History 
   	Then we get 1 container Statuses
   	
   	
   	
   	