@Trobleshoot

Feature: Trobleshoot Feature
  
Scenario Outline: view running status of application in pods
    When user logs into MEC portal<user>
    And user is on Dashboard page
    And user click on troubleshoot menu
    And user enter all mandetory details<SheetName>, <RowNumber>
    And user click on apply button
    Then user able to view troubleshoot status
    Examples:
    | user | SheetName | RowNumber |
    | Admin | Trobleshoot | 0 |