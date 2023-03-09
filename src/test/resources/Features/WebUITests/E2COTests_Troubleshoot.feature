@trobleshootpage

Feature: Trobleshoot Feature
  
Scenario Outline: TroubleShoot menu
    When user logs into MEC portal<user>
    And user click on troubleshoot menu
    And user enter all mandetory details<SheetName>, <RowNumber>
    And user click on apply button
    Then user able to view troubleshoot status
    Examples:
    | user | SheetName | RowNumber |
    | Admin | Trobleshoot | 0 |