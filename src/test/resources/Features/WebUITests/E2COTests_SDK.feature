@SDK

Feature: SDK Feature
  
#Scenario Outline: SdK Uploading
    #When user logs into MEC portal<user>
    #And user click on SDK menu
    #Then list of SDK is diasplayed
    #When user clicks on upload option 
    #And Enter all mandetory details<Version>, <description>
    #And click on upload button
    #Then SDK is uploaded successfully
    #
    #Examples:
    #| user | Version | description | 
    #|Admin| 1 | New SDK | 

    
Scenario Outline: SdK deleting
    When user logs into MEC portal<user>
    And user click on SDK menu
    Then list of SDK is diasplayed
    And click on uploaded Sdk
    And click on delete sdk button
    And SDK is deleted
    Then SDK is deleted is verified 
    
    Examples:
    | user | 
    |Admin| 