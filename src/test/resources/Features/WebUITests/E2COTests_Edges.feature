@Edges
Feature: Edges Feature

@Edges_01
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
    #| Admin | Edges | 1 |
    
@Edges_02      
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
     #| Admin | Edges | 1 |
     
     
     
@Edges_03 
Scenario Outline: Edges end to end scenario
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When  Click on  add new edge option
    Then New edge page is displayed
    When User enter all details <SheetName>, <RowNumber>
    And  User click on submit button
    Then New pre provsion edge is displayed <EdgeId>
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
    
@Edges_04
Scenario Outline: view the particular edge details
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When click on the edge for the details of edge<SheetName>, <RowNumber>
    Then Edge details page is displayed for the particular edge
    Examples:
     | user | SheetName | RowNumber | 
     | Admin | Edges | 0 |

@Edges_05
Scenario Outline: view the list of provisioned edges
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then provisioned list of edges displayed
    Examples:
     | user |
     | Admin | 

@Edges_06
Scenario Outline: edge out of service
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When click on the edge which is to do Out-Of-Service<SheetName>, <RowNumber>
    Then Edge details page is displayed
    When user clicks on out of service button
    And out of service warning message is displayed
    And click on confirm button
    Then edge is in out-of-service status
    Examples:
    | user | SheetName | RowNumber | 
    | Admin | Edges | 0 |
    
    
@Edges_07
Scenario Outline: edge in service
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed
    When click on edge which is to do IN-Service<SheetName>, <RowNumber>
    Then Edge details page is displayed
    When user clicks on in service button
    And in service warning message is displayed
    And click on confirm button
    Then edge in In-service status
    Examples:
    | user | SheetName | RowNumber | 
    | Admin | Edges | 0 |
    
  
@Edges_08
Scenario Outline: changing edge status to onboard to faulty and vice-versa by changing threshold values
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user clicks on Edges menu
    Then edges page is displayed observe status of edge
    When user clicks on system configuration menu
    Then system configuration page is displayed
    When user clicks on threshold settings option
    Then threshold settings page is displayed
    When user changes details for change config<SheetName>, <RowNumber>
    And click on submit button for system config
    And system config update successfully message displayed
    Then click on close button for system config
    And user clicks on Edges menu
    Then edges page is displayed observe status of edge
    Examples:
    | user | SheetName | RowNumber | 
    | Admin | Edges | 0 |
    | Admin | Edges | 1 |
     
    
 