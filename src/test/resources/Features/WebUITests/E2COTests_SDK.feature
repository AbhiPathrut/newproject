@SDKpage

Feature: SDK Feature
  
Scenario Outline: SdK Uploading
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on SDK menu
    Then list of SDK is diasplayed
    When user clicks on upload option 
    And Enter all mandetory details<SheetName>, <RowNumber>
    And click on upload button
    Then SDK is uploaded successfully
    
    Examples:
    | user | SheetName | RowNumber |
    |Admin| SDK | 0 |
    |Admin| SDK | 1 |
    |Admin| SDK | 2 |
    |Admin| SDK | 3 |
    |Admin| SDK | 4 |
    

    
Scenario Outline: SdK deleting
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on SDK menu
    Then list of SDK is diasplayed
    And click on uploaded Sdk<SheetName>, <RowNumber>
    And click on delete sdk button
    And SDK is deleted
    Then SDK is deleted is verified 
    
    Examples:
		| user | SheetName | RowNumber |
    |Admin| SDK | 0 |
    |Admin| SDK | 1 |
    |Admin| SDK | 2 |
    |Admin| SDK | 3 |
    |Admin| SDK | 4 |

 
#Scenario Outline: SdK end to end scenario
    #When user logs into MEC portal<user>
    #And user is on Dashboard page
    #And user click on SDK menu
    #Then list of SDK is diasplayed
    #When user clicks on upload option 
    #And Enter all mandetory details<SheetName>, <RowNumber>
    #And click on upload button
    #Then SDK is uploaded successfully
    #And click on uploaded Sdk<SheetName>, <RowNumber>
    #And click on delete sdk button
    #And SDK is deleted
    #Then SDK is deleted is verified
    #Examples:
    #| user | SheetName | RowNumber |
    #|Admin| SDK | 0 |
    #|Admin| SDK | 1 |    