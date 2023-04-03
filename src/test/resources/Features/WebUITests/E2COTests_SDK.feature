@SDK

Feature: SDK Feature
  
@SDK_01
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
    | Admin | SDK | 0 |
    #| Admin | SDK | 1 |
    #| Admin | SDK | 2 |
    #| Admin | SDK | 3 |
    #| Admin | SDK | 4 |
    

@SDK_02    
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
    #|Admin| SDK | 1 |
    #|Admin| SDK | 2 |
    #|Admin| SDK | 3 |
    #|Admin| SDK | 4 |


@SDK_03 
Scenario Outline: SdK end to end scenario
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on SDK menu
    Then list of SDK is diasplayed
    When user clicks on upload option 
    And Enter all mandetory details<SheetName>, <RowNumber>
    And click on upload button
    Then SDK is uploaded successfully
    And click on uploaded Sdk<SheetName>, <RowNumber>
    And click on delete sdk button
    And SDK is deleted
    Then SDK is deleted is verified
    Examples:
    | user | SheetName | RowNumber |
    |Admin| SDK | 0 |
    |Admin| SDK | 1 |    
    
@SDK_04 
Scenario Outline: user able to download sdk
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on SDK menu
    Then list of SDK is diasplayed
    And Select and click on Sdk for download<SheetName>, <RowNumber>
    And click on download option
    Then file downloaded successfully 
Examples:
		| user | SheetName | RowNumber |
    |Admin| SDK | 0 |
    
@SDK_05 
Scenario Outline: user is not able to upload duplicate sdk details
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on SDK menu
    Then list of SDK is diasplayed
    When user clicks on upload option 
    And Enter all mandetory details<SheetName>,<RowNumber>
    And click on upload button
    Then user not able to upload duplicate sdk  
Examples:
    | user | SheetName | RowNumber | 
    |Admin| SDK | 0 |
    
@SDK_06
Scenario Outline: user is not able to upload invalid file format
   When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on SDK menu
    Then list of SDK is diasplayed
    When user clicks on upload option 
    And Enter all mandetory details for invalid file formate<SheetName>,<RowNumber>
    And click on upload button
    Then user is not able to select invalid file format
Examples:
    | user | SheetName | RowNumber | 
    |Admin| SDK | 0 |