@myapplication

Feature: My Application Feature
  
Scenario Outline: Create new artifactId
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page
 		When user selects where to onboard application 
 		Then user is able to see that name
 		When user clicks on create new artifact
 		Then user is on artifact page
 		When user enters the details to create artifact <artifactname>, <componentId>, <componenetImageName> 
 		Then user submits the details and able to see successful message
 		When user clicks on select artifact
 		Then user able to see created artifact
	Examples:
 		| user | artifactname | componentId| componenetImageName | 
 		| Admin | app | mario | mario.tar |
