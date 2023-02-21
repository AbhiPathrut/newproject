@Zones

Feature: Zones Feature
  
Scenario Outline: Create new zone and Check the functionality
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on zone button
 		Then verify zone list
 		When user clicks on create new zone
 		And user enter the details of new zone <zoneid>, <country>, <latitude>, <longitude>, <description>
 		Then clicks on a submit
 #		Then user is clicks close icon
	Examples:
 		| user | zoneid| country| latitude | longitude | description |
 		| Admin | NorthZone12345 |  | 2 |2| NA |
 #		| Admin | 113233 |76 |abc |asc |NA |
