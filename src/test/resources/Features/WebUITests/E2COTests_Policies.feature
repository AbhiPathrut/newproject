@Policies

Feature: Policies
  
@Policy_01    
Scenario Outline: User able to set Edge policy
    When user logs into MEC portal<user>
    And user click on policy menu
    And user click on edge policy option
    Then Edge policy page is displayed
    When user select all policy related terms<SheetName>,<RowNumber>
    Then edge policy is successfully selected
Examples:
    | user | SheetName | RowNumber |  
    |Admin | EdgePolicy | 0 |
    
@Policy_02
Scenario Outline: User able to set Application policy with edge selection
    When user logs into MEC portal<user>
    And user click on policy menu
    And user click on Application policy option
    Then Application policy page is displayed
    When user select Application all application related term<SheetName>,<RowNumber>
    Then Application policy is successfully selected
Examples:
    | user | SheetName | RowNumber  |
    |Admin | AppPolicy | 0 |
    
@Policy_03
Scenario Outline: User able to set network policies
    When user logs into MEC portal<user>
    And user click on policy menu
    And user click on network policy option
    Then Network policy page is displayed
    When user select all mandetory details<SheetName>,<RowNumber>
    Then Network policy is successfully selected
Examples:
    | user | SheetName | RowNumber |
    |Admin | NetworkPolicy | 0 |