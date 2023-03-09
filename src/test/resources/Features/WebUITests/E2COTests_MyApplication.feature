@myapplication

Feature: My Application Feature
  
Scenario Outline: Create new artifactId
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page
 		When user selects where to onboard application<SheetName>, <RowNumber>
 		Then user is able to see that service <service>
 		When user clicks on create new artifact
 		Then user is on artifact page
 		When user enters the details to create artifact <service>, <artifactname>, <componentId>, <componenetImageName>
 		Then user submits the details and able to see successful message
 		When user clicks on select artifact
 		Then user able to see created artifact
	Examples:
		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    #| Admin | MyApplication | 1 |

 	
#Scenario Outline: user able to delete artifact
 #		When user logs into MEC portal<user>
 #		And user is on Dashboard page
 #		And user clicks on my application
 #		Then user is on my application page 
 #		When user clicks on new application
 #		Then user is on new application page
 #		When user selects from where to artifact is to delete<SheetName>, <RowNumber> 
 #		Then user is able to see that service <service>	
#		When user clicks on select artifact
 #		Then user able to see artifacts uploaded
 #		When user selects the artifactid for delete
 #		And user clicks on delete button
 #		Then user is not able to find the deleted artifactId
 #		Examples:
 #		| user | SheetName | RowNumber |
    #| Admin | MyApplication | 0 |
    #| Admin | MyApplication | 1 |


Scenario Outline: user able to onboard application
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page	
		When user selects where to onboard application<SheetName>, <RowNumber>
		Then user is able to see that service <service>
 		When click on import button
 		Then upload file page is displayed
 		When upload the yaml file of application
 		And click on submit button
 		Then user is able to see uploaded data on page
 		When user clicks on select artifact
 		Then user able to see artifacts uploaded
 		When user selects the artifactid 
 		Then user clicks on done button
 		When update the details of application <SheetName>, <RowNumber> 
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |

 
Scenario Outline: user able to provision the application
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page
 		When user clicks on application<SheetName>, <RowNumber>
 		Then user is able to see the application details
 		When user selects the zone for application provision <zone>
 		And user click on provision buttton
 		Then user is able to see successful message for request
 		When user click on close button
 		Then user is able to see the application in running status
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |


 		
 Scenario Outline: user able to deprovision the application
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page
 		When clicks on application which is to deprovision<SheetName>, <RowNumber>
 		Then user is able to see the application details of provisioned app
 		When user clicks on deprovision button
 		Then user able to see warning message for deprovision
 		When user clicks on confirm button
 		Then user able to see the app is deprovisioned
Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
 		
 		