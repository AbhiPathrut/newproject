@Edges
Feature: Edges Feature

Scenario Outline: preprovision the edge
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When  Click on  add new edge option
    Then New edge page is displayed
    When User enter all details <SheetName>, <RowNumber>
    And  User click on submit button
    Then New pre provsion edge is displayed <EdgeId>
    Examples:
    | user | SheetName | RowNumber | 
    | Admin | Edges | 0 |
    | Admin | Edges | 1 |
    
      
Scenario Outline: Deboard the edge
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When click on the edge which is to deboard<SheetName>, <RowNumber>
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
     | user | SheetName | RowNumber | 
     | Admin | Edges | 0 |
     | Admin | Edges | 1 |
 
#Scenario Outline: Edges end to end scenario
    #When user logs into MEC portal<user>
    #And user is on Dashboard page
    #And user clicks on Edges menu
    #Then edges page is displayed
    #When  Click on  add new edge option
    #Then New edge page is displayed
    #When User enter all details <SheetName>, <RowNumber>
    #And  User click on submit button
    #Then New pre provsion edge is displayed <EdgeId>
    #When click on the edge which is to deboard<SheetName>, <RowNumber>
    #Then Edge details page is displayed
    #When click on manage edge
    #Then Manage edge page is displayed
    #When click on deboard button
    #Then Deboarding warning message popup is diaplyed
    #When click on the confirm button
    #Then Zones page is dispalyed
    #When user is clicking on Edge menu
    #Then user is not able to see the edge which is deboarded
    #Examples:
    #| user | SheetName | RowNumber | 
    #| Admin | Edges | 0 |
    #| Admin | Edges | 1 |  