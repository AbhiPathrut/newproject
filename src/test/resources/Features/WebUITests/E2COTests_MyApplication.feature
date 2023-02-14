@myapplication

Feature: My Application Feature
  
Scenario Outline: Create new artifactId
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page
 		When user selects where to onboard application <service> 
 		Then user is able to see that service <service>
 		When user clicks on create new artifact
 		Then user is on artifact page
 		When user enters the details to create artifact <service>, <artifactname>, <componentId>, <componenetImageName> 
 		Then user submits the details and able to see successful message
 		When user clicks on select artifact
 		Then user able to see created artifact
	Examples:
 		| user | service | artifactname | componentId| componenetImageName | 
 		| Admin | container | app | mario | mario.tar |
		| Admin | VM | app | fedora | Fedora-Cloud-Base-36-1.5.x86_64.raw.xz |
 	
Scenario Outline: user able to delete artifact
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page
 		When user selects from where to artifact is to delete <service> 
 		Then user is able to see that service <service>	
		When user clicks on select artifact
 		Then user able to see artifacts uploaded
 		When user selects the artifactid for delete
 		And user clicks on delete button
 		Then user is not able to find the deleted artifactId
 		Examples:
 		| user | service |
 		| Admin | container |
 	
 		
 		