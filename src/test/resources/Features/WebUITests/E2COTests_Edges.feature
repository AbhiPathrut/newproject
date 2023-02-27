@Edges
Feature: Edges Feature
#
#Scenario Outline: Create new Admin user and verify login
 #		When user logs into MEC portal<user>
 #		And user is on Dashboard page
 #		And user clicks on Edges menu
 #		Then edges page is displayed
 #		When user clicks on add new edge
 #		Then Onboarding a New Edge page is displayed
 #		Examples:
#	| user |
#	| Admin |
	

#Scenario Outline: preprovision the edge
    #When user logs into MEC portal<user>
    #And user is on Dashboard page
    #And user clicks on Edges menu
    #Then edges page is displayed
    #When  Click on  add new edge option
    #Then New edge page is displayed
    #When User enter all details <EdgeId>, <ZoneId>, <Country>, <Latency>, <EnterpriseId>, <Bandwidth>, <Description>, <City>, <State>, <Locality>, <radio>, <MCC>, <MNC>, <CGI>, <TAC>, <Appavailble>, <LoadFilter>, <Cluster>, <Latitude>, <Longitude>
    #And  User click on submit button
    #Then New pre provsion edge is displayed <EdegID>
    #Examples:
    #| user | EdgeId | ZoneId | Country | Latency | EnterpriseId | Bandwidth | Description | City | State | Locality |  radio | MCC | MNC | CGI | TAC | Appavailble | LoadFilter | Cluster | Latitude | Longitude |
    #| Admin | edge | SouthZone | India | Low | default | 10 | edge description | Hyderabad | TN | Charminar | LTE | 404 | 04 | 1 | 12 | 2 | 2 | cluster | 12.4168 | -34.7038 |
    
    
#Scenario Outline: Onbaording edge using yaml file
#		 	When user logs into MEC portal<user>
#	 		And user is on Dashboard page
#	 		Then click on edge button
#	 		Then  click on add new edge button
#	 		And user upload the file
#	 		And user click on edgesubmmit btton
#	 		Examples:
 #		| user | 
 #		| Admin | 
 		
#Scenario Outline: Edge deboarding
    #When user logs into MEC portal<user>
    #And user is on dashboard page
    #And click on Zone menu
    #And click on any one zone
    #And click on edge
    #Then Edge details are diasplayed
    #When user click on manage option
    #And click on deboard option
    #Then Edge is deboarded successfully
    #Examples:
    #| user |
    #|Admin| 		
    
Scenario Outline: Deboard the edge
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When click on the edge which is to deboard
    Then Edge details page is displayed
    When click on manage edge
    Then Manage edge page is displayed
    When click on deboard button
    Then Deboarding warning message popup is diaplyed
    When click on the confirm button
    Then Zones page is dispalyed
    When user is clicking on Edge menu
    Then user is not able to see the edge which is deboarded
     Examples:
    | user |
    |Admin|  
    