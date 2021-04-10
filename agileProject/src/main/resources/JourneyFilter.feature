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
Feature: Journey filtering by client

  @tag1
   Scenario Outline: Successful Journey Filter
    Given a logistic company
    And a registered Journey with "Roma" "Hamburg" "banana" 2
    And a registered Journey with "Hamburg" "Roma" "banana" 2
    And a registered Journey with "Lisboa" "Paris" "truffel" 2
    When filtering the Journey by <criteria> <string>
    Then the resulting JourneyID is <id>

    Examples: 
      | criteria  	|	 string 			| id |
      | Origin			|     "Roma" 	  | 0	 |
      | Origin			|     "Hamburg" | 1	 |
      | Destination	|     "Paris" 	| 2  |
      | Destination	|     "Roma" 		| 1  |
			| Content     | "truffel" 		| 2  |
			
	@tag2
	Scenario: Unsuccessful Journey Filter
		 Given a logistic company
    And a registered Journey with "Roma" "Hamburg" "banana" 2
    And a registered Journey with "Hamburg" "Roma" "banana" 2
    And a registered Journey with "Lisboa" "Paris" "truffel" 2
    When filtering the Journey by Origin "Rotterdam"
    Then the filtering results in nothing