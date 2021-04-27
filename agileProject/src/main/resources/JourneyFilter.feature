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
    And a logged-in registered client <name> <email> "Paul Paulson" "Lyngby 69 RoadStreet"
    And a registered Journey with "Origin" "Destination" "Content" 2
    And a registered Journey with "Origin" "DestinationB" "Content" 2
    And a registered Journey with "OriginB" "Destination" "ContentB" 2
    When filtering the Journey by <criteria> <string>
    Then we find <number> Journeys

    Examples: 
      | criteria  	|	 string 			| number | name | email  |
      | Origin			|     "Origin" 	| 2	 	   | "Name61" | "name61@gmai.com" |
      | Origin			|     "OriginB" | 1	     |"Name62" | "name62@gmai.com"  |
      | Origin			|   "OriginC"   | 0      |"Name63" | "name63@gmai.com"  |
      | Destination	|"Destination" 	| 2      |"Name64" | "name64@gmai.com"  |
      | Destination	|"DestinationB" | 1      |"Name65" | "name65@gmai.com"  |
      | Destination	|"DestinationC" | 0      |"Name66" | "name66@gmai.com"  |
			| Content     | "ContentC" 		| 0      |"Name67" | "name67@gmai.com"  |
			| Content     | "ContentB" 		| 1      |"Name68" | "name68@gmai.com"  |
			| Content     | "Content" 		| 2      |"Name69" | "name69@gmai.com"  |
			
