@MyApplication

Feature: My Application Feature

@MyApplication_01
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
    #| Dev | MyApplication | 1 |
    

@MyApplication_02
Scenario Outline: user able to delete artifact
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page
 		When user selects from where to artifact is to delete<SheetName>, <RowNumber> 
 		Then user is able to see that service <service>	
		When user clicks on select artifact
 		Then user able to see artifacts uploaded
 		When user selects the artifactid for delete
 		And user clicks on delete button
 		Then user is not able to find the deleted artifactId
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    
    
    

@MyApplication_03
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
 		When user selects the artifactid<SheetName>, <RowNumber> 
 		Then user clicks on done button
 		When update the details of application 
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    #| Developer | MyApplication | 1 |
    

@MyApplication_04
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
    
    
@MyApplication_05
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
    
 		

@MyApplication_06
Scenario Outline: user able to deboard the application
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page
 		When clicks on application which is to deboard the application<SheetName>, <RowNumber>
 		Then user is able to see the application details of onboarded application
 		When user click on Deboarding button
 		Then user is able to see deboarding warning poupup messg 		
 		When user clicks on confirm button
 		Then user is able to see the application is removed from the list
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    
    
        
@MyApplication_07
Scenario Outline: My application end to end scenario
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
 		Then user able to see artifacts uploaded
 		When user selects the artifactid for delete
 		And user clicks on delete button
 		Then user is not able to find the deleted artifactId
 		When user selects the artifactid<SheetName>, <RowNumber> 
 		Then user clicks on done button
 		When click on import button
 		Then upload file page is displayed
 		When upload the yaml file of application
 		And click on submit button
 		Then user is able to see uploaded data on page
 		When user clicks on select artifact
 		Then user able to see artifacts uploaded
 		When user selects the artifactid<SheetName>, <RowNumber> 
 		Then user clicks on done button
 		When update the details of application  
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list
 		When user clicks on application<SheetName>, <RowNumber>
 		Then user is able to see the application details
 		When user selects the zone for application provision <zone>
 		And user click on provision buttton
 		Then user is able to see successful message for request
 		When user click on close button
 		Then user is able to see the application in running status
 		When clicks on application which is to deprovision<SheetName>, <RowNumber>
 		Then user is able to see the application details of provisioned app
 		When user clicks on deprovision button
 		Then user able to see warning message for deprovision
 		When user clicks on confirm button
 		Then user able to see the app is deprovisioned
 		When clicks on application which is to deboard the application<SheetName>, <RowNumber>
 		Then user is able to see the application details of onboarded application
 		When user click on Deboarding button
 		Then user is able to see deboarding warning poupup messg 		
 		When user clicks on confirm button
 		Then user is able to see the application is removed from the list
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    
 
 
@MyApplication_08
Scenario Outline: Create new artifactId for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
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
    | EntDev | MyApplication | 0 |
    
@MyApplication_09
Scenario Outline: user able to delete artifact for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page
 		When user selects from where to artifact is to delete<SheetName>, <RowNumber> 
 		Then user is able to see that service <service>	
		When user clicks on select artifact
 		Then user able to see artifacts uploaded
 		When user selects the artifactid for delete
 		And user clicks on delete button
 		Then user is not able to find the deleted artifactId
 		Examples:
 		| user | SheetName | RowNumber |
    | Enterprise | MyApplication | 0 |  
    
@MyApplication_10
Scenario Outline: user able to onboard application for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
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
 		When user selects the artifactid<SheetName>, <RowNumber> 
 		Then user clicks on done button
 		When the details of application for enterprise<SheetName>, <RowNumber> 
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list for enterprise
 		Examples:
 		| user | SheetName | RowNumber |
    | Enterprise | MyApplication | 0 | 
 		
 		
@MyApplication_11
Scenario Outline: user able to provision application for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
 		Then user is on my application page
 		When user clicks on application<SheetName>, <RowNumber>
 		Then user is able to see the application details
 		When user selects the zone for application provision <zone>
 		And user click on provision buttton
 		Then user is able to see successful message for request
 		When user click on close button
 		Then user is able to see the application in running status for enterprise
 		Examples:
 		| user | SheetName | RowNumber |
    | Enterprise | MyApplication | 0 |
    
@MyApplication_12
Scenario Outline: user able to deprovision application for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
 		Then user is on my application page
 		When clicks on application which is to deprovision<SheetName>, <RowNumber>
 		Then user is able to see the application details of provisioned app
 		When user clicks on deprovision button
 		Then user able to see warning message for deprovision
 		When user clicks on confirm button
 		Then user able to see the app is deprovisioned for enterprise
Examples:
 		| user | SheetName | RowNumber |
    | Enterprise | MyApplication | 0 |
    
@MyApplication_13
Scenario Outline: user able to deprovision application for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
 		Then user is on my application page
 		When clicks on application which is to deboard the application<SheetName>, <RowNumber>
 		Then user is able to see the application details of onboarded application
 		When user click on Deboarding button
 		Then user is able to see deboarding warning poupup messg 		
 		When user clicks on confirm button
 		Then user is able to see the application is removed from the list for enterprise
 		Examples:
 		| user | SheetName | RowNumber |
    | Enterprise | MyApplication | 0 |
 		
@MyApplication_14
Scenario Outline: Create new artifactId through manage artifact
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on manage artifact
 		Then user is able to see list of artifacts
 		When user clicks on create new artifact through Manage Artifact
 		Then create a artifact page is getting displaying
 		When user selects where to onboard application<SheetName>, <RowNumber>
 		Then user is able to seeing that service through manage artifact <service>
 		When user enters the details to create artifact <service>, <artifactname>, <componentId>, <componenetImageName>
 		Then user submits the details and able to see successful message
 		Then user able to see the crated artifact in list through manage artifact	
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
 		
@MyApplication_15
Scenario Outline: delete artifact through manage artifact
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on manage artifact
 		Then user is able to see list of artifacts
 		When user selects the artifact to delete through manage artifact
 		And user clicks on delete button
 		Then user is not able to find the deleted artifactId through manage artifact
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |		


    
@MyApplication_16
Scenario Outline: Create new artifactId through manage artifact for enterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
 		Then user is on my application page
 		When user clicks on manage artifact for eneterprise
 		Then user is able to see list of artifacts
 		When user clicks on create new artifact through Manage Artifact
 		Then create a artifact page is getting displaying
 		When user selects where to onboard application<SheetName>, <RowNumber>
 		Then user is able to seeing that service through manage artifact <service>
 		When user enters the details to create artifact <service>, <artifactname>, <componentId>, <componenetImageName>
 		Then user submits the details and able to see successful message
 		Then user able to see the crated artifact in list through manage artifact	
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
 		

@MyApplication_17 		
Scenario Outline: delete artifact through manage artifact for eneterprise
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application for enterprise
 		Then user is on my application page
 		When user clicks on manage artifact for eneterprise
 		Then user is able to see list of artifacts
 		When user selects the artifact to delete through manage artifact
 		And user clicks on delete button
 		Then user is not able to find the deleted artifactId through manage artifact
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    
@MyApplication_18
Scenario Outline: user able to onboard application through external repositry
 		When user logs into MEC portal<user>
 		And user is on Dashboard page
 		And user clicks on my application
 		Then user is on my application page 
 		When user clicks on new application
 		Then user is on new application page	
		When user selects where to onboard application<SheetName>, <RowNumber>
		Then user is able to see that service <service>
		When user selects external repositry
		Then external repositry page is displayed
		When click on import button
 		Then upload file page is displayed
 		When upload the yaml file of application for external repositry
 		And click on submit button
 		Then user is able to see uploaded data on page
 		When update the external repositry details of application<SheetName>, <RowNumber> 
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list
 		Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
		
@MyApplication_19
Scenario Outline: user able to view count of healthy application
      When user logs into MEC portal<user>
     	And user is on Dashboard page
 			And user clicks on my application
 			Then user is on my application page
      Then count of healthy application is displayed    
Examples:
    | user | 
    |Admin| 
    
    
@MyApplication_20
Scenario Outline: user able to view count of all applications
      When user logs into MEC portal<user>
      And user is on Dashboard page
 			And user clicks on my application
 			Then user is on my application page
      Then count of all application and consumption details is displayed    
Examples:
    | user | 
    |Admin|


@MyApplication_21
Scenario Outline: user able to onboard application with edge IS and onboarding application by doing edge OOS
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
 		When user selects the artifactid<SheetName>, <RowNumber> 
 		Then user clicks on done button
 		When update the details of application 
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list
 		And user clicks on Edges menu
    Then edges page is displayed
    When click on the edge which is to do Out-Of-Service<SheetName>, <RowNumber>
    Then Edge details page is displayed
    When user clicks on out of service button
    And out of service warning message is displayed
    And click on confirm button
    Then edge is in out-of-service status
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
 		When user selects the artifactid<SheetName>, <RowNumber> 
 		Then user clicks on done button
 		When update the details of application 
 		And Click on submit button
 		And user is able to see successful message for application onboard
 		Then user is can see the application in a list
    Examples:
 		| user | SheetName | RowNumber |
    | Admin | MyApplication | 0 |
    
@MyApplication_22
Scenario Outline: user able to view application instance details
      When user logs into MEC portal<user>
     	And user is on Dashboard page
 			And user clicks on my application
 			Then user is on my application page
      And click on specific application
      Then user able to view instance deatils 
Examples:
    | user | 
    |Admin| 

 		
 		    
 		
    