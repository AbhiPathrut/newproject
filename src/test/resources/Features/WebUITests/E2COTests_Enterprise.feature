@Enterprise

Feature: 
  
Scenario Outline: view running status of application in pods
    When user logs into MEC portal<user>
    And user is on Dashboard page
   	When user cliks on enterprise menu
   	Then user is on enterprise page
   	When user clicks on add new
   	
   
   
    Examples:
    | user | SheetName | RowNumber |
    | Admin | Trobleshoot | 0 |